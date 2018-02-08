package com.test.classloader;

import java.io.PrintStream;

/**
 * 在 java 命令行上设置参数 -verbose:class 会打印类装入过程的跟踪记录
 * Created by Admin on 2017/6/26.
 */
public class TestClassLoadSequence {
  public static void main(String[] args) {
    System.out.println("**beginning execution**");
    Greeter greeter = new Greeter();
    System.out.println("**created Greeter**");
    greeter.greet();
  }
}

class Greeter {
  private static Message message =  new Message("Hello World");

  public void greet() {
    message.print(System.out);
  }
}

class Message {
  private String message;

  public Message(String message) {
    this.message = message;
  }

  public void print(PrintStream printStream) {
    printStream.println(message);
  }
}
