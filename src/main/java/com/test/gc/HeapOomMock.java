package com.test.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * Out of Memory Exception.
 */
public class HeapOomMock {
  public static void main(String[] args) {
    List<byte[]> list = new ArrayList<>();
    int i = 0;
    boolean flag = true;
    while (flag) {
      try{
        i++;
        list.add(new byte[1024 * 1024]);
        Thread.currentThread().sleep(100);
      } catch (Throwable e) {
        e.printStackTrace();
        flag = false;
        System.out.println("Cout = " + i);
      }
    }
  }

}
