package com.yedam.card;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class CardDAO extends DAO{
	
	private static CardDAO dd = new CardDAO();
	
	private CardDAO() {
		
	}
	public static CardDAO getInstance() {
		return dd;
	}
	
	public int registCard(Card card) {
		int result = 0;
		try {
			conn();
			String sql = "insert into card (carmember_id, card_id, card_pw) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,card.getCarmemberId());
			pstmt.setString(2, card.getCardId());
			pstmt.setString(3, card.getCardPw());
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
	public int updateMoney(Card card) {
		int result = 0;
		try {
			conn();
			String sql = "select balance from card where card_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, card.getCardId());
			rs = pstmt.executeQuery();
			
			int balance = 0;
			if(rs.next()) {
				balance = rs.getInt("balance");
			}
			card.setBalance(balance + card.getBalance());
			
			String sql2 = "update card set balance = ? where card_id = ?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, card.getBalance());
			pstmt.setString(2, card.getCardId());
			result = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
	public List<Card> getCardList(String carmemberId){
		List<Card> list = new ArrayList<>();
		Card card = null;
		try {
			conn();
			String sql = "select * from card where carmember_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carmemberId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				card = new Card();
				card.setCarmemberId(rs.getString("carmember_id"));
				card.setCardId(rs.getString("card_id"));
				card.setCardPw(rs.getString("card_pw"));
				card.setBalance(rs.getInt("balance"));
				list.add(card);		
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	public int outMoney(Card card) {
		int result = 0;
		try {
			conn();
			String sql = "select balance from card where card_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, card.getCardId());
			rs = pstmt.executeQuery();
			
			int balance = 0;
			if(rs.next()) {
				balance = rs.getInt("balance");
			}
			if(balance - card.getBalance() >= 0) {
				card.setBalance(balance - card.getBalance());
				
				String sql2 = "update card set balance = ? where card_id = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, card.getBalance());
				pstmt.setString(2, card.getCardId());
				result = pstmt.executeUpdate();
			}else {
				System.out.println("※잔액이 부족합니다※");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}

	
}
