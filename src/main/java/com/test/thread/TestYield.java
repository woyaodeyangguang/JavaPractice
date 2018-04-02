package com.test.thread;

/**
 * yield方法意味着放手、放弃
 * 调用yield()方法的线程就是告诉虚拟机它乐意让其他线程占用自己的位置,
 *     表名该线程并没有做一些紧急的事情,仅仅是一个暗示
 * 它能够使一个线程从运行状态转成可运行状态，而不是等待或者阻塞状态.
 */
public class TestYield implements Runnable {

  @Override
  public void run() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    for (int i = 0; i < 5; i++) {
      System.out.println(Thread.currentThread().getName() + ":" + i);
      Thread.yield();
    }
  }

  public static void main(String[] args) {
    TestYield runnable = new TestYield();
    Thread thread1 = new Thread(runnable, "FirstThread");
    Thread thread2 = new Thread(runnable, "SecondThread");
    thread1.start();
    thread2.start();
  }
}
