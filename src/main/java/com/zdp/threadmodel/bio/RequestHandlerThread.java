package com.zdp.threadmodel.bio;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dapeng.zhou on 2017/4/6.
 */
public class RequestHandlerThread implements Runnable {
    public RequestHandlerThread(Socket socket) {
        this.socket = socket;
    }

    private Socket socket;

    public void run() {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            String request = reader.readLine();
            System.out.println(Thread.currentThread() + "receive request:" + request);
            writer = new BufferedWriter(new OutputStreamWriter(outputStream, "utf-8"));
            writer.write(Thread.currentThread() + "the time is " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            writer.newLine();
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                reader.close();
                socket.close();
            } catch (Exception e) {

            }
        }
    }
}
