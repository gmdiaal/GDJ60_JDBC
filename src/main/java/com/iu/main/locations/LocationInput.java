package com.iu.main.locations;

import java.util.Scanner;

public class LocationInput {
	private Scanner sc;
	private LocationDTO dto;
	
	public LocationInput () {
		sc = new Scanner(System.in);
		dto = new LocationDTO();
	}
	
	//수정
	public LocationDTO inputUpdate() {
		dto = new LocationDTO();
		System.out.println("수정할 LOCATION_ID 입력");
		dto.setLOCATION_ID(sc.nextInt());
		System.out.println("수정할 STREET주소");
		dto.setSTREET_ADDRESS(sc.next());
		System.out.println("수정할 POSTAL_CODE");
		dto.setPOSTAL_CODE(sc.next());
		return dto;
	}
	public LocationDTO inputNew() {
		
		System.out.println("STREET_ADDRESS 입력");
		dto.setSTREET_ADDRESS(sc.next());
		System.out.println("COUNTRY_ID (US)");
		dto.setCOUNTRY_ID(sc.next());
			
		return dto;
	}
	
	public LocationDTO inputDel() {
		System.out.println("삭제할 LOCATION_ID 입력");
		dto.setLOCATION_ID(sc.nextInt());
		
		return dto;
	}
	
}
