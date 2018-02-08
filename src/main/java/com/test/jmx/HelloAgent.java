package com.test.jmx;

import java.lang.management.ManagementFactory;
import javax.management.MBeanServer;
import javax.management.ObjectName;

/**
 * Created by Admin on 2017/7/4.
 */
public class HelloAgent {
  public static void main(String[] args) throws Exception {
    // 通过工厂类获取MBeanServer
    MBeanServer server = ManagementFactory.getPlatformMBeanServer();
    // ObjectName中取名有一定的规范,格式为"域名:name=MBean名称"
    ObjectName helloName = new ObjectName("jmxBean:name=hello");
    // Hello这个类注入到MBeanServer中
    server.registerMBean(new Hello(), helloName);
    Thread.currentThread().sleep(60 * 60 * 1000);
  }
}
