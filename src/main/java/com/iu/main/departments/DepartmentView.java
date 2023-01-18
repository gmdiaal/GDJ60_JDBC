package com.iu.main.departments;

import java.util.ArrayList;

public class DepartmentView {

	public void view ( ArrayList<DepartmentDTO> ar ) {
		
		
		for(DepartmentDTO departmentDTO: ar) {
			this.view(departmentDTO);
		}
//		for(int i=0;i<ar.size();i++) {	this.view(ar.get(i)); }

	}
	public void view ( DepartmentDTO dto ) {
		System.out.println(dto.getDepartment_name());
		System.out.println(dto.getDepartment_id());
		System.out.println(dto.getLocation_id());
		System.out.println(dto.getManager_id());
	}
	public void view (String str) {
		System.out.println(str);
	}
}
