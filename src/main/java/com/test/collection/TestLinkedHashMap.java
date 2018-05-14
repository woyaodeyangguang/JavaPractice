package com.test.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Admin on 2018/3/30.
 */
public class TestLinkedHashMap {
  private static Map<String, Integer> hashMap = new HashMap<>();
  private static Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
  private static Map<String, Integer> lruCache =
          new LinkedHashMap<>(16, 0.75f, true);


  static {
    hashMap.put("张三", 20);
    hashMap.put("李四", 25);
    hashMap.put("王五", 30);

    linkedHashMap.put("张三", 20);
    linkedHashMap.put("李四", 25);
    linkedHashMap.put("王五", 25);
    linkedHashMap.put("张三", 22);

    lruCache.put("张三", 20);
    lruCache.put("李四", 25);
    lruCache.put("王五", 25);
    lruCache.put("张三", 22);
  }

  public static void main(String[] args) {
    print(hashMap);
    print(linkedHashMap);
    print(lruCache);
  }

  public static void print(Map<String, Integer> map) {
    System.out.println(map.getClass().getName());
    for(Map.Entry<String, Integer> entry : map.entrySet()) {
      System.out.print("[" +  entry.getKey() + ":" + entry.getValue()  + "]");
    }
    System.out.println();
  }


}
