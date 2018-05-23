package com.test.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCollections {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("6", "1", "3", "1", "2");
        // 归并算法
        // 策略模式
        Collections.sort(strings);
        for(String string : strings) {
            System.out.println(string);
        }
    }
}
