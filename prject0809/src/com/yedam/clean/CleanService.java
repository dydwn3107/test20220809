package com.yedam.clean;

import java.util.List;
import java.util.Scanner;

public class CleanService {
	public static Clean cleanInfo = null;
	Scanner sc = new Scanner(System.in);
	
	public void getDetailClean() {
		List<Clean> list = CleanDAO.getInstance().getClean();
		int i = 0;
		for(Clean clean : list) {
			i++;
			System.out.println("▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼");
			System.out.println(i+".세차 메뉴> " + clean.getCleanMenu());
			System.out.println(i+".세차 가격> " + clean.getCleanPrice());
			System.out.println("▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲");
		}
	}
}
