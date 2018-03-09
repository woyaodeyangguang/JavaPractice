package com.test.dynamicproxy;

/**
 * 房东
 */
public class HouseOwner implements RentHouse{

  @Override
  public void rent() {
    System.out.println("I want to rent my house.");
  }

  @Override
  public void charge(String str) {
    System.out.println("You get:" + str + "RMB house charge.");
  }
}
