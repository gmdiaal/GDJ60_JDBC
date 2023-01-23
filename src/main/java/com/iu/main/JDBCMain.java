package com.iu.main;

import java.util.ArrayList;

import com.iu.main.departments.DepartmentController;
import com.iu.main.departments.DepartmentDAO;
import com.iu.main.departments.DepartmentDTO;
import com.iu.main.departments.DepartmentView;
import com.iu.main.employees.EmployeeController;
import com.iu.main.employees.EmployeeDAO;
import com.iu.main.locations.LocationController;
import com.iu.main.locations.LocationDAO;
import com.iu.main.util.DBconnection;

public class JDBCMain {

	public static void main(String[] args) {
		System.out.println("start");
//		DepartmentController dc = new DepartmentController();
//		LocationController lc = new LocationController();
//		EmployeeController ec = new EmployeeController();
//		
//		EmployeeDAO dao = new EmployeeDAO();
		FrontContoller fo = new FrontContoller();
		try {
			
			// = dao.getAvg();
//			System.out.println(result[0]);
//			System.out.println(result[1]);
			
			fo.start();
			
//			DepartmentDTO departmentDTO = new DepartmentDTO();
//			departmentDTO.setDepartment_id(280);
//
//			int result = departmentDAO.delData(departmentDTO);
//			if(result>0) {
//				System.out.println("성공");
//			}else {System.out.println("실패");}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.out.println("finish");
	}
}
