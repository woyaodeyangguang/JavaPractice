package com.test.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 测试环境下的反序列化保持单例特性
 */
public class TestSingleton {
  public static void main(String[] args) throws Exception {
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("rectangle"));
    out.writeObject(Rectangle.getInstance());
    out.close();

    ObjectInputStream in = new ObjectInputStream(new FileInputStream("rectangle"));
    Object newRectangle = in.readObject();
    in.close();
    // 将获取的对象和单例实例对象进行相等性比较，若要反序列化后的单例的相等性则该类中需要实现方法
    // readResolve方
    System.out.println(Rectangle.getInstance() == newRectangle);
  }

}


