package com.test.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress use case.
 */
public class InetAddressUseCase {
  public static void main(String[] args) throws UnknownHostException {
    InetAddress address = InetAddress.getLocalHost();
    System.out.println(address);
    address = InetAddress.getByName("www.baidu.com");
    System.out.println(address);
  }
}
