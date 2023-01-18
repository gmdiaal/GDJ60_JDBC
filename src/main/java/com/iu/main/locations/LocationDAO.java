package com.iu.main.locations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iu.main.util.DBconnection;

public class LocationDAO {
	
	public void getDetail(int location_id) throws Exception {
		Connection connection = DBconnection.getConnection();
		String sql ="SELECT * FROM LOCATIONS WHERE LOCATION_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, location_id);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			System.out.println(rs.getInt("LOCATION_ID"));
			System.out.println(rs.getString("STREET_ADDRESS"));
			System.out.println(rs.getString("CITY"));
			System.out.println(rs.getString("STATE_PROVINCE"));
			System.out.println(rs.getString("COUNTRY_ID"));
		}else {System.out.println("없음");}
	}

	public void getList () throws Exception {
		//DBconnection dBconnection = new DBconnection();
		Connection connection = DBconnection.getConnection();
		//1. 접속 정보 준비
//		String user = "hr";
//		String password = "hr";
//		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
//		//2. 접속 실행
//		Connection connection = DriverManager.getConnection(url, user, password);
		//3. Query문 생성
		String sql = "SELECT * FROM LOCATIONS";
		//4. Query문 미리 전송 (미완)
		PreparedStatement statement = connection.prepareStatement(sql);
		//5. ? 세팅
		//6. 최종 전송
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt("LOCATION_ID"));
			System.out.println(rs.getString("STREET_ADDRESS"));
			System.out.println(rs.getString("CITY"));
			System.out.println(rs.getString("STATE_PROVINCE"));
			System.out.println(rs.getString("COUNTRY_ID"));
		}
		//7. 연결해제
		DBconnection.disConnect(connection, statement, rs);
		//connection preparedstatement -- con.preparest..
	}
}
