package com.test.socket;

import java.io.UnsupportedEncodingException;

/**
 * Created by Admin on 2018/3/29.
 */
public class Main {
  public static void main(String[] args) throws UnsupportedEncodingException {
    String str1 = "hello";
    System.out.println(str1.getBytes("UTF-8").length);
    String str2 = "中";
    System.out.println(str2.getBytes("UTF-8").length);
    System.out.println(str2.getBytes("GBK").length);
  }

}

