package com.shopping.server;

import com.shopping.service.UserServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserServer {
    private Logger logger = Logger.getLogger(UserServer.class.getName());
    private Server server;

    public void startServer() {
        int port = 50051;
        try {
            server = ServerBuilder.forPort(port).addService(new UserServiceImpl()).build().start();
            logger.log(Level.INFO, "User service started on port "+ port);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                logger.log(Level.INFO,"server shutdown server interrupted");
                UserServer.this.stopServer();
            }));
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

    }
    public void stopServer(){
        if(server != null){
            try {
                server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
    }
    public void blockUntilShutdown(){
        if(server != null){
            try {
                server.awaitTermination();
            } catch (InterruptedException e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        UserServer userSerer = new UserServer();
        userSerer.startServer();
        userSerer.blockUntilShutdown();
    }
}
