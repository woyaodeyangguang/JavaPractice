package com.test.javaenum;

import java.io.Serializable;
import java.nio.channels.Selector;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Admin on 2017/7/14.
 */
public class TestEnum {
  public static void main(String[] args) {
    for (Color color : Color.values()) {
      color.printValue();
    }
  }
}

/**
 * Java枚举跟其他普通类很像，在其内部包含了一堆预先定义的对象集合
 * 什么情况下需要使用枚举,一个比较好的使用场合是组织无效参数.
 *    eg.public void doSomeThingWithColor(int color); 模棱两可的接口,开发人员不知道传入什么参数.
 *       public void doSomeThingWithColor(Color color);使用枚举类型,大大增强代码的可读性.
 *
 */
enum Color {
  // each item is an instance.
  RED(1), YELLOW(2), BLUE(3);

  private int value;
  private Color(int i) {
    this.value = i;
  }
  public void printValue() {

    System.out.println(this.value);
    // ordinal 方法 返回每一个枚举常亮在类型中的数字位置
    System.out.println("ordinal is :" + this.ordinal());
    System.out.println(this.name());
  }
}
