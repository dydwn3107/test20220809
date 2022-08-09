package com.yedam.carmember;

import java.util.List;
import java.util.Scanner;

public class CarmemberService {
	public static Carmember carmemberInfo = null;
	Scanner sc = new Scanner(System.in);
	
	public void doLogin() {
		Carmember carmember = new Carmember();
		
		System.out.println("ID>");
		String id = sc.nextLine();
		System.out.println("PW>");
		String pw = sc.nextLine();
		
		carmember = CarmemberDAO.getInstance().loginInfo(id);
		
		if(carmember.getCarmemberPw().equals(pw)) {
			carmemberInfo = carmember;
		}else {
			System.out.println("로그인 실패");
		}
	}
	public void logout() {
		if(carmemberInfo != null) {
			carmemberInfo = null;
		}
	}
	public void registerCustomer() {
		Carmember carmember = new Carmember();
		System.out.println("고객 ID>");
		String id = sc.nextLine();
		System.out.println("고객 PW>");
		String pw = sc.nextLine();
		System.out.println("고객 이름>");
		String name = sc.nextLine();
		System.out.println("고객 차량번호>");
		String carnum = sc.nextLine();
		System.out.println("고객 차량종류>");
		String carname = sc.nextLine();
		System.out.println("고객 이메일>");
		String email = sc.nextLine();
		System.out.println("고객 주소>");
		String address = sc.nextLine();
		
		carmember.setCarmemberId(id);
		carmember.setCarmemberPw(pw);
		carmember.setCarmemberName(name);
		carmember.setCarmemberCarnum(carnum);
		carmember.setCarmemberCarname(carname);
		carmember.setCarmemberEmail(email);
		carmember.setCarmemberAddress(address);
		carmember.setRole("0");
		
		int result = CarmemberDAO.getInstance().registMember(carmember);
		
		if(result == 1) {
			System.out.println("고객 정보 등록 완료");
		}else {
			System.out.println("고객 정보 등록 실패");
		}
	}
	public void getDetailCarmember() {
		List<Carmember> list = CarmemberDAO.getInstance().getDetailCarmember();
		for(Carmember carmember : list) {
			System.out.println("**********************");
			System.out.println("고객 ID> " + carmember.getCarmemberId());
			System.out.println("고객 PW> " + carmember.getCarmemberPw());
			System.out.println("고객 이름> " + carmember.getCarmemberName());
			System.out.println("고객 차량번호> " + carmember.getCarmemberCarnum());
			System.out.println("고객 차량종류> " + carmember.getCarmemberCarname());
			System.out.println("고객 이메일> " + carmember.getCarmemberEmail());
			System.out.println("고객 주소> " + carmember.getCarmemberAddress());
			System.out.println("**********************");
		}
	}
	public void getCarmember() {
		System.out.println("조회 할 ID 입력>");
		String id = sc.nextLine();
		List<Carmember> list = CarmemberDAO.getInstance().getCarmember(id);
		
		for(Carmember carmember : list) {
			System.out.println("**********************");
			System.out.println("고객 ID> " + carmember.getCarmemberId());
			System.out.println("고객 PW> " + carmember.getCarmemberPw());
			System.out.println("고객 이름> " + carmember.getCarmemberName());
			System.out.println("고객 차량번호> " + carmember.getCarmemberCarnum());
			System.out.println("고객 차량종류> " + carmember.getCarmemberCarname());
			System.out.println("고객 이메일> " + carmember.getCarmemberEmail());
			System.out.println("고객 주소> " + carmember.getCarmemberAddress());
			System.out.println("**********************");
		}
	}
	public void updateCarnum() {
		Carmember carmember = new Carmember();
		System.out.println("변경할 ID 입력> ");
		String id = sc.nextLine();
		
		System.out.println("변경할 차량 번호를 입력하세요> ");
		String carNum = sc.nextLine();
		
		carmember.setCarmemberId(id);
		carmember.setCarmemberCarnum(carNum);
		
		int result = CarmemberDAO.getInstance().updateCarnum(carmember);
		if(result == 1) {
			System.out.println("차량 번호 변경 완료");
		}else
			System.out.println("차량 번호 변경 실패");
	}
	public void updateCarname() {
		Carmember carmember = new Carmember();
		System.out.println("변경할 ID 입력> ");
		String id = sc.nextLine();
		
		System.out.println("변경할 차량 정보를 입력하세요> ");
		String carName = sc.nextLine();
		
		carmember.setCarmemberId(id);
		carmember.setCarmemberCarname(carName);
		
		int result = CarmemberDAO.getInstance().updateCarname(carmember);
		if(result == 1) {
			System.out.println("차량 정보 변경 완료");
		}else
			System.out.println("차량 정보 변경 실패");
	}
	public void deleteCarmember() {
		System.out.println("삭제 할 회원 ID를 입력하세요> ");
		String carmemberId = sc.nextLine();
		
		int result = CarmemberDAO.getInstance().deleteCarmember(carmemberId);
		if (result == 1) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("삭제 실패");
		}
	}
	
}
