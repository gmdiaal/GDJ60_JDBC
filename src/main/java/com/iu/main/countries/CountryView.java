package com.iu.main.countries;

import java.util.ArrayList;

public class CountryView {
	
	CountryDTO dto = new CountryDTO();

	public void view (ArrayList<CountryDTO> ar) {
		for(CountryDTO dto:ar) {
			System.out.println(dto.getCounty_id()+" "+dto.getCoutry_name()+" "+dto.getRegion_id());
		}
	}
	public void view (CountryDTO dto) {
		System.out.println(dto.getCounty_id()+" "+dto.getCoutry_name()+" "+dto.getRegion_id());
	}

}
