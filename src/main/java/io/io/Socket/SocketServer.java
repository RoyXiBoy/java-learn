package io.io.Socket;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xlt on 20180316.
 */
public class SocketServer {

    public static void main(String[] args) {

       int port = 60001;

        try (ServerSocket server = new ServerSocket(port);
             Socket socket = server.accept();
             //建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
             InputStream inputStream = socket.getInputStream()){

            System.out.println("server将一直等待连接的到来");
            byte[] bytes = new byte[1024];
            int len;

            StringBuilder sb = new StringBuilder();
            while ((len = inputStream.read(bytes)) != -1) {
                //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
                sb.append(new String(bytes, 0, len,"UTF-8"));
            }
            System.out.println("get message from client: " + sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
