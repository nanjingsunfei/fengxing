package cn.njupt.thread.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by sunfei on 2018/7/22.
 */
public class ThreadPerTaskWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        while (true) {
            final Socket connection = serverSocket.accept();
            new Thread(() -> {
                handleRequest(connection);
            }).start();
        }
    }

    public static void handleRequest(Socket socket) {

    }
}
