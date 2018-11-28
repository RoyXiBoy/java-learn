package io.io.Socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by xlt on 20180319.
 */
public class SocketClient {

    public static void main(String[] args) {

        String host = "127.0.0.1";

        int port = 60001;

        try(Socket socket = new Socket(host, port);
            OutputStream outputStream = socket.getOutputStream()){

            String message = "hello world";

            socket.getOutputStream().write(message.getBytes());

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
