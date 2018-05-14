package com.test.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Cache检查
 */
public class CacheHealthChecker extends BaseHealthChecker{

  public CacheHealthChecker(CountDownLatch countDownLatch) {
    super(countDownLatch, "CacheHealthChecker");
  }

  @Override
  public void verifyService() {
    System.out.println("Checkintg " + this.getServiceName());
    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(this.getServiceName() + " is UP");
  }
}
