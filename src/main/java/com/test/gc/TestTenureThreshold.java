package com.test.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * 大对象直接进入老年代
 * Created by Admin on 2017/7/5.
 */
public class TestTenureThreshold {
  private static final int _1MB = 1024 * 1024;

  public static void main(String[] args) {
    //byte[] allocation;
    //allocation = new byte[4 * _1MB];
    List list = new ArrayList();
    list.add(1);
    list.add(2);
    list.add(0, 0);
    System.out.println(list);

  }

}
