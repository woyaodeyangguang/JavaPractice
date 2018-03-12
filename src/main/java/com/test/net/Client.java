package com.test.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 网络编程Client
 */
public class Client {
  public static void main(String[] args) throws IOException {
    Socket conn = new Socket("127.0.0.1", 8080);
    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
    writer.write("hello\n");
    writer.flush();
    String s = reader.readLine();
    System.out.println("Client receive : " + s);
    writer.write("world\n");
    writer.flush();
    s = reader.readLine();
    System.out.println("Client receive : "+ s);
    reader.close();
    writer.close();
    conn.close();
  }
}
