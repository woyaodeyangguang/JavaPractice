package com.test.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2017/7/24.
 */
public class TestString {
  public static void main(String[] args) {
    String str1 = "abc";
    String str2 = "abc";
    String str3 = new String("abc");
    System.out.println(str1 == str2);
    System.out.println(str1 == str3);
    System.out.println(str1 == str3.intern());
    System.out.println("Hello World!");
    List<Integer> list1 = new ArrayList<Integer>();
    list1.add(1);
    list1.add(2);
    List<Integer> list2 = (List<Integer>) ((ArrayList)list1).clone();
    list2.add(1, 3);
  }

}
