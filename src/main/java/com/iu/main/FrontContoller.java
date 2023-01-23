package com.iu.main;

import java.util.Scanner;

import com.iu.main.departments.DepartmentController;
import com.iu.main.employees.EmployeeController;
import com.iu.main.locations.LocationController;

public class FrontContoller {
	private Scanner sc;
	private DepartmentController departmentController;
	private LocationController locationController;
	private EmployeeController employeeController;
	//컨트롤러의 컨트롤러
	
	FrontContoller(){
		sc = new Scanner(System.in);
		departmentController = new DepartmentController();
		locationController = new LocationController();
		employeeController = new EmployeeController();
	}
	
	public void start () throws Exception {
		boolean check = true;
		
		
		while(check) {
			System.out.println("1.부서관리 2.지역관리 3.사원관리 4.종료");
			int select = sc.nextInt();
			
			switch (select) {
			case 1:
				departmentController.start();
				break;
			case 2:
				locationController.start();
				break;
			case 3:
				employeeController.start();
				break;

			default:
				check = false
				;
				break;
			}
			
		}
	}
	
	
}
