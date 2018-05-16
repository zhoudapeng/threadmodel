package com.zdp.threadmodel.bio;

import com.zdp.threadmodel.Util;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by dapeng.zhou on 2017/4/1.
 */
public class ServerV3 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(Util.PORT);
        Executor executor = Executors.newFixedThreadPool(10);
        System.out.println("server starting...");
        while (true) {
            Socket socket = serverSocket.accept();
            executor.execute(new RequestHandlerThread(socket));
        }
    }
}
