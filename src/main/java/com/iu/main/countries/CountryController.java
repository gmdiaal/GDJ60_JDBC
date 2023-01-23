package com.iu.main.countries;

import java.util.ArrayList;
import java.util.Scanner;

public class CountryController {
	Scanner sc = new Scanner(System.in);
	CountryDAO dao = new CountryDAO();
	CountryView view = new CountryView();
	CountryInput input = new CountryInput();
	
	public void start () throws Exception {
		boolean check = true;
		
		while (check) {
			CountryDTO dto = null;
			System.out.println("1. 나라 조회 2. ID로 조회 3. 추가 4. 수정 5. 삭제 x. 종료");
			int select = sc.nextInt();
			switch (select) {
				case 1:
					ArrayList<CountryDTO> ar = null;
					ar = dao.getList();
					view.view(ar);
					break;
				case 2:
					System.out.println("찾을 국가 tag(2) 입력");
					String id = sc.next();
					
					dto = dao.getID(id);
					
					if (dto!=null) { view.view(dto);
					}else {System.out.println("찾는 국가 없음");}
					break;
				case 3:
					dto = input.inputInsert();
					select = dao.setInsert(dto);
					if (select>0) {System.out.println("추가 성공");}else {System.out.println("추가실패");}
					break;
				case 4:
					dto = input.inputUpdate();
					select = dao.setUpdate(dto);
					if (select>0) {
						System.out.println("수정 성공");
					} else {System.out.println("수정 실패");}
					break;
				case 5:
					 dto = input.inputDelete();
					 select = dao.setDelete(dto);
					 if (select>0) {
						 System.out.println("삭제 성공");
					 }else {System.out.println("삭제 실패");}
					break;
				default:
					check = false;
			}
		}
	}
}
