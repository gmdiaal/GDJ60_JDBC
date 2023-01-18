package com.iu.main.locations;

import java.util.Scanner;

public class LocationController {
	private Scanner sc;
	private LocationDAO locationDAO;
	
	public LocationController(){
		sc = new Scanner(System.in);
		locationDAO = new LocationDAO();
	}
	
	public void start() throws Exception {
		boolean check = true;
		while(check) {
			System.out.println("1.모든위치정보");
			System.out.println("2.ID위치정보");
			System.out.println("3.종 	료");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				locationDAO.getList();
				break;
			case 2:
				System.out.println("부서ID 입력");
				select = sc.nextInt();
				locationDAO.getDetail(select);
				break;
				default:
					System.out.println("종료");
					check=false;
			}
		}
	}
}
