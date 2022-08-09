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
		
		System.out.println("충전할 카드ID를 입력하세요>");
		String cardId = sc.nextLine();
		System.out.println("충전할 금액을 입력하세요>");
		int money = Integer.parseInt(sc.nextLine());
		ca.setCardId(cardId);
		ca.setBalance(money);
		
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
}
