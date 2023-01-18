package com.iu.main.locations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.util.DBconnection;

public class LocationDAO {
	
	public ArrayList<LocationDTO> getFind(String search) throws Exception{
		LocationDTO locationDTO;
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		Connection connection = DBconnection.getConnection();
		String sql = "SELECT * FROM LOCATIONS WHERE STREET_ADDRESS LIKE ?";
		PreparedStatement st = connection.prepareCall(sql);
		st.setString(1, "%"+search+"%");
		//"%"+search+"%" //'%?%' --> '%'?'%' 자동으로'를 붙임...
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			locationDTO = new LocationDTO();
			locationDTO.setLOCATION_ID(rs.getInt("LOCATION_ID"));
			locationDTO.setSTREET_ADDRESS(rs.getString("STREET_ADDRESS"));
			locationDTO.setCITY(rs.getString("CITY"));
			locationDTO.setSTATE_PROVINCE(rs.getString("STATE_PROVINCE"));
			locationDTO.setCOUNTRY_ID(rs.getString("COUNTRY_ID"));
			ar.add(locationDTO);
		}
			return ar;
		
	}
	
	public LocationDTO getDetail(int location_id) throws Exception {
		Connection connection = DBconnection.getConnection();
		String sql ="SELECT * FROM LOCATIONS WHERE LOCATION_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, location_id);
		ResultSet rs = st.executeQuery();
		
		LocationDTO locationDTO = null;
		
		if(rs.next()) {
			locationDTO = new LocationDTO();
			locationDTO.setLOCATION_ID(rs.getInt("LOCATION_ID"));
			locationDTO.setSTREET_ADDRESS(rs.getString("STREET_ADDRESS"));
			locationDTO.setCITY(rs.getString("CITY"));
			locationDTO.setSTATE_PROVINCE(rs.getString("STATE_PROVINCE"));
			locationDTO.setCOUNTRY_ID(rs.getString("COUNTRY_ID"));
		}
		DBconnection.disConnect(connection, st, rs);
		return locationDTO;
		
		
	}

	public ArrayList<LocationDTO> getList () throws Exception {
		LocationDTO locationDTO = new LocationDTO();
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		
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
			locationDTO.setLOCATION_ID(rs.getInt("LOCATION_ID"));
			locationDTO.setSTREET_ADDRESS(rs.getString("STREET_ADDRESS"));
			locationDTO.setCITY(rs.getString("CITY"));
			locationDTO.setSTATE_PROVINCE(rs.getString("STATE_PROVINCE"));
			locationDTO.setCOUNTRY_ID(rs.getString("COUNTRY_ID"));
			ar.add(locationDTO);
		}
		//7. 연결해제
		DBconnection.disConnect(connection, statement, rs);
		//connection preparedstatement -- con.preparest..
		return ar;
	}
}
