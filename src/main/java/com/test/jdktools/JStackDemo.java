package com.test.jdktools;

/**
 * jstack 命令
 * 死锁
 */
public class JStackDemo {
  public static void main(String[] args) {
    Thread thread1 = new Thread(new DeadLockClass(true));
    Thread thread2 = new Thread(new DeadLockClass(false));
    thread1.start();
    thread2.start();
  }
}

class DeadLockClass implements Runnable {
  // 控制线程
  public boolean flag;

  public DeadLockClass(boolean flag) {
    this.flag = flag;
  }

  public void run() {
    if(flag) {
      while (true) {
        synchronized(Suo.object1) {
          System.out.println("object1 " + Thread.currentThread().getName());
          synchronized (Suo.object2) {
            System.out.println("object2 " + Thread.currentThread().getName());
          }
        }
      }
    } else {
      while (true) {
        synchronized (Suo.object2) {
          System.out.println("object2 " + Thread.currentThread().getName());
          synchronized (Suo.object1) {
            System.out.println("object1 " + Thread.currentThread().getName());
          }
        }
      }
    }
  }
}

class Suo {
  static Object object1 = new Object();
  static Object object2 = new Object();
}
