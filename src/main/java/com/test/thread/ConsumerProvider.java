package com.test.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 利用wait() notifyAll()实现生产者、消费者模式
 */
public class ConsumerProvider {
  private static Queue<Task> queue = new LinkedList<>();
  private static final int SIZE = 20;
  private static AtomicInteger decCount = new AtomicInteger(0);

  public static boolean add(Task task) {
    synchronized (queue) {
      if(queue.size() > SIZE) {
        return false;
      }
      queue.offer(task);
      queue.notifyAll();
      return true;
    }
  }

  public static Task get() {
    Task task;
    String name = Thread.currentThread().getName();
    synchronized (queue) {
      if(queue.size() == 0) {
        try {
          System.out.println(name + "无法获取商品");
          queue.wait();
          System.out.println(name + "重新获取商品");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      task = queue.poll();
      decCount.incrementAndGet();
    }

    // 控制线程同时退出
    while(true) {
      if(decCount.get() == SIZE) {
        break;
      }
    }
    System.out.println(name + " 退出");
    return task;
  }

  public static void main(String[] args) {
    for (int i = 0; i < 20; i++) {
      new Thread(() -> add(new Task())).start();
      new Thread(() -> get()).start();
    }

  }
  private static class Task {}
}
