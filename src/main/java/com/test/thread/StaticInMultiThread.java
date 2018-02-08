package com.test.thread;

/**
 * Java 内存模型
 * 1. 堆 所有的线程共享堆内存，new出来的对象和数组
 * 2. 方法区 所有的线程共享该方法区，例如存放类信息、静态变量、常亮等
 * 3. 程序计数器 线程私有,指向下一条需要执行的指令(除native代码外)
 * 4. java虚拟机栈 线程私有，每一个栈帧中包含 例如 局部变量表、操作数栈等，方法的调用过程，自动入栈
 *                 和出栈;ps栈空间的大小是有限的。
 * 5. 本地方法栈 与Java虚拟机栈类似，本地方法栈主要是给Native方法使用
 *
 * 多线程访问共享内存情况
 * 1. 什么情况下会出现异常情况：
 *        多个线程共享一块内存区域，在不加任何保护的情况下，对其操作。
 * 2. 什么情况下会得到正确的结果
 *        不适用共享内存，每个线程内存空间相互独立;
 *        多线程共享一块内存区域,但是对这块内存区域加锁访问。
 *
 */
public class StaticInMultiThread {
  public static void main(String[] args) {
    ThreadCount t1 = new ThreadCount();
    new Thread(t1).start();

    ThreadCount t2 = new ThreadCount();
    new Thread(t2).start();

    ThreadCount t3 = new ThreadCount();
    new Thread(t3).start();

  }
}

class StaticTest {
  private static int s = 0;
  //public static int sum(int n) {
  public synchronized static int sum(int n) {
    s = 0;
    // 不使用共享内存
    //int s = 0;
    for (int i = 0; i <= n; i++) {
      s += i;
      try{
        Thread.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    return s;
  }
}

class ThreadCount implements Runnable {

  public void run() {
    while (true) {
      System.out.println(Thread.currentThread().getName() + ":" + StaticTest.sum(100));
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
