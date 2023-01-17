package com.iu.main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBconnection {

	public void getConnection() throws Exception {
		//1. id
		String username = "hr";
		//2. psword
		String password = "hr";
		//3. url
		String url="jdbc:oracle:thin:@localhost:1521/XEPDB1";
		//4. driver
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		Connection connection = DriverManager.getConnection(url, username, password);
		//로그인을 시도해서 되면 변수에 보내줌. 실패하면 익셉션
		
		String sql = "SELECT * FROM DEPARTMENTS";
		
		PreparedStatement st= connection.prepareStatement(sql);
		//sql명령어를 db로 보냄.
		
		ResultSet rs = st.executeQuery();
			//SELECT의 결과물인 ResultSet을 담음.
		
		while(rs.next()) {//next() 줄 바꾸면서 계속 읽음. 데이터가 있으면 true
			System.out.println(rs.getInt("MANAGER_ID"));
//			System.out.println(rs.getString("MANAGER_ID"));
//			System.out.println(rs.getString("DEPARTMENT_NAME"));
//			System.out.println(rs.getString(1));
//			System.out.println(rs.getString(2));
//			System.out.println(rs.getString(3));
//			System.out.println(rs.getString(4));
		}
		
		
		
	}
	
	
}
