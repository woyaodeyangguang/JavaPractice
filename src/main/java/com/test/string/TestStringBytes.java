package com.test.string;

import java.io.UnsupportedEncodingException;

/**
 * Created by Admin on 2017/10/8.
 */
public class TestStringBytes {

  /**
   * 每种编码所占的字节数都不一样
   * @param args
   * @throws UnsupportedEncodingException
   */
  public static void main(String[] args) throws UnsupportedEncodingException {
    String str = "中国abc";
    int len = str.getBytes("GB2312").length;
    System.out.println("GB2312 " + len);
    len = str.getBytes().length;
    System.out.println("UTF-8 " + len);
  }

}
