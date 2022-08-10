package com.yedam.card;

import java.util.List;
import java.util.Scanner;

import com.yedam.carmember.CarmemberService;

public class CardService {

	Scanner sc = new Scanner(System.in);
	
	public void registCard() {
		Card ca = new Card();
		
		System.out.println("고객 ID를 입력하세요>");
		String carmemberId = sc.nextLine();
		System.out.println("만들 카드 ID를 입력하세요>");
		String cardId = sc.nextLine();
		System.out.println("만들 카드 PW를 입력하세요>");
		String cardPw = sc.nextLine();
		
		ca.setCarmemberId(carmemberId);
		ca.setCardId(cardId);
		ca.setCardPw(cardPw);
		
		int result = CardDAO.getInstance().registCard(ca);
		if(result == 1) {
			System.out.println("카드 등록 완료");
		}else {
			System.out.println("카드 등록 실패");
		}
	}
	public void updateMoney() {
		Card ca = new Card();
		int event1 = 0;
		System.out.println("충전할 카드ID를 입력하세요>");
		String cardId = sc.nextLine();
		System.out.println("충전할 금액을 입력하세요>");
		int money = Integer.parseInt(sc.nextLine());
		if(money <= 10000) {
			System.out.println("★이벤트★ 5% 보너스 충전됩니다.");
			event1 = (int) (money + money * 0.05);
			ca.setBalance(event1);
		}else if(money >= 10000 && money <= 30000) {
			System.out.println("★이벤트★ 10% 보너스 충전됩니다.");
			event1 = (int) (money + money * 0.1);
			ca.setBalance(event1);
		}else if(money >= 50000) {
			System.out.println("★이벤트★ 20% 보너스 충전됩니다.");
			event1 = (int) (money + money * 0.2);
			ca.setBalance(event1);
		}
		ca.setCardId(cardId);
		
		
		int result = CardDAO.getInstance().updateMoney(ca);
		if(result == 1) {
			System.out.println("충전 완료");
		}else {
			System.out.println("충전 실패");
		}
	}
	public void getCardList() {
		List<Card> list = 
				CardDAO.getInstance().getCardList(CarmemberService.carmemberInfo.getCarmemberId());
		System.out.println(CarmemberService.carmemberInfo.getCarmemberName() + "님의 카드 정보");
		for(Card card : list) {
			System.out.println("카드 ID> " + card.getCardId());
			System.out.println("카드 PW> " + card.getCardPw());
			System.out.println("카드 잔고> " + card.getBalance());
		}
	}
	public void cleanOutMoney() {
		Card ca = new Card();
		System.out.println("▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼");
		System.out.println("1. ● 고압 세차 ● 5000원");
		System.out.println("2. ● 일반 세차 ● 3000원");
		System.out.println("3. ● 버블 세차 ● 7000원");
		System.out.println("4. ● 프리미엄 세차 ● 15000원");
		System.out.println("5. ● 공기압 세차 ● 10000원");
		System.out.println("▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲");
		System.out.println("원하는 번호를 선택하세요>");
		int num = Integer.parseInt(sc.nextLine());
		if(num == 1) {
			System.out.println("카드 ID>");
			String id1 = sc.nextLine();
			int money1 = 5000;
			ca.setCardId(id1);
			ca.setBalance(money1);
		}else if (num == 2) {
			System.out.println("카드 ID>");
			String id2 = sc.nextLine();
			int money2 = 3000;
			ca.setCardId(id2);
			ca.setBalance(money2);
		}else if (num == 3) {
			System.out.println("카드 ID>");
			String id3 = sc.nextLine();
			int money3 = 7000;
			ca.setCardId(id3);
			ca.setBalance(money3);
		}else if (num == 4) {
			System.out.println("카드 ID>");
			String id4 = sc.nextLine();
			int money4 = 15000;
			ca.setCardId(id4);
			ca.setBalance(money4);
		}else if (num == 5) {
			System.out.println("카드 ID>");
			String id5 = sc.nextLine();
			int money5 = 10000;
			ca.setCardId(id5);
			ca.setBalance(money5);
		}
		int result = CardDAO.getInstance().outMoney(ca);
		if(result == 1) {
			System.out.println("$정상 출금 완료$");
		}else {
			System.out.println("※출금 실패※");
		}	
	}
	public void equipmentOutMoney() {
		Card ca = new Card();
		System.out.println("▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼");
		System.out.println("1. ● 타월, 수건 ● 5000원");
		System.out.println("2. ● 브러쉬● 10000원");
		System.out.println("3. ● 타이어 세정제 ● 8000원");
		System.out.println("4. ● 유리 세정제 ● 6000원");
		System.out.println("5. ● 내부 세정제 ● 7000원");
		System.out.println("6. ● 외부 세정제 ● 7000원");
		System.out.println("7. ● 코팅제 ● 28000원");
		System.out.println("▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲");
		System.out.println("원하는 번호를 선택하세요>");
		int num = Integer.parseInt(sc.nextLine());
		if(num == 1) {
			System.out.println("카드 ID>");
			String id1 = sc.nextLine();
			int money1 = 5000;
			ca.setCardId(id1);
			ca.setBalance(money1);
		}else if (num == 2) {
			System.out.println("카드 ID>");
			String id2 = sc.nextLine();
			int money2 = 10000;
			ca.setCardId(id2);
			ca.setBalance(money2);
		}else if (num == 3) {
			System.out.println("카드 ID>");
			String id3 = sc.nextLine();
			int money3 = 8000;
			ca.setCardId(id3);
			ca.setBalance(money3);
		}else if (num == 4) {
			System.out.println("카드 ID>");
			String id4 = sc.nextLine();
			int money4 = 6000;
			ca.setCardId(id4);
			ca.setBalance(money4);
		}else if (num == 5) {
			System.out.println("카드 ID>");
			String id5 = sc.nextLine();
			int money5 = 7000;
			ca.setCardId(id5);
			ca.setBalance(money5);
		}else if (num == 6) {
			System.out.println("카드 ID>");
			String id6 = sc.nextLine();
			int money6 = 7000;
			ca.setCardId(id6);
			ca.setBalance(money6);
		}else if (num == 7) {
			System.out.println("카드 ID>");
			String id7 = sc.nextLine();
			int money7 = 28000;
			ca.setCardId(id7);
			ca.setBalance(money7);
		}
		int result = CardDAO.getInstance().outMoney(ca);
		if(result == 1) {
			System.out.println("$정상 출금 완료$");
		}else {
			System.out.println("※출금 실패※");
		}	
	}
	
}
