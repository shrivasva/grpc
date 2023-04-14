package com.shopping.service;

import com.shopping.client.OrderClient;
import com.shopping.db.User;
import com.shopping.db.UserDao;
import com.shopping.stubs.order.Order;
import com.shopping.stubs.user.Gender;
import com.shopping.stubs.user.UserRequest;
import com.shopping.stubs.user.UserResponse;
import com.shopping.stubs.user.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.List;

public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {
    @Override
    public void getUserDetails(UserRequest request, StreamObserver<UserResponse> responseObserver) {
        UserDao userDao = new UserDao();
        User user = userDao.getUserDetail(request.getUsername());
        ManagedChannel managedChannel = ManagedChannelBuilder.forTarget("localhost:50052").usePlaintext().build();
        OrderClient orderClient = new OrderClient(managedChannel);
        List<Order> orderList = orderClient.getOrders(user.getId());
        managedChannel.shutdownNow();
        UserResponse userResponse = UserResponse.newBuilder().
                setAge(user.getAge()).
                setId(user.getId()).
                setName(user.getName()).
                setUsername(user.getUsername()).
                setGender(Gender.valueOf(user.getGender())).
                setNoOfOrders(orderList.size()).
                build();


        responseObserver.onNext(userResponse);
        responseObserver.onCompleted();
    }
}
