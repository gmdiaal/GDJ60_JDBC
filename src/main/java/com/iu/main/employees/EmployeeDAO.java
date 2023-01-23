package com.iu.main.employees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.iu.main.util.DBconnection;

public class EmployeeDAO {
	
	//월급의 평균
	public HashMap<String, Double> getAvg() throws Exception {
		
		HashMap<String, Double> map = new HashMap<String, Double>();
		
		Connection connection = DBconnection.getConnection();
		
		String sql = "SELECT AVG(SALARY)+100 AS A, SUM(SALARY) FROM EMPLOYEES";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		//System.out.println(rs.getDouble("AVG(SALARY)+100"));
//		System.out.println(rs.getDouble("A"));
//		System.out.println(rs.getDouble(2));
		
		//1. List, Array
		//2. DTO(class)	
		//3. map(key, value)
		map.put("avg", rs.getDouble("A"));
		map.put("sum", rs.getDouble(2));
		
		
		//Double [] result = {rs.getDouble("A"), rs.getDouble(2) };
		DBconnection.disConnect(st, connection);
		return map;
	}
	
	//1. 사원정보리스트
	public ArrayList<EmployeeDTO> getEmployees() throws Exception {
		Connection connection = DBconnection.getConnection();
		EmployeeDTO employeeDTO = new EmployeeDTO();
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		String sql = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, JOB_ID, DEPARTMENT_ID "
				+ "FROM EMPLOYEES ORDER BY HIRE_DATE DESC";
		PreparedStatement st = connection.prepareStatement(sql);
		//st.setInt(0, 0);
		ResultSet rs = st.executeQuery();
		while (rs.next()) { 
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));	
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			ar.add(employeeDTO);
		}
		DBconnection.disConnect(connection, st, rs);
		return ar;
	}
	
	//2. 개별사원정보
	public EmployeeDTO getId(int searchID) throws Exception {
		Connection connection = DBconnection.getConnection();
		EmployeeDTO employeeDTO = null;		

		
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		PreparedStatement st = connection.prepareStatement(sql); 
		st.setInt(1, searchID);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {	//만약 하나의 ROW만 오면 IF문 없이 rs.next()로 읽기만 하면댐
			employeeDTO = new EmployeeDTO();
			employeeDTO.setCommision_pct(rs.getInt("COMMISSION_PCT"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			employeeDTO.setEmail(rs.getString("EMAIL"));
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
			employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			employeeDTO.setSalary(rs.getInt("SALARY"));
		}
		DBconnection.disConnect(connection, st, rs);
		return employeeDTO;
		

		
	}
	//3. 이름으로사원검색
	public ArrayList<EmployeeDTO> getLastname(String searchID) throws Exception {
		Connection connection = DBconnection.getConnection();
		EmployeeDTO employeeDTO = null;		
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		
		String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME LIKE '%'||?||'%'";
		PreparedStatement st = connection.prepareStatement(sql); 
		st.setString(1, searchID);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) { //이름이 여려명 일치할 수 있음으로 if가 아닌 while
			employeeDTO = new EmployeeDTO();
			employeeDTO.setCommision_pct(rs.getInt("COMMISSION_PCT"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			employeeDTO.setEmail(rs.getString("EMAIL"));
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setHire_date(rs.getDate("HIRE_DATE"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setManager_id(rs.getInt("MANAGER_ID"));
			employeeDTO.setPhone_number(rs.getString("PHONE_NUMBER"));
			employeeDTO.setSalary(rs.getInt("SALARY"));
			ar.add(employeeDTO);
		}
		DBconnection.disConnect(connection, st, rs);
		return ar;
	}
	//4. insert
	public int setNew (EmployeeDTO dto) throws Exception {
		Connection connection = DBconnection.getConnection();
		
		String sql = "INSERT INTO EMPLOYEES (EMPLOYEE_ID, LAST_NAME, EMAIL, HIRE_DATE, JOB_ID) "
				+ "VALUES(EMPLOYEES_SEQ.NEXTVAL, ?, ?, TO_DATE(?), 'test' )";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, dto.getLast_name());
		st.setString(2, dto.getEmail());
		st.setString(3, "2022-11-12");
		int result = st.executeUpdate();
		
		DBconnection.disConnect(st, connection);
		return result;
	}
	//5. delete
	public int setDelete(EmployeeDTO dto) throws Exception {
		Connection connection = DBconnection.getConnection();
		String sql = "DELETE EMPLOYEES WHERE EMPLOYEE_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, dto.getEmployee_id());
		int result = st.executeUpdate();
		return result;
	}
	//6. update
	public int setUpdate(EmployeeDTO dto) throws Exception {
		Connection connection = DBconnection.getConnection();
		String sql = "UPDATE EMPLOYEES SET FIRST_NAME=?, LAST_NAME=? WHERE EMPLOYEE_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, dto.getFirst_name());
		st.setString(2, dto.getLast_name());
		st.setInt(3, dto.getEmployee_id());
		int result = st.executeUpdate();
		
		DBconnection.disConnect(st, connection);
		return result;
	}
	
}
