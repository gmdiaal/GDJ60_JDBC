package com.iu.main.employees;

import java.util.Scanner;

public class EmployeeController {
	Scanner sc = new Scanner(System.in);
	EmployeeDAO employeeDAO = new EmployeeDAO();
	EmployeeDTO dto = new EmployeeDTO();
	EmployeeDAO dao = new EmployeeDAO();
	
	public void menu() throws Exception {
		boolean check = true;
		
		System.out.println("1. 사원정보리스트 2. 개별사원정보 3. 이름으로사원검색");
		int menu = sc.nextInt();
		
		while(check) {

			switch(menu) {
				case 1:
					break;
				case 2:
					dao.getId();
					break;
				case 3:
					break;
				default:
					
			}
		}
	}
}
