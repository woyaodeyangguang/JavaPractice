package com.test.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 客人
 */
public class Client {
  public static void main(String[] args) {
    // 需要代理的真实对象--房东
    HouseOwner houseOwner = new HouseOwner();
    // 需要代理的哪个真实对象，就将该对象传入进去，最后通过该真实对象来调用其方法

    InvocationHandler handler = new DynamicProxy(houseOwner);
    /**
     * 一个动态代理类 -- 中介
     * 通过Proxy的newProxyInstance方法来创建代理对象
     * 第一个参数handler.getClass().getClassLoader()通过使用handler这个类ClassLoader加载代理对象
     * 第二个参数realSubject.getClass().getInterfaces()，这里为代理对象提供的接口是真实所实行的接口
     *           ，表示要代理的是该真实对象
     * 第三个参数handler，这里将代理的对象关联到上方的InvocationHandler这个对象上
     */
    RentHouse rentHouse = (RentHouse) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
        houseOwner.getClass().getInterfaces(), handler);
    System.out.println(rentHouse.getClass().getName());
    rentHouse.rent();
    //rentHouse.charge("1000");
  }
}
