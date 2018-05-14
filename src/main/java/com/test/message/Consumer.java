package com.test.message;

import java.util.concurrent.BlockingQueue;

/**
 * 消费者.
 */
public class Consumer implements Runnable{

  private BlockingQueue<Object> queue;

  public Consumer(BlockingQueue<Object> queue) {
    this.queue = queue;
  }


  @Override
  public void run() {
    try {
      System.out.println(Thread.currentThread().getName() + "已经消费!");
      queue.take();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
