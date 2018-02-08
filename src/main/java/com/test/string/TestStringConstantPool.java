package com.test.string;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 测试常量池
 * 常量池属于Method Area,不断的往常量池中添加会出现OOM
 * Created by Admin on 2017/6/16.
 */
public class TestStringConstantPool {
  public static void main(String[] args) {
    // 使用List保持常量池引用,避免Full GC回收常量池行为
    List<String> list = new ArrayList<String>();
    int i = 0;
    while (true) {
      System.out.println("---adding---");
      list.add(String.valueOf(i++).intern());
    }
  }
}
