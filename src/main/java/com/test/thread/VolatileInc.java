package com.test.thread;


/**
 * volatile并不能保证原子性.
 */
public class VolatileInc implements Runnable{
  // 使用volatile修饰基本数据内存不能保证原子性
  private static int count = 0;
  //private static AtomicInteger count = new AtomicInteger(0);

  @Override
  public void run() {
    for (int i = 0; i < 10000; i++) {
      count++;
      // count.incrementAndGet():
    }
  }
  public static void main(String[] args) throws InterruptedException {
    VolatileInc volatileInc = new VolatileInc();
    Thread thread1 = new Thread(new VolatileInc(), "t1");
    Thread thread2 = new Thread(new VolatileInc(), "t2");
    thread1.start();
    thread2.start();
    thread1.join();
    thread2.join();
    System.out.println("最终Count = " + count);
  }
}
