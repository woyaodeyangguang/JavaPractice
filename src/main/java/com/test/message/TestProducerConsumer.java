package com.test.message;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 生产者消费者.
 */
public class TestProducerConsumer {

  public static void main(String[] args) {
    BlockingQueue queue = new ArrayBlockingQueue(2);
    Consumer consumer = new Consumer(queue);
    Producer producer = new Producer(queue);
    for (int i = 0; i < 5 ; i++) {
      new Thread(consumer, "Consumer" + (i + 1)).start();
      new Thread(producer, "Producer" + (i + 1)).start();
    }
  }

}
