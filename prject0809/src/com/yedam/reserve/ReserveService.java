package com.yedam.reserve;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class ReserveService {

	Scanner sc = new Scanner(System.in);

	public void registReserve() {
		Reserve rs = new Reserve();

		System.out.println("고객 ID를 입력하세요>");
		String carmemberId = sc.nextLine();
		System.out.println("예약할 세차장을 선택하세요>>(A,B,C,D,E) 중 선택!");
		String reserveRoom = sc.nextLine();
		System.out.println("예약할 시간을 선택하세요");
		System.out.println("▶ 1. 10시 ~ 11시 ◀  ▶ 2. 11시 ~ 12시 ◀  ▶ 3. 13시 ~ 14시 ◀  ▶ 4. 14시 ~ 15시 ◀  ▶ 5. 15시 ~ 16시 ◀");
		System.out.println("▶ 6. 16시 ~ 17시 ◀  ▶ 7. 17시 ~ 18시 ◀  ▶ 8. 18시 ~ 19시 ◀  ▶ 9. 19시 ~ 20시 ◀  ▶ 10. 20시 ~ 21시 ◀");
		
		int reserveTimea = Integer.parseInt(sc.nextLine());
		String roomTime = "";
		switch (reserveTimea) {
		case 1:
			roomTime = "10시 ~ 11시";
			break;
		case 2:
			roomTime = "11시 ~ 12시";
			break;
		case 3:
			roomTime = "12시 ~ 13시";
			break;
		case 4:
			roomTime = "13시 ~ 14시";
			break;
		case 5:
			roomTime = "14시 ~ 15시";
			break;
		case 6:
			roomTime = "15시 ~ 16시";
			break;
		case 7:
			roomTime = "16시 ~ 17시";
			break;
		case 8:
			roomTime = "17시 ~ 18시";
			break;
		case 9:
			roomTime = "18시 ~ 19시";
			break;
		case 10:
			roomTime = "19시 ~ 20시";
			break;
		}
		System.out.println("예약 할 날짜를 입력하세요>");
		String strDate = sc.nextLine();
		Date date = Date.valueOf(strDate);
		rs.setCarmemberId(carmemberId);
		rs.setReserveRoom(reserveRoom);
		rs.setReserveTime(roomTime);
		if (ReserveDAO.getInstance().okReserve(rs, date)) {
			int result = ReserveDAO.getInstance().registReserve(rs, date);
			System.out.println(result == 1 ? "예약 완료" : "예약 실패");
		} else {
			System.out.println("이미 예약이 되어 있습니다. ※예약 실패※");
		}

	}
	public void getReserve() {
		List<Reserve> list = ReserveDAO.getInstance().getReserve();
		for(Reserve reserve : list) {
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
			System.out.println("▦    고객 ID> " + reserve.getCarmemberId());
			System.out.println("▦    예약 세차장> " + reserve.getReserveRoom());
			System.out.println("▦    예약날짜> " + reserve.getReserveDate());
			System.out.println("▦    예약시간> " + reserve.getReserveTime());
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
		}
	}
	public void getDetailReserve() {
		System.out.println("조회할 ID 입력>");
		String id = sc.nextLine();
		List<Reserve> list = ReserveDAO.getInstance().getDetailReserve(id);
		for(Reserve reserve : list) {
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
			System.out.println("▦   고객 ID> " + reserve.getCarmemberId());
			System.out.println("▦   예약 세차장> " + reserve.getReserveRoom()); 
			System.out.println("▦   예약날짜> " + reserve.getReserveDate());
			System.out.println("▦   예약시간> " + reserve.getReserveTime());
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
		}
	}
}
