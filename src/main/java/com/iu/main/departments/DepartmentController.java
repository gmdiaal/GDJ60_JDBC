package com.iu.main.departments;

import java.util.Scanner;

public class DepartmentController {
	private Scanner sc;
	private DepartmentDAO departmentDAO;
	
	public DepartmentController(){
		this.sc = new Scanner(System.in);
		this.departmentDAO = new DepartmentDAO();
	}
	
	
	public void start() throws Exception {
		boolean check = true;
		while(check) {
			System.out.println("1. 부서 리스트");
			System.out.println("2. 부서상세정보");
			System.out.println("3. 종	 료");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				departmentDAO.getList();
				break;
			case 2:
				System.out.println("부서번호를 입력하세요");
				select = sc.nextInt();
				departmentDAO.getDetail(select);
				break;
			default:
				check = false;
			}
		}
	}
}
