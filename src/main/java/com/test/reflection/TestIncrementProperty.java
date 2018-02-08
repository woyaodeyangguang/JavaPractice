package com.test.reflection;

import java.lang.reflect.Method;

/**
 * 测试反射
 * Created by Admin on 2017/6/26.
 */
public class TestIncrementProperty {
  public static void main(String[] args) throws Exception {
    Student student = new Student("test", 10);
    System.out.println(student);
    System.out.println("------reflection------");
    new TestIncrementProperty().incrementProperty("age", student);
    System.out.println(student);

  }

  public int incrementProperty (String name, Object object) throws Exception {
    String prop = Character.toUpperCase(name.charAt(0)) +
        name.substring(1);
    String getProp = "get" + prop;
    Method getMethod = object.getClass().getMethod(getProp, new Class[]{});
    Object result = getMethod.invoke(object, new Object[]{});
    int value = ((Integer)result).intValue() + 1;
    String setProp = "set" + prop;
    Method setMethod = object.getClass().getMethod(setProp, new Class[]{int.class});
    setMethod.invoke(object, new Object[]{value});
    return value;
  }
}

class Student {
  private String name;
  private int age;

  public Student(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}
