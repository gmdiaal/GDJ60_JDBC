package com.iu.main;

import java.util.ArrayList;

import com.iu.main.departments.DepartmentController;
import com.iu.main.departments.DepartmentDAO;
import com.iu.main.departments.DepartmentDTO;
import com.iu.main.departments.DepartmentView;
import com.iu.main.locations.LocationController;
import com.iu.main.locations.LocationDAO;
import com.iu.main.util.DBconnection;

public class JDBCMain {

	public static void main(String[] args) {
		System.out.println("start");
		DepartmentController dc = new DepartmentController();
		LocationController lc = new LocationController();

		try {
			lc.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.out.println("finish");
	}
}
