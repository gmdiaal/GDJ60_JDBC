package com.iu.main.departments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iu.main.employees.EmployeeDTO;
import com.iu.main.util.DBconnection;

public class DepartmentDAO {
	
	public void getInfos () throws Exception {
		Connection connection = DBconnection.getConnection();
		String spl = "SELECT E.FIRSTNAME, D.DEPARTMENT_NAME "
				+ "FROM EMPLOYEES E "
				+ "INNER JOIN "
				+ "DEPARTMENTS D "
				+ "ON (E.DEPARTMENT_ID = D.DEPARTMENT_ID) "
				+ "WHERE DEPARTMENT_ID=30"; //30번 부서의 사원들과 부서명
		PreparedStatement st = connection.prepareStatement(spl);
		ResultSet rs = st.executeQuery();
		
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setEmployeeDTOs(new ArrayList<EmployeeDTO>());
		while (rs.next()) {
			if (departmentDTO.getDepartment_name()==null) {
				departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));				
			}
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setFirst_name(rs.getString("EMPLOYEE_NAME"));
			departmentDTO.getEmployeeDTOs().add(employeeDTO);
		}
	
	}
	//join
	public DepartmentDTO getInfo () throws Exception {
		DepartmentDTO departmentDTO = null;
		
		Connection connection = DBconnection.getConnection();
		String sql = "SELECT E.FIRST_NAME, D.DEPARTMENT_NAME "
				+ "FROM EMPLOYEES E "
				+ "INNER JOIN "
				+ "DEPARTMENTS D "
				+ "ON(E.DEPARTMENT_ID = D.DEPARTMENT_ID) "
				+ "WHERE E.EMPLOYEE_ID = 100";
		
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			departmentDTO = new DepartmentDTO();
			departmentDTO.setEmployeeDTOs(new ArrayList<EmployeeDTO>());
			departmentDTO.setDepartment_name(rs.getString("DEMPARTMENT_NAME")); //SQL에서 결과창 보면 E.XX가 아니라 걍 XX임
			
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			departmentDTO.getEmployeeDTOs().add(employeeDTO);
//			departmentDTO.getEmployeeDTOs().get(0).setFirst_name("");;
		}
		
		return departmentDTO;
		
	}
	
	//update
	public int updateData (DepartmentDTO departmentDTO) throws Exception {
		Connection connection = DBconnection.getConnection();
		String sql = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME=?, MANAGER_ID=?, LOCATION_ID=? "
				+ "WHERE DEPARTMENT_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, departmentDTO.getDepartment_name());
		st.setInt(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());
		st.setInt(4, departmentDTO.getDepartment_id());
		int result = st.executeUpdate();
		
		DBconnection.disConnect(st, connection);
		
		return result;
	}
	//del
	public int delData (DepartmentDTO dto) throws Exception{
		Connection connection = DBconnection.getConnection();
		String sql = "DELETE DEPARTMENTS WHERE DEPARTMENT_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, dto.getDepartment_id());
		int result = st.executeUpdate();
		
		DBconnection.disConnect(st, connection);
		
		return result;
	}
	//insert
	public int setData (DepartmentDTO departmentDTO) throws Exception {
		Connection connection = DBconnection.getConnection();
		
		String sql = "INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID)"
				+ " VALUES( DEPARTMENTS_SEQ.NEXTVAL, ?, ?, ?)";
		PreparedStatement st = connection.prepareCall(sql);
		st.setString(1, departmentDTO.getDepartment_name());
		st.setInt(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());
		
		int result = st.executeUpdate(); //인서트, 업데이트, 딜리트 포함 //반환값 int 
		
		DBconnection.disConnect(st, connection);
		
		return result;
		
	}
	
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
