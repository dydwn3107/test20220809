package com.yedam.exe;

import java.util.Scanner;

import com.yedam.carmember.CarmemberService;

public class Application {
	Scanner sc = new Scanner(System.in);
	CarmemberService cs = new CarmemberService();
	int menuNo = 0;

	public Application() {
		start();
	}

	private void start() {
		boolean yes = true;
		while (yes) {
			System.out.println("1. 로그인 | 2. 종료");
			menuNo = Integer.parseInt(sc.nextLine());
			switch (menuNo) {
			case 1:
				// 로그인 하는 기능
				cs.doLogin();
				if (CarmemberService.carmemberInfo != null) {
					new ManageMent();
				}
				break;
			case 2:
				System.out.println("프로그램 종료 ♬");
				yes = false;
				break;
			}
		}
	}
}
