package com.iu.main.departments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.util.DBconnection;

public class DepartmentDAO {
	
	public DepartmentDTO getDetail( int department_id ) throws Exception {
		DepartmentDTO departmentDTO = null;
		Connection connection = DBconnection.getConnection();
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";
		//preparedstatement 는 sql injection을 방어하기 위한 메서드. ?를 변수로 인식함, 미완성문
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, department_id); //department_id가 첫번째 ?에 들어감. --> WHERE x index 1, y index 2,...
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) { //하나 아니면 안옴
			departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setManager_id(rs.getInt("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
		}
		
		DBconnection.disConnect(connection, st, rs);
		return departmentDTO;
	}

	public ArrayList<DepartmentDTO> getList () throws Exception {
		ArrayList<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();
		
		//DBconnection dBconnection = new DBconnection(); //static 클라스로
		Connection connection = DBconnection.getConnection();
		
//		//1. 접속 정보 준비
//		String user = "hr";
//		String password = "hr";
//		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
//		
//		//2. 접속 실행
//		Connection connection = DriverManager.getConnection(url, user, password);
		
		//3. Query문 생성
		String sql = "SELECT * FROM DEPARTMENTS";
		//4. Query문 미리 전송 (미완)
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		//5. ? 세팅
		//6. 최종 전송
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setManager_id(rs.getInt("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			ar.add(departmentDTO);
		}
		
		//7. 연결해제
		DBconnection.disConnect(connection, preparedStatement, rs);
		return ar;
	}
}
