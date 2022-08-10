package com.yedam.event;

import com.yedam.common.DAO;

public class EventDAO extends DAO{
	
	private static EventDAO ed = new EventDAO();
	
	private EventDAO() {
		
	}
	public static EventDAO getInstance() {
		return ed;
	}
	
	public int eventMoney(Event event) {
		int result = 0;
		try {
			conn();
			String sql = "update event set balance = ? where card_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, event.getEventMoney());
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
		
	}
}
