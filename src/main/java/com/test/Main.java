package com.test;

import java.util.PriorityQueue;

/**
 * Created by Admin on 2018/4/17.
 */
public class Main {
  public static void main(String[] args) {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    queue.add(1);
    queue.add(3);
    queue.add(2);
    queue.add(0);
    System.out.println(queue);
  }
}
