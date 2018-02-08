package com.test.collection;

import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Collection: ArrayList
 */
public class TestArrayList {

  private static final List<String> list = new ArrayList<String>() {{
    add("adc");
    add("def");
    add("ghi");
    add("jkl");
  }};

  public static void main(String[] args) {
    // 获取迭代器Iterator之后,无法修改原容器中的内容,若修改会抛出java.util.ConcurrentModificationException.
    Iterator<String> iterator = list.iterator();
    list.remove(3);
    while (iterator.hasNext()) {
      String info = iterator.next();
      System.out.println("info :" + info);
    }
  }

}
