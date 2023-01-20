package com.iu.main.locations;

import java.util.ArrayList;
import java.util.Scanner;

public class LocationController {
	private Scanner sc;
	private LocationDAO locationDAO;
	private LocationView locationView;
	private LocationInput locationInput;
	
	public LocationController(){
		sc = new Scanner(System.in);
		locationDAO = new LocationDAO();
		locationView = new LocationView();
		locationInput = new LocationInput();
	}
	
	public void start() throws Exception {
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		LocationDTO locationDTO = null;
		boolean check = true;
		while(check) {
			System.out.println("1.모든위치정보");
			System.out.println("2.ID위치정보");
			System.out.println("3.주소 검색");
			System.out.println("4.주소 추가");
			System.out.println("5.주소 삭제");
			System.out.println("6.주소 수정");
			System.out.println("7.종 	료");
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
				locationView.view(locationDAO.getFind(add)); //다른거있나?
			case 4: 
				locationInput = new LocationInput();
				locationDTO = locationInput.inputNew();
				select = locationDAO.setData(locationDTO);
				String msg = "실패";
				if (select>0) {msg="성공"; }
				locationView.view(msg);
				break;
			case 5: 
				locationDTO = locationInput.inputDel();
				select = locationDAO.delData(locationDTO);
				msg = "실패";
				if (select>0) {msg="성공"; }
				locationView.view(msg);
				break;
			case 6:
				locationDTO = locationInput.inputUpdate();
				select = locationDAO.updateData(locationDTO);
				msg = "실패";
				if (select>0) {msg="성공"; }
				locationView.view(msg);
				break;
				default:
					System.out.println("종료");
					check=false;
			}
		}
	}
}
