package com.test.thread;

import java.util.concurrent.TimeUnit;

/**
 * JMM 保证了happens-before，保证了对volatile的读happens-before发生于对volatile的写，
 *     强制将volatile的写入立即写入到Main Memory中，强制将volatile的读从Main Memory中读取.
 * volatile 保证了内存可见性，但是并不能保证线程安全操作.
 * volatile 禁止了指令重排.
 */
public class Volatile implements Runnable{

  // 如果没有用volatile,则线程ThreadA则会停止的更慢
  private static boolean flag = true;
  private volatile int count = 0;

  @Override
  public void run() {
    while (flag) {
      System.out.println(Thread.currentThread().getName() + " 正在运行");
      count++;
    }
    System.out.println(Thread.currentThread().getName() + " 运行结束, 总运行次数" + count);
  }

  public static void main(String[] args) throws InterruptedException {
    Volatile aVolatileThread = new Volatile();
    new Thread(new Volatile(), "ThreadA").start();
    System.out.println("main线程正在执行");
    TimeUnit.MILLISECONDS.sleep(100);
    aVolatileThread.stop();
  }

  public void stop() {
    flag = false;
  }
}
