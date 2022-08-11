package com.yedam.notice;

import java.util.ArrayList;
import java.util.List;

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
			String sql = "insert into notice (notice_taxt, notice_num) values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, notice.getNoticeTaxt());
			pstmt.setString(2, notice.getNoticeNum());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
	public List<Notice> getNotice(){
		List<Notice> list = new ArrayList<>();
		Notice notice = null;
		try {
			conn();
			String sql = "select * from notice";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				notice = new Notice();
				notice.setNoticeTaxt(rs.getString("notice_taxt"));
				notice.setNoticeNum(rs.getString("notice_num"));
				
				list.add(notice);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	public int deleteNotice(String noticeNum) {
		int result = 0;
		try {
			conn();
			String sql = "delete from notice where notice_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeNum);
			
			result = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
	public int updateNotice(Notice notice) {
		int result = 0;
		try {
			conn();
			String sql = "update notice set notice_taxt = ? where notice_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, notice.getNoticeTaxt());
			pstmt.setString(2, notice.getNoticeNum());
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
}
