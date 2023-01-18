package com.iu.main.locations;

import java.util.ArrayList;
import java.util.Scanner;

public class LocationController {
	private Scanner sc;
	private LocationDAO locationDAO;
	private LocationView locationView;
	
	public LocationController(){
		sc = new Scanner(System.in);
		locationDAO = new LocationDAO();
		locationView = new LocationView();
	}
	
	public void start() throws Exception {
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		boolean check = true;
		while(check) {
			System.out.println("1.모든위치정보");
			System.out.println("2.ID위치정보");
			System.out.println("3.주소검색");
			System.out.println("4.종 	료");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				 locationView.view(locationDAO.getList());
				break;
			case 2:
				System.out.println("부서ID 입력");
				select = sc.nextInt();
				if(locationDAO.getDetail(select)!=null) {
					locationView.view(locationDAO.getDetail(select));	
				} else {locationView.view("없음");}
				break;
			case 3:
				System.out.println("검색할 주소 입력");
				String add = sc.next();
				ar= locationDAO.getFind(add);
				locationView.view(locationDAO.getFind(add));
				default:
					System.out.println("종료");
					check=false;
			}
		}
	}
}
