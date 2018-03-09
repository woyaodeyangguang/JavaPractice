package com.test.dynamicproxy;

/**
 * 定义一个接口
 */
public interface RentHouse {
  // 房屋出租
  void rent();
  // 出租费用收取
  void charge(String str);
}
