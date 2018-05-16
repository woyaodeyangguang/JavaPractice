package com.test.classloader;

/**
 * 变量的初始化顺序
 */
public class TestInit extends FatherClass{
    private static final String str1 = "abc";
    private static String str2 = "def";
    private String str3 = "def";

    static {
        str2 = "new adc";
    }

    public static void main(String[] args) {
        new TestInit();
        System.out.println("Hello World");
    }
}

class FatherClass {
    private static String str4 = "hig";
    private String str5 = "lmn";

    static {
        str4 = "new hig";
    }
}

