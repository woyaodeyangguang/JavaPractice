package com.test.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 网络服务检查.
 */
public class NetworkHealthChecker extends BaseHealthChecker{


  public NetworkHealthChecker(CountDownLatch countDownLatch) {
    super(countDownLatch, "Network Service");
  }

  @Override
  public void verifyService() {
    System.out.println("Checking " + this.getServiceName());
    try {
      Thread.sleep(7000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(this.getServiceName() + " is UP");
  }

}
