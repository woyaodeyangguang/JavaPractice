package com.test.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by Admin on 2017/8/11.
 */
public class RedisTest {
  private static Jedis jedis = null;

  static {
    jedis = new Jedis("192.168.100.161", 6379);
    jedis.auth("123456");
    System.out.println("redis status: " + jedis.ping());
  }

  @Test
  public void testString() {
    jedis.set("stringkey", "stringvalue");
    System.out.println(jedis.get("stringkey"));
    jedis.append("stringkey", "appendvalue");
    System.out.println(jedis.get("stringkey"));
    jedis.del("stringkey");
    System.out.println(jedis.get("stringkey"));
  }

  @Test
  public void testMap() {
    System.out.println("Hello World");
  }

}
