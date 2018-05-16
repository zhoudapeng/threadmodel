package com.zdp.threadmodel.bio;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by dapeng.zhou on 2017/4/1.
 */
public class ServerV2 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(Util.PORT);
        System.out.println("server starting...");
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new RequestHandlerThread(socket)).start();
        }
    }
}
