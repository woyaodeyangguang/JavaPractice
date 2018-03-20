package com.test.dynamicproxy.cglib;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * CGLIB sample class.
 * 如果一个类只是一个普通的类，没有实现接口，则需要使用CGLIB来实现动态代理.
 */
public class SampleClass {
  public void test() {
    System.out.println("Hello world.");
  }

  public static void main(String[] args) {
    // Enhancer 既能代理普通的Class,也能代理接口
    // Enhancer 创建一个被代理对象的子类并且拦截所有的方法调用.
    // Enhancer 不能够拦截final方法,例如Object.getClass()方法,这是由于final的语义决定的
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(SampleClass.class);
    enhancer.setCallback(
        new MethodInterceptor() {
          @Override
          public Object intercept(
              Object obj, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
            System.out.println("before method rum...");
            Object result = proxy.invokeSuper(obj, args);
            System.out.println("after method...");
            return result;
          }
        });
    SampleClass sample = (SampleClass) enhancer.create();
    sample.test();
  }

}
