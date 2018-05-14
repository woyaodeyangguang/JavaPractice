package com.test.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class SocketServer {
  private static final int port = 55533;

  public static void main(String[] args) throws IOException {
    ServerSocket server = new ServerSocket(port);
    System.out.println("Server一直等待连接到来");
    // 阻塞直到发送数据
    Socket socket = server.accept();
    InputStream inputStream = socket.getInputStream();
    byte[] bytes = new byte[1024];
    int len = 0;
    StringBuilder stringBuilder = new StringBuilder();
    while((len = inputStream.read(bytes)) != -1) {
      stringBuilder.append(new String(bytes,0, len, "UTF-8"));
    }
    System.out.println("get message from client : " + stringBuilder.toString());
    inputStream.close();
    socket.close();
    server.close();
  }

}
