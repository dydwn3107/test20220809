package com.yedam.clean;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class CleanDAO extends DAO{
	
	private static CleanDAO ea = new CleanDAO();
	
	private CleanDAO() {
		
	}
	public static CleanDAO getInstance() {
		return ea;
	}
	public List<Clean> getClean() {
		List<Clean> list = new ArrayList<>();
		Clean clean = null;
		try {
			conn();
			String sql = "select * from clean";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				clean = new Clean();
				clean.setCleanMenu(rs.getString("clean_menu"));
				clean.setCleanPrice(rs.getInt("clean_price"));
				
				list.add(clean);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
		
	}
	
}
