package com.iu.main.employees;

import java.util.Scanner;

public class EmployeeInput {
	Scanner sc;
	EmployeeDTO dto;
	
	public EmployeeInput() {
		sc = new Scanner(System.in);
		dto = new EmployeeDTO();
	}
	
	//수정
	public EmployeeDTO inputUpdate() {
		System.out.println("수정할 EMPLOYEE_ID 입력");
		dto.setEmployee_id(sc.nextInt());
		System.out.println("LAST_NAME 입력");
		dto.setLast_name(sc.next());
		System.out.println("EMAIL 입력");
		dto.setEmail(sc.next());
		System.out.println("JOB_ID 입력");
		dto.setJob_id(sc.next());
		return dto;
	}
	
	//삭제
	public EmployeeDTO inputDelete() {
		System.out.println("삭제할 ID입력");
		dto.setEmployee_id(sc.nextInt());
		return dto;
	}
	//생성
	public EmployeeDTO inputNew() {
		System.out.println("생성/수정직원 LAST_NAME 입력");
		dto.setLast_name(sc.next());
		return dto;
	}
}
