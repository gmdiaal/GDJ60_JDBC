package com.iu.main.employees;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeController {
	Scanner sc = new Scanner(System.in);
	EmployeeDAO employeeDAO = new EmployeeDAO();
	EmployeeDAO dao = new EmployeeDAO();
	EmployeeView view = new EmployeeView();
	EmployeeInput employeeInput = new EmployeeInput();
	
	public void start() throws Exception {
		boolean check = true;
		EmployeeDTO dto = null;
		ArrayList<EmployeeDTO> ar = null;
		
		while(check) {
			System.out.println("1. 사원정보리스트 2. 개별사원정보 3. 이름으로사원검색 4.사원 추가 5.삭제 6.수정 7. 종료");
			int menu = sc.nextInt();
			switch(menu) {
				case 1:
					break;
				case 2:
					System.out.println("찾을 ID 입력");
					int search = sc.nextInt();
					dto = dao.getId(search);
					
					if(dto!=null) {
						view.view(dto);
					}else {view.view("없음");}
					
					break;
				case 3: //@null일때 왜 []뜨니?
					ar = new ArrayList<EmployeeDTO>();
					System.out.println("찾을 문자열 입력");
					String str = sc.next();
					ar = dao.getLastname(str);
					//System.out.println(ar);
					if(ar.size()>0) {
						view.view(ar);
					}else {view.view("없음");}
					
					break;
				case 4:
					dto = employeeInput.inputNew();
					menu = dao.setNew(dto);
					if(menu>0) {System.out.println("추가성공");}else {System.out.println("추가실패");}
					break;
				case 5:
					dto = employeeInput.inputDelete();
					menu = dao.setDelete(dto);
					if(menu>0) {System.out.println("삭제 성공");}else {System.out.println("삭제 실패");}
					break;
				case 6: //update 미완
					dto = employeeInput.inputUpdate();
					menu = dao.setUpdate(dto);
					if(menu>0) {System.out.println("수정 성공");}else {System.out.println("수정 실패");}
				default: check=false;
					
			}
		}
	}
}
