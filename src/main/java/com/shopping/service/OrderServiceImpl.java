package com.shopping.service;

import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Timestamps;
import com.shopping.db.Order;
import com.shopping.db.OrderDao;
import com.shopping.stubs.order.OrderRequest;
import com.shopping.stubs.order.OrderResponse;
import com.shopping.stubs.order.OrderServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImpl extends OrderServiceGrpc.OrderServiceImplBase {
    OrderDao orderDao = new OrderDao();

    @Override
    public void getOrderForUser(OrderRequest request, StreamObserver<OrderResponse> responseObserver) {
        List<Order> orderList = orderDao.getOrderDetailsForUser(request.getUserId());
        List<com.shopping.stubs.order.Order> orderProtoList = orderList.stream().map(order -> com.shopping.stubs.order.Order.newBuilder()
                .setOrderId(order.getOrderId())
                .setUserId(order.getUserId())
                .setTotalAmount(order.getTotalAmount())
                .setNoOfItems(order.getNoOfItems())
                .setOrderDate(Timestamps.fromMillis(order.getOrder_date().getTime())).build()).collect(Collectors.toList());
        OrderResponse orderResponse = OrderResponse.newBuilder().addAllOrder(orderProtoList).build();
        responseObserver.onNext(orderResponse);
        responseObserver.onCompleted();
    }
}
