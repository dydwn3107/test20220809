package com.yedam.exe;

import java.util.Scanner;

import com.yedam.card.CardService;
import com.yedam.carmember.CarmemberService;
import com.yedam.clean.CleanService;
import com.yedam.equipment.EquipmentService;
import com.yedam.notice.NoticeService;


public class ManageMent {

	Scanner sc = new Scanner(System.in);
	int menuNo = 0;

	CarmemberService cs = new CarmemberService();
	CardService cd = new CardService();
	CleanService ss = new CleanService();
	EquipmentService es = new EquipmentService();
	NoticeService ns = new NoticeService();
	
	public ManageMent() {
		carWash();
	}

	private void carWash() {
		while (true) {
			menuInfo();
			if (CarmemberService.carmemberInfo.getRole().equals("1")) {
				if (menuNo == 1) {
					cs.registerCustomer();
				} else if (menuNo == 2) {
					cs.getDetailCarmember();
				} else if (menuNo == 3) {
					cs.getCarmember();
				} else if (menuNo == 4) {
					System.out.println("1. 차량 번호 변경 | 2. 차량 정보 변경");
					int menu = Integer.parseInt(sc.nextLine());
					if (menu == 1) {
						cs.updateCarnum();
					} else if (menu == 2) {
						cs.updateCarname();
					}
				} else if (menuNo == 5) {
					cs.deleteCarmember();
				} else if (menuNo == 6) {
					ns.registNotice();
				} else if (menuNo == 7) {
					cs.logout();
					return;
				}
			} else if (CarmemberService.carmemberInfo.getRole().equals("0")) {
				if (menuNo == 1) {
					cd.registCard();
				} else if (menuNo == 2) {
					cd.updateMoney();
				} else if (menuNo == 3) {
					cd.getCardList();
				} else if (menuNo == 4) {
					ss.getDetailClean();
					cd.cleanOutMoney();
				} else if (menuNo == 5) {
					es.getEquipment();
					cd.equipmentOutMoney();
				} else if (menuNo == 6) {
					
				} else if (menuNo == 7) {
					cs.logout();
					return;
				}
			}

		}

	}

	private void menuInfo() {
		if (CarmemberService.carmemberInfo.getRole().equals("1")) {
			System.out.println("1. 회원 등록 | 2. 회원 전체 조회 | 3. 회원 별 조회 | 4. 회원 수정 | 5. 회원 삭제 | 6. 공지사항 등록 | 7. 로그아웃");
		} else if (CarmemberService.carmemberInfo.getRole().equals("0")) {
			System.out.println("1. 카드 등록 | 2. 카드 충전 | 3. 카드 정보 조회 | 4. 세차 메뉴 선택 | 5. 세차 장비 구입 | 6. 로그아웃");
		}
		System.out.println("입력>");
		menuNo = Integer.parseInt(sc.nextLine());
	}
}
