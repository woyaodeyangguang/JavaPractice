package com.test.thread.countdownlatch;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 是一个主启动类，负责初始化闭锁，然后等待，直到所有服务被检查完
 */
public class ApplicationStartupUtil {
  // list of service checker.
  private static List<BaseHealthChecker> services;
  // this latch will be used to wait on.
  private static CountDownLatch latch;

  public static class LazhHoder {
    private static final ApplicationStartupUtil INSTANCE = new ApplicationStartupUtil();

    public static ApplicationStartupUtil getInstance() {
      return INSTANCE;
    }
  }

  private ApplicationStartupUtil() {}

  public static boolean checkExternalServices() throws InterruptedException {
    // initial the latch with number of service checkers.
    latch = new CountDownLatch(3);
    services =  new LinkedList<>();
    services.add(new DatabaseHealthChecker(latch));
    services.add(new NetworkHealthChecker(latch));
    services.add(new CacheHealthChecker(latch));
    ExecutorService executor = Executors.newFixedThreadPool(services.size());
    for (BaseHealthChecker checker : services) {
      executor.execute(checker);
    }
    latch.await();
    for (BaseHealthChecker checker : services) {
      if(!checker.isServiceUp()) {
        return false;
      }
    }
    executor.shutdown();
    return true;
  }
}
