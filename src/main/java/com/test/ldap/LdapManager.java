package com.test.ldap;

import com.novell.ldap.*;

import java.util.List;

public class LdapManager{

	private int ldapPort = LDAPConnection.DEFAULT_PORT;
	private int ldapVersion = LDAPConnection.LDAP_V3;

	// TODO 需要更改
	private String ldapHost = "192.168.100.149";
	private String loginDN = "cn=root,dc=guobo";
	private String password = "1234";


	public  boolean addUser(String userdn,String username){
		String usercn = userdn.split(",")[0].split("=")[1];
		LDAPAttributeSet attributeSet = new LDAPAttributeSet();

		attributeSet.add(new LDAPAttribute("objectclass", new String[] {"guGongPerson","top"}));
		attributeSet.add(new LDAPAttribute("cn", new String(usercn)));
		attributeSet.add(new LDAPAttribute("description", new String(username)));
		attributeSet.add(new LDAPAttribute("userPassword", new String("8888")));
		attributeSet.add(new LDAPAttribute("guGongPersonStatus", new String("正式职工")));
		LDAPEntry entry = new LDAPEntry(userdn,attributeSet);
		LDAPConnection con = new LDAPConnection();
		try {
			con.connect(ldapHost, ldapPort);
			con.bind(ldapVersion, loginDN, password.getBytes("UTF8"));
			con.add(entry);
			System.out.println("成功的添加了一条用户记录！" + username);
			con.disconnect();
			return true;
		} catch (Exception e) {
      System.err.println("添加用户记录失败,userdn : " + userdn + ", username: " + username);
      e.printStackTrace();
		}
		return false;
	}


	public boolean addOrg(String orgdn,String orgname){
		String ou=orgdn.split(",")[0].split("=")[1];
		LDAPAttributeSet attributeSet = new LDAPAttributeSet();
		attributeSet.add(new LDAPAttribute("objectclass",new String[] {"guGongDepartment","top"}));
		attributeSet.add(new LDAPAttribute("ou",new String(ou)));
		attributeSet.add(new LDAPAttribute("description",new String(orgname)));
		LDAPEntry entry = new LDAPEntry(orgdn,attributeSet);
		LDAPConnection con = new LDAPConnection();
		try {
			con.connect(ldapHost, ldapPort);
			con.bind(ldapVersion, loginDN, password.getBytes("UTF8"));
			con.add(entry);
			System.out.println("成功的添加了一条部门记录！" + orgname);
			con.disconnect();
			return true;
		} catch (Exception e) {
			System.err.println("添加部门记录失败,orgdn : " + orgdn + ", orgname: " + orgname);
			e.printStackTrace();
		}
		return false;
	}


	public LDAPEntry readUser(String userdn){
		LDAPConnection con = new LDAPConnection();
		LDAPEntry en=new LDAPEntry();
		try {
			con.connect(ldapHost, ldapPort);
			con.bind(ldapVersion, loginDN, password.getBytes("UTF8"));
			en=con.read(userdn);
			System.out.println("成功读取一条记录！");
			con.disconnect();
			return en;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) throws Exception {
		LdapManager m=new LdapManager();
		// 获取部门信息
		List<String[]> orgInfos = POIUtils.getOrgInfo();
		// 获取用户信息
		List<String[]> userInfos = POIUtils.getUserInfo();
		// 添加部门信息
		for (String[] orgInfo : orgInfos) {
			String orgStr = orgInfo[0];
			String orgName = orgInfo[1];
			m.addOrg(orgStr, orgName);
			Thread.currentThread().sleep(100);
		}
		// 添加用户信息
		for (String[] userInfo : userInfos) {
			String userStr = userInfo[0];
			String userName = userInfo[1];
			m.addUser(userStr, userName);
			Thread.currentThread().sleep(100);
		}
    System.out.println("-----------程序运行结束-------------");

	}

	/**
	 * 测试数据
	 */
	public static void test() {
		LdapManager m=new LdapManager();
		// 开始插入部门信息
		String departmentStr = "ou=ceshixindebumen,dc=guobo";
		String departName = "测试新的部门";
		LDAPEntry ladpEntry = new LDAPEntry();
		ladpEntry = m.readUser(departmentStr);
		if(ladpEntry != null) {
			//String userStr = "cn=xindeceshirenyuan,ou=ceshixindebumen,dc=guobo";
			//String userName = "新的测试人员";
			String userStr = "cn=xindeceshirenyuan1,ou=ceshixindebumen,dc=guobo";
			String userName = "新的测试人员1";
			m.addUser(userStr, userName);
		} else {
			m.addOrg(departmentStr, departName);
			System.out.println("not exist!");
		}
	}
}