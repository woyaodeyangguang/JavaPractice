package com.test.gc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 测试BTrace 跟踪演示
 * HotSwap技术:代码热替换技术,Hotspot虚拟机允许在不停止运行的情况下，更新已经加载的类代码
 * Created by Admin on 2017/6/29.
 */
public class BTraceTest {
  public int add(int a, int b) {
    return a + b;
  }

  public static void main(String[] args) throws IOException {
    BTraceTest test = new BTraceTest();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    for (int i = 0; i < 10; i++) {
      reader.readLine();
      int a = (int) Math.round(Math.random() * 1000);
      int b = (int) Math.round(Math.random() * 1000);
      System.out.println(test.add(a, b));
    }
  }

}
