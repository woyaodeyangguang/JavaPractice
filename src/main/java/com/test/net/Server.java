package com.test.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 网络编程Server
 */
public class Server {
  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(8080);
    Socket conn = serverSocket.accept();
    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
    String s = reader.readLine();
    while(s != null) {
      System.out.println(s);
      writer.write(s.toUpperCase() + "\n");
      writer.flush();
      s = reader.readLine();
    }
    reader.close();
    writer.close();
    conn.close();
  }
}
