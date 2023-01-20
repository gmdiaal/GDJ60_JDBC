package com.iu.main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBconnection {

	public static Connection getConnection() throws Exception {
		//1. 접속 정보 준비.
		
		//1. id
		String username = "hr";
		//2. psword
		String password = "hr";
		//3. url
		String url="jdbc:oracle:thin:@localhost:1521/XEPDB1";
		
		//4. driver
		String driver = "oracle.jdbc.driver.OracleDriver"; //패키지-폴터-클라스 형태
		
		Class.forName(driver); //이름으로 클래스 타입을 만듬 
		//요즘에는 알아서 해줌.
		///////////////////////////////////////////////////////////////////////

		//2. DB접속 실행.
		Connection connection = DriverManager.getConnection(url, username, password);
		//로그인을 시도해서 되면 변수에 보내줌. 실패하면 익셉션. OracleDriver에서 불러온 드라이버매니저
		

		
		return connection;
		
	}
	
	public static void disConnect(PreparedStatement st, Connection con) throws Exception {
		st.close(); //null.close() 발생 가능 -> exception
		con.close();
	}
	public static void disConnect(Connection con, PreparedStatement ps, ResultSet rs) throws Exception {
		rs.close();
		ps.close();
		con.close();
	}
	
	
}
