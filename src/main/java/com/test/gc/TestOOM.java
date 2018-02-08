package com.test.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试Out Of Meory.
 * VM Args: -Xms100M -Xmx100M -XX:+UseSerialGC
 */
public class TestOOM {
  static class OOMObject {
    public byte[] placeholder = new byte[64 * 1024];
  }

  public static void fillHeap(int num) throws InterruptedException {
    List<OOMObject> list = new ArrayList<OOMObject>();
    for(int i = 0; i < num; i++) {
      // 稍作延时,令监视曲线的变化更加明显
      Thread.currentThread().sleep(50);
      System.out.println("----adding----");
      list.add(new OOMObject());
    }
    System.out.println("----end----");
    // list对象仍然存活,无法进行回收
    // System.gc();
    // Thread.currentThread().sleep(500000);
  }

  public static void main(String[] args) throws InterruptedException {
    fillHeap(1000);
    System.gc();
    Thread.currentThread().sleep(500000);
  }

}
