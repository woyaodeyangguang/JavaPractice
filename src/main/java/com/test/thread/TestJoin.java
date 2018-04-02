package com.test.thread;


/**
 * join方法的作用是父线程等待子线程执行完成后再执行，将异步执行的线程合并为同步线程.
 */
public class TestJoin {

  public static void main(String[] args) throws InterruptedException {
    Thread thread =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                try {
                  System.out.println("线程执行");
                  Thread.sleep(5000);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            });
    thread.start();
    System.out.println("start");
    thread.join();
    System.out.println("end");
  }
}
