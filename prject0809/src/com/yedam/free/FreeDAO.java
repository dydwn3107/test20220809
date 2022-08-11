package com.yedam.free;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.notice.Notice;

public class FreeDAO extends DAO{
	
	private static FreeDAO fd = new FreeDAO();
	
	private FreeDAO() {
		
	}
	public static FreeDAO getInstance() {
		return fd;
	}
	public int registFree(Free free) {
		int result = 0;
		try {
			conn();
			String sql = "insert into free (free_taxt, free_num) values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, free.getFreeTaxt());
			pstmt.setString(2, free.getFreeNum());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
	public List<Free> getFree(){
		List<Free> list = new ArrayList<>();
		Free free = null;
		try {
			conn();
			String sql = "select * from free";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				free = new Free();
				free.setFreeTaxt(rs.getString("free_taxt"));
				free.setFreeNum(rs.getString("free_num"));
				
				list.add(free);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
}
