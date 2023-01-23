package com.iu.main.countries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.iu.main.util.DBconnection;

public class CountryDAO {
	
	//전체조회
	public ArrayList<CountryDTO> getList () throws Exception {
		
		ArrayList<CountryDTO> ar = new ArrayList<CountryDTO>();
		
		Connection connection = DBconnection.getConnection();
		String sql = "SELECT * FROM COUNTRIES";
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			CountryDTO dto = new CountryDTO();
			dto.setCounty_id(rs.getString("COUNTRY_ID"));
			dto.setCoutry_name(rs.getString("COUNTRY_NAME"));
			dto.setRegion_id(rs.getInt("REGION_ID"));
			ar.add(dto);
		}

//		CountryDTO dto = ar.get(0);
//		System.out.println("getlist test: "+dto.getCoutry_name() );
		DBconnection.disConnect(connection, st, rs);
		return ar;
		
	}

	//ID로 조회
	public CountryDTO getID( String id ) throws Exception {
		CountryDTO dto = null;
//		String user = "hr";
//		String password = "hr";
//		String url = "jdbc:oracle:thin:@lacalhost:1521:XEPDB1";
//		String driver = "oracle:jdbc:driver:OracleDriver";
//		Class.forName(driver);
//		Connection connection = DriverManager.getConnection(url, user, password);
		Connection connection = DBconnection.getConnection();
		
		String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, id);
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			dto = new CountryDTO();
			dto.setCounty_id(rs.getString("COUNTRY_ID"));
			dto.setCoutry_name(rs.getString("COUNTRY_NAME"));
			dto.setRegion_id(rs.getInt("REGION_ID"));
		}
		
		DBconnection.disConnect(connection, st, rs);
		return dto;
	}
	
	//INSERT
	public int setInsert (CountryDTO dto) throws Exception {
		
		Connection connection = DBconnection.getConnection();
		String sql = "INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME, REGION_ID) VALUES (?,?,?)";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, dto.getCounty_id());
		st.setString(2, dto.getCoutry_name());
		st.setInt(3, dto.getRegion_id());
		
		int result = st.executeUpdate();
		
		DBconnection.disConnect(st, connection);
		return result;
	}
	
	public int setUpdate (CountryDTO dto) throws Exception {
		Connection connection = DBconnection.getConnection();
		String sql = "UPDATE COUNTRIES SET COUNTRY_NAME=?, REGION_ID=? "
				+ "WHERE COUNTRY_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, dto.getCoutry_name());
		st.setInt(2, dto.getRegion_id());
		st.setString(3, dto.getCounty_id());
		
		int result = st.executeUpdate();
		
		DBconnection.disConnect(st, connection);
		return result;
	}
	public int setDelete (CountryDTO dto) throws Exception {
		Connection connection = DBconnection.getConnection();
		String sql = "DELETE COUNTRIES WHERE COUNTRY_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, dto.getCounty_id());
		int result = st.executeUpdate();
		
		DBconnection.disConnect(st, connection);
		return result;
	}

}
