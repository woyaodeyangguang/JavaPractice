package com.test.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Java反射：
 *     指的是在运行状态时,能够获取类的属性和方法或者修改类运行时的行为过程
 * 获取Class对象
 *     1.Class类的forName()方法,动态加载，运行时开始加载类并做类的初始化
 *     2.对象getClass()方法,静态加载(编译时已加载)
 *     3.class语法,静态加载(编译时已加载)
 */
public class TestLoadClass {
  public static void main(String[] args) throws ClassNotFoundException {
    // Class类forName()加载类对象,并做类初始化
    // Class<?> clazz = Class.forName("com.test.reflection.Simple");

    // 对象getClass()方法加载类对象
    // Simple simple = new Simple();
    // Class<?> clazz = simple.getClass();

    // class语法
    Class<Simple> clazz = Simple.class;
    try {
      Simple simpleInstance = clazz.newInstance();
      Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
      constructor.setAccessible(true);
      Simple newSimpleInstance = (Simple) constructor.newInstance("...");
      newSimpleInstance.message();
      Method method = clazz.getDeclaredMethod("cube", new Class[]{int.class});
      // 设置私有方法的访问权限
      method.setAccessible(true);
      method.invoke(newSimpleInstance, 2);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println(clazz.getName());
    System.out.println(clazz.getSimpleName());
    System.out.println(clazz.isInterface());
  }
}

class Simple {
  private String msg;

  static {
    System.out.println("static code block!");
  }

  public Simple() {
    System.out.println("Simple constructor!");
  }

  public void message() {
    System.out.println("Hello Java," + msg);
  }

  public Simple(String msg) {
    this.msg = msg;
  }

  private void cube(int n) {
    System.out.println(n * n * n);
  }

}
