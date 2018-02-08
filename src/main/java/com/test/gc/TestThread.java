package com.test.gc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Admin on 2017/6/29.
 */
public class TestThread {

  /**
   * 线程死循环演示
   */
  public static void createBusyThread() {
    Thread thread = new Thread(new Runnable() {
      public void run() {
        while (true)
          ;
      }
    }, "testBusyThread");
    thread.start();
  }

  /**
   * 线程锁等待演示
   */
  public static void createLockThread(final Object lock) {
    Thread thread = new Thread(new Runnable() {
      public void run() {
        synchronized (lock) {
          try{
            System.out.println("===wait===");
            lock.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }, "testLockThread");
    thread.start();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine();
    createBusyThread();
    br.readLine();
    Object object = new Object();
    createLockThread(object);
  }
}
