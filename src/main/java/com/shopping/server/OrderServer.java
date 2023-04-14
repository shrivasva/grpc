package com.shopping.server;

import com.shopping.service.OrderServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderServer {
    private static final Logger logger = Logger.getLogger(OrderServer.class.getName());
    private Server server;

    private void startServer() {
        int port = 50052;
        try {
            server = ServerBuilder.forPort(port).addService(new OrderServiceImpl()).build().start();
            logger.log(Level.INFO, "Order service started on port "+ port);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                logger.log(Level.INFO, "server shutdown server interrupted");
                OrderServer.this.stopServer();
            }));
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    private void stopServer() {
        if (server != null) {
            try {
                server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
    }

    private void awaitShutdown() {
        if (server != null) {
            try {
                server.awaitTermination();
            } catch (InterruptedException e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        OrderServer orderServer = new OrderServer();
        orderServer.startServer();
        orderServer.awaitShutdown();
    }

}
