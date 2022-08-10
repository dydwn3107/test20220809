package com.yedam.notice;

import com.yedam.common.DAO;

public class NoticeDAO extends DAO{
	
	private static NoticeDAO nd = new NoticeDAO();
	
	private NoticeDAO() {
		
	}
	public static NoticeDAO getInstance() {
		return nd;
	}
	public int registNotice(Notice notice) {
		int result = 0;
		try {
			conn();
			String sql = "insert into notice (notice) values(?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, notice.getNotice());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
	
		
	
}
