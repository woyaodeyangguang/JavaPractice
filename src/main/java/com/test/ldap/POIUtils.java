package com.test.ldap;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * excel读写工具类
 */
public class POIUtils {

  private final static String XLS = "xls";
  private final static String XLSX = "xlsx";

  // 部门文件
  private static final String ORG_FILE_PATH = "D:\\organization_new.xlsx";
  // 用户信息文件
  private static final String USER_FILE_PATH = "D:\\人员信息.xls";
  // 部门和部门拼音之间的映射
  private static final Map<String, String> map = new HashMap<>();

  /**
   * 获取excel所有行.
   * eg "ou=ceshixindebumen,dc=guobo"
   * @throws IOException
   */
  public static List<Row> getRows(String filePath){
    File file = new File(filePath);
    //检查文件
    try {
      checkFile(file);
    } catch (Exception e) {
      e.printStackTrace();
    }
    //获得当前sheet工作表
    Sheet sheet  = getSheet(file);
    //创建返回对象
    List<Row> list = new LinkedList<>();
    if(sheet != null){
        //获得当前sheet的开始行
        int firstRowNum  = sheet.getFirstRowNum();
        //获得当前sheet的结束行
        int lastRowNum = sheet.getLastRowNum();
        //循环除了第一行的所有行
        for(int rowNum = firstRowNum + 1; rowNum <= lastRowNum; rowNum++){
          //获得当前行
          Row row = sheet.getRow(rowNum);
          if(row == null){
            continue;
          }
          list.add(row);
        }
    }
    return list;
  }

  public static void checkFile(File file) throws Exception {
    //判断文件是否存在
    if(null == file){
      throw new FileNotFoundException("文件不存在！");
    }
    //获得文件名
    String fileName = file.getName();
    //判断文件是否是excel文件
    if(!fileName.endsWith(XLS) && !fileName.endsWith(XLSX)){
      throw new IOException(fileName + "不是excel文件");
    }
  }

  public static Sheet getSheet(File file) {
    //获得文件名
    String fileName = file.getName();
    //创建Workbook工作薄对象，表示整个excel
    Workbook workbook = null;
    try {
      //获取excel文件的io流
      InputStream is = new FileInputStream(file);
      //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
      if(fileName.endsWith(XLS)){
        //2003
        workbook = new HSSFWorkbook(is);
      }else if(fileName.endsWith(XLSX)){
        //2007
        workbook = new XSSFWorkbook(is);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return workbook.getSheetAt(0);
  }

  /**
   * 获取部门信息.
   * @return
   */
  public static List<String[]> getOrgInfo() {
    List<Row> rows = getRows(ORG_FILE_PATH);
    List<String[]> result = new LinkedList<>();
    for(Row row : rows) {
      // eg. "ou=ceshixindebumen,dc=guobo";
      String ou = row.getCell(5).toString();
      String orgName = row.getCell(3).toString();
      map.putIfAbsent(orgName, ou);
      // 判断ou是不是国博
      if("guobo".equals(ou)) {
        continue;
      }
      String orgInfo = "ou=" + ou + ",dc=guobo";
      result.add(new String[] {orgInfo, orgName});
    }
    return result;
  }

  /**
   * 获取用户信息.
   * @return
   */
  public static List<String[]> getUserInfo() throws Exception {
    List<Row> rows = getRows(USER_FILE_PATH);
    List<String[]> result = new LinkedList<>();
    for(Row row : rows) {
      // ou部门的中文名称
      String ouName =  row.getCell(2).toString();
      String ou = "";
      if(!map.containsKey(ouName)) {
        throw new Exception("存在不存在的部门");
      }
      ou = map.get(ouName);
      String cn = row.getCell(1).toString();
      String userName = row.getCell(0).toString();
      // "cn=xindeceshirenyuan1,ou=ceshixindebumen,dc=guobo";
      String userInfo = "cn=" + cn + ",ou=" + ou +",dc=guobo";
      String orgName = row.getCell(2).toString();
      result.add(new String[] {userInfo, userName, orgName});
    }
    return result;
  }

  public static void main(String[] args) throws Exception {
    getOrgInfo();
    getUserInfo();
  }

}
