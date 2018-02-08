package com.test.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 序列化: 将对象转换成以字节序列的形式来表示,字节序列中包含了对象的数据和信息,可以将序列化后的对象
 *         写入到数据库或文件中，用于网络传输，一般使用缓存cache或远程调用RPC,需实现Serializable.
 * 反序列化: 将字节序列恢复成对象
 * Transient关键字：将某些被修饰的成员变量不被序列化.
 */
public class TestTransient {
  public static void main(String[] args) throws Exception {
    Rectangle rectangle = new Rectangle(3, 4);
    System.out.println("1.原始对象\n" + rectangle);
    ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("rectangle"));
    // 往流写入对象
    o.writeObject(rectangle);
    o.close();

    // 往流中读取对象
    ObjectInputStream in = new ObjectInputStream(new FileInputStream("rectangle"));
    Rectangle rectangle1 = (Rectangle) in.readObject();
    System.out.println("2.反序列化后的对象\n" + rectangle1);
    rectangle1.setArea();
    System.out.println("3.恢复成原始对象\n" + rectangle1);
    in.close();
  }
}

class Rectangle implements Serializable {
  private static final long serialVersionUID = 1L;

  private Integer width;
  private Integer height;
  private transient Integer area;

  private static class InstanceHolder {
    private static final Rectangle instace = new Rectangle(3, 4);
  }

  public static Rectangle getInstance() {
    return InstanceHolder.instace;
  }

  public Rectangle(Integer width, Integer height) {
    this.width = width;
    this.height = height;
    this.area = width * height;
  }

  public void setArea() {
    this.area = this.width * this.height;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("width:");
    sb.append(this.width);
    sb.append("\nheight:");
    sb.append(this.height);
    sb.append("\narea:");
    sb.append(this.area);
    return sb.toString();
  }

  /**
   * 保证反序列化后的单例特性
   * @return
   */
  private Object readResolve() {
    return InstanceHolder.instace;
  }
}
