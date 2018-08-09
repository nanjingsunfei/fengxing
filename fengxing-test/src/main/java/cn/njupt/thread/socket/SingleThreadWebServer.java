package cn.njupt.thread.socket;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by sunfei on 2018/7/22.
 */
public class SingleThreadWebServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(80);
        while (true) {
            Socket connection = serverSocket.accept();
            handleRequest(connection);
        }

    }

    public static void handleRequest(Socket socket) {

    }
}
