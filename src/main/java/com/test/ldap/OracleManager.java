package com.test.ldap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * oracle数据库.
 */
public class OracleManager {

  private static final  String insertUserSql =
      "insert into GB_JB_RYXX values(GB_JB_SEQ.nextval, ?, ?, '', '', '', 1, 0)";
  private static final  String insertOrgSql =
      "insert into GB_JB_ZZJG values(GB_JB_SEQ.nextval, ?, ?, ?, ?, 2, 0, 1, 0)";;
  private static final String insertUserOrgSql =
      "insert into GB_JB_RYJG values(GB_JB_SEQ.nextval, ?, ?, ?, ?, 1)";


  private static final String containsUserSql = "select count(1) from GB_JB_RYXX where DLM = ?";
  private static final String containsOrgSql = "select count(1) from GB_JB_ZZJG where MC = ?";
  private static final String containsUserOrgSql = "select count(1) from GB_JB_RYJG where RYID = ?";

  private static Connection connection = DBUtils.getConnection();

  /**
   * 判断是否包含
   * @param containsSql
   * @param arg
   * @return
   */
  public static boolean containsObject(String containsSql, String arg) {
    boolean flag = false;
    PreparedStatement pstm = null;
    try {
      pstm = connection.prepareCall(containsSql);
      pstm.setString(1, arg);
      ResultSet resultSet =  pstm.executeQuery();
      resultSet.next();
      if(resultSet == null || resultSet.getInt(1) != 0) {
        flag = true;
        System.out.println("存在相同的信息: " + arg + "存在");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally{
      try {
        pstm.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return flag;
  }

  public static int insert(String insertSql, String[] args) {
    PreparedStatement pstm = null;
    try {
      pstm = connection.prepareCall(insertSql);
      for (int i = 1; i <= args.length; i++) {
        pstm.setString(i, args[i - 1]);
      }
      return pstm.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally{
      try {
        pstm.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return -1;
  }



  public static void main(String[] args) throws Exception {
    // 获取部门信息
    List<String[]> orgInfos = POIUtils.getOrgInfo();
    // 获取用户信息
    List<String[]> userInfos = POIUtils.getUserInfo();
    for(String[] userInfo : userInfos) {
      String DLM = userInfo[0].split(",")[0];
      // 判断是否存在相同的用于
      boolean flag = containsObject(containsUserSql, DLM);
      // 不存在时加入用户
      if(!flag) {
        String XM = userInfo[1];
        insert(insertUserSql, new String[] {DLM, XM});
      }
    }
    System.out.println("-----------用户信息插入结束-------------");

    for (String[] orgInfo : orgInfos) {
      String MC = orgInfo[1];
      boolean flag = containsObject(containsOrgSql, MC);
      //  不存在时插入部门信息
      if(!flag) {
        String JGID = orgInfo[0];
        String SJID = "dc=guobo";
        String MS = orgInfo[1];
        insert(insertOrgSql, new String[]{JGID, MC, SJID, MS});
      }
    }
    System.out.println("-----------部门信息插入结束-------------");

    for(String[] userInfo : userInfos) {
      String RYID = userInfo[0].split(",")[0];
      boolean flag = containsObject(containsUserOrgSql, RYID);
      //  不存在时加入用户部门信息
      if(!flag) {
        String RYXM = userInfo[1];
        String JGID = userInfo[0].split(",")[1] + "," + userInfo[0].split(",")[2];
        String JGXM = userInfo[2];
        insert(insertUserOrgSql, new String[]{RYID, RYXM, JGID, JGXM});
      }
    }
    System.out.println("-----------用户本部门信息插入结束-------------");
  }
}
