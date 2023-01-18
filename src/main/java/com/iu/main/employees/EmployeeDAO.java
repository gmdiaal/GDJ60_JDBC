package com.iu.main.employees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.iu.main.util.DBconnection;

public class EmployeeDAO {
	private Connection connection;
	private Scanner sc;
	private EmployeeView view;
	
	//1. 사원정보리스트
	public void getEmployees() throws Exception {
		connection = DBconnection.getConnection();
		String sql = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, JOB_ID, DEPARTMENT_ID "
				+ "FROM EMPLOYEES ORDER BY HIRE_DATE DESC";
		PreparedStatement st = connection.prepareStatement(sql);
		//st.setInt(0, 0);
	}
	
	//2. 개별사원정보
	public void getId() throws Exception {
		connection = DBconnection.getConnection();
		EmployeeDTO employeeDTO = null;
		sc = new Scanner(System.in);
		
		System.out.println("찾을 ID 입력");
		int searchID = sc.nextInt();
		
		
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		PreparedStatement st = connection.prepareStatement(sql); 
		st.setInt(1, searchID);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
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
		
		if(employeeDTO!=null) {
			view.view(employeeDTO);
		}else {view.view("없음");}
		
	}
}
