package com.yedam.reserve;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.yedam.carmember.CarmemberService;
import com.yedam.common.DAO;

public class ReserveDAO extends DAO{
	
	private static ReserveDAO rd = new ReserveDAO();

	private ReserveDAO() {
		
	}
	public static ReserveDAO getInstance() {
		return rd;
	}
	public int registReserve(Reserve reserve, Date date) {
		int result = 0;
		try {
			conn();
			String sql = "insert into reserve (carmember_id, reserve_room, reserve_time, reserve_date) values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, CarmemberService.carmemberInfo.getCarmemberId());
			pstmt.setString(2, reserve.getReserveRoom());
			pstmt.setString(3, reserve.getReserveTime());
			pstmt.setDate(4, date);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
	public boolean okReserve(Reserve reserve, Date date) {
	      try {
	         conn();
	         String sql = "select * from reserve where reserve_time = ? and reserve_date = ? and reserve_room = ?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, reserve.getReserveTime());
	         pstmt.setDate(2, date);
	         pstmt.setString(3, reserve.getReserveRoom());
	         rs = pstmt.executeQuery();
	         if (rs.next()) {
	            return false;
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         disconnect();
	      }
	      return true;
	   }
	public List<Reserve> getReserve(){
		List<Reserve> list = new ArrayList<>();
		Reserve reserve = null;
		try {
			conn();
			String sql = "select * from reserve order by reserve_date";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				reserve = new Reserve();
				reserve.setCarmemberId(rs.getString("carmember_id"));
				reserve.setReserveRoom(rs.getString("reserve_room"));
				reserve.setReserveDate(rs.getDate("reserve_date"));
				reserve.setReserveTime(rs.getString("reserve_time"));
				list.add(reserve);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	public List<Reserve> getDetailReserve(String carmemberId){
		List<Reserve> list = new ArrayList<>();
		Reserve reserve = null;
		try {
			conn();
			String sql = "select * from reserve where carmember_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carmemberId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				reserve = new Reserve();
				reserve.setCarmemberId(rs.getString("carmember_id"));
				reserve.setReserveRoom(rs.getString("reserve_room"));
				reserve.setReserveDate(rs.getDate("reserve_date"));
				reserve.setReserveTime(rs.getString("reserve_time"));
				list.add(reserve);
			}
		}catch (Exception e) {
			disconnect();
		}finally {
			disconnect();
		}
		return list;
	}
}
