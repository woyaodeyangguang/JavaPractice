package com.test.net;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * URL use case.
 */
public class URLUseCase {
  public static void main(String[] args) throws Exception {
    URL url = new URL("http://www.baidu.com");
    URLConnection connection = url.openConnection();
    InputStream inputStream = connection.getInputStream();
    byte[] buffer = new byte[1024];
    int flag = 0;
    while(-1 != (flag = inputStream.read(buffer, 0, buffer.length))) {
      System.out.println(new String(buffer));
    }
    inputStream.close();
  }
}
