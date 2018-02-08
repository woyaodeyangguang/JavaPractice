package com.test.thread;

/**
 * Created by Admin on 2017/8/9.
 */
public class TestWait {
  private static Object object = new Object();
  private static final String THREADA = "threada";
  private static final String THREADB = "threadb";
  private static boolean flag = false;

  public static void main(String[] args) {
    Thread thread1 = new Thread(THREADA) {
      @Override
      public void run() {
        String threadName = Thread.currentThread().getName();
        synchronized (object) {
            System.out.println(threadName + " own monitor");
            try {
              Thread.currentThread().sleep(2);
              System.out.println(threadName + " release monitor");
              flag = true;
              object.wait();
              System.out.println(threadName + " resume work");
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
      }
    };
    Thread thread2 =
        new Thread(THREADB) {
          @Override
          public void run() {
            String threadName = Thread.currentThread().getName();
            while (!flag) {
              System.out.println(threadName + " retry");
            }
            synchronized (object) {
              object.notifyAll();
            }
          }
        };
    thread1.start();
    thread2.start();
  }
}
