package com.iu.main.employees;

import java.util.ArrayList;

public class EmployeeView {

	public void view (String msg) {
		System.out.println(msg);
	}
	
	public void view (ArrayList<EmployeeDTO> ar) {
		for(EmployeeDTO dto:ar) {
			System.out.println(    dto.getEmployee_id());
			System.out.println(    dto.getLast_name());
			System.out.println(    dto.getFirst_name());
			System.out.println(    dto.getJob_id());
			System.out.println(    dto.getDepartment_id());
		}
	}
	
	public void view (EmployeeDTO dto) {
		System.out.println(dto.getCommision_pct());
		System.out.println(    dto.getDepartment_id());
		System.out.println(    dto.getEmail());
		System.out.println(    dto.getEmployee_id());
		System.out.println(    dto.getFirst_name());
		System.out.println(    dto.getHire_date());
		System.out.println(    dto.getJob_id());
		System.out.println(    dto.getLast_name());
		System.out.println(    dto.getManager_id());
		System.out.println(   dto.getPhone_number());
		System.out.println(    dto.getSalary());
	}
	
}
