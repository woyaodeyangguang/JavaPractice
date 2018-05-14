package com.test.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Admin on 2018/3/29.
 */
public class ServerClient {
  private static final int port = 55533;
  private static final String ip = "127.0.0.1";
  public static void main(String[] args) throws IOException {
    Socket socket = new Socket(ip, port);
    // 建立连接后获得输出流
    OutputStream outputStream = socket.getOutputStream();
    String message = "Hello";
    outputStream.write(message.getBytes("UTF-8"));
    outputStream.close();
    socket.close();
  }
}
