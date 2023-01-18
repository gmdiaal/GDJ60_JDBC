package com.iu.main.locations;

import java.util.ArrayList;

public class LocationView {
	
	public void view (ArrayList<LocationDTO> ar) {
		for (LocationDTO locationDTO:ar) { this.view(locationDTO); }
		//for(int i=0; i<ar.size();i++) { this.view(ar.get(i)); }
	}

	public void view( LocationDTO dto ) {
		System.out.println(dto.getCITY());
		System.out.println(dto.getCOUNTRY_ID());
		System.out.println(dto.getSTATE_PROVINCE());
		System.out.println(dto.getSTREET_ADDRESS());
		System.out.println(dto.getLOCATION_ID());
	}
	public void view (String str) {
		System.out.println(str);
	}
	
}
