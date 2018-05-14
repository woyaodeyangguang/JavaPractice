package com.test.ldap;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库访问.
 */
public class DBUtils {

  // TODO 需要更改
  private static final String connStr = "jdbc:oracle:thin:@192.168.100.159:1521:gbcpgl";
  private static final String userName = "gbcpgl";
  private static final String passWord = "gbcpgl";

  public static Connection getConnection() {
    Connection con = null;
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      con= DriverManager.getConnection(connStr, userName, passWord);
    }catch(Exception e){
      e.printStackTrace();
    }
    return con;
  }
}
