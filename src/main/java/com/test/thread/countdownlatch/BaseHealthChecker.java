package com.test.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

/**
 * 该类是一个Runnable，负责所有特定的外部服务健康监测，它删除了重复的代码和闭锁的中心控制代码
 */
public abstract class BaseHealthChecker implements Runnable{
  private CountDownLatch countDownLatch;
  private String serviceName;
  private boolean serviceUp;

  public BaseHealthChecker(CountDownLatch countDownLatch, String serviceName) {
    this.countDownLatch = countDownLatch;
    this.serviceName = serviceName;
    this.serviceUp = false;
  }

  @Override
  public void run() {
    try{
        verifyService();
        serviceUp = true;
    } catch (Throwable t) {
      t.printStackTrace(System.err);
      serviceUp = false;
    } finally{
      if(countDownLatch != null) {
        countDownLatch.countDown();
      }
    }
  }

  public String getServiceName() {
    return serviceName;
  }

  public boolean isServiceUp() {
    return serviceUp;
  }

  public abstract void verifyService();
}
