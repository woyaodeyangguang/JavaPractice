package com.test.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 中介
 */
public class DynamicProxy implements InvocationHandler{

  // 这个就是需要代理的真实对象,即房东
  private Object subject;

  // 构造方法,需要给要代理的真实对象赋值
  public DynamicProxy(Object subject) {
    this.subject = subject;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    // 在代理真实对象之前，需要添加一些操作，中介收取中介费
    System.out.println("before " + method.getName() + " house");
    System.out.println("Method " + method.getName());
    // 如果方法是charge则收取中介费100元
    if(method.getName().equals("charge")) {
      method.invoke(subject, args);
      System.out.println("I will get 100 RMB ProxyCharge.");
    } else {
      method.invoke(subject, args);
    }
    // 在代理真实对象后需要添加一些自己的操作
    System.out.println("after" + method.getName() + " house");
    return null;
  }
}
