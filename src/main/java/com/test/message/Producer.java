package com.test.message;

import java.util.concurrent.BlockingQueue;

/**
 * 生产者.
 */
public class Producer implements Runnable{
  private BlockingQueue<Object> queue;

  public Producer(BlockingQueue<Object> queue) {
    this.queue = queue;
  }


  @Override
  public void run() {
    try {
      System.out.println(Thread.currentThread().getName() + "生产对象");
      queue.put(new Object());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
