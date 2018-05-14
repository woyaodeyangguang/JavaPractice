package com.test.thread.countdownlatch;

/**
 * 测试
 */
public class Main {
  public static void main(String[] args) {
    boolean result = false;
    try {
      result = ApplicationStartupUtil.checkExternalServices();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("External services validation completed !! Result was :: " + result);
  }
}
