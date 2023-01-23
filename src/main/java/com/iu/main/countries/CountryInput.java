package com.iu.main.countries;

import java.util.Scanner;

public class CountryInput {
	Scanner sc = new Scanner(System.in);
	CountryDTO dto = new CountryDTO();
	
	public CountryDTO inputInsert () {
		System.out.println("추가할 COUNTRY_ID: ");
		dto.setCounty_id(sc.next());
		System.out.println("추가할 COUNTRY_NAME: ");
		dto.setCoutry_name(sc.next());
		System.out.println("추가할 REGION_ID: ");
		dto.setRegion_id(sc.nextInt());
		return dto;
	}
	public CountryDTO inputUpdate () {
		System.out.println("수정할 COUNTRY_ID: ");
		dto.setCounty_id(sc.next());
		System.out.println("COUNTRY_NAME: ");
		dto.setCoutry_name(sc.next());
		System.out.println("REGION_ID: ");
		dto.setRegion_id(sc.nextInt());
		return dto;
	}
	public CountryDTO inputDelete () {
		System.out.println("삭제할 COUNTRY_ID");
		dto.setCounty_id(sc.next());
		return dto;
	}
}
