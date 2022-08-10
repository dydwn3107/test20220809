package com.yedam.equipment;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class EquipmentDAO extends DAO{

	private static EquipmentDAO ed = new EquipmentDAO();
	
	private EquipmentDAO() {
		
	}
	public static EquipmentDAO getInstance() {
		return ed;
	}
	public List<Equipment> getEquipment(){
		List<Equipment> list = new ArrayList<>();
		Equipment equipment = null;
		try {
			conn();
			String sql = "select * from equipment";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				equipment = new Equipment();
				equipment.setEquipmentMenu(rs.getString("equipment_menu"));
				equipment.setEquipmentPrice(rs.getInt("equipment_price"));
				
				list.add(equipment);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
}
