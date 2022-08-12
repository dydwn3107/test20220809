package com.yedam.equipment;

import java.util.List;
import java.util.Scanner;

public class EquipmentService {
	public static Equipment equipmentInfo = null;
	Scanner sc = new Scanner(System.in);
	
	public void getEquipment() {
		List<Equipment> list = EquipmentDAO.getInstance().getEquipment();
		int i = 0;
		for(Equipment equipment : list) {
			i++;
			System.out.println("▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼");
			System.out.println("▶  "+i+".장비 메뉴> " + equipment.getEquipmentMenu());
			System.out.println("▶  "+i+".장비 가격> " + equipment.getEquipmentPrice());
			System.out.println("▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲");
		}
	}
}
