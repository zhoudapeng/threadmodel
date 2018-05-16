package com.zdp.threadmodel.bio;

import com.zdp.threadmodel.Util;

import java.io.*;
import java.net.Socket;

/**
 * Created by dapeng.zhou on 2017/4/1.
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = null;
        BufferedWriter writer = null;
        BufferedReader reader = null;
        while (true) {
            try {
                socket = new Socket("localhost", Util.PORT);
                OutputStream outputStream = socket.getOutputStream();
                writer = new BufferedWriter(new OutputStreamWriter(outputStream, "utf-8"));
                writer.write("what is the time?");
                writer.newLine();
                writer.flush();
                InputStream inputStream = socket.getInputStream();
                reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                String response = reader.readLine();
                System.out.println("receive response:" + response);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                writer.close();
                reader.close();
                socket.close();
            }
            Thread.sleep(2000);
        }
    }
}
