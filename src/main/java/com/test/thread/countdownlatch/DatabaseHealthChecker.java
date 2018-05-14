package com.test.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 数据库检查
 */
public class DatabaseHealthChecker extends BaseHealthChecker{

  public DatabaseHealthChecker(CountDownLatch countDownLatch) {
    super(countDownLatch, "DatabaseHealthChecker");
  }

  @Override
  public void verifyService() {
    System.out.println("Checking " + this.getServiceName());
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(this.getServiceName() + " is UP");
  }
}
