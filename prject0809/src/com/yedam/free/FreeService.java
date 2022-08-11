package com.yedam.free;

import java.util.List;
import java.util.Scanner;

import com.yedam.notice.Notice;
import com.yedam.notice.NoticeDAO;

public class FreeService {
	Scanner sc = new Scanner(System.in);
	
	public void registFree() {
		Free fe = new Free();
		System.out.println("자유게시판에 넣을 제목을 입력하세요>");
		String freeNum = sc.nextLine();
		
		StringBuilder builder = new StringBuilder();
		System.out.println("자유게시판에 넣을 내용을 입력하세요, 종료를 원하시면 q를 입력하세요");
		System.out.println("==============자유 게시판==============");
		while (true) {
			String freeTaxt = sc.nextLine();
			if (freeTaxt.equals("q")) {
				break;
			}
			builder.append(System.lineSeparator());
			builder.append(freeTaxt);
		}
		fe.setFreeNum(freeNum);
		fe.setFreeTaxt(builder.toString());
		int result = FreeDAO.getInstance().registFree(fe);
		if (result == 1) {
			System.out.println("등록 완료");
		} else {
			System.out.println("등록 실패");
		}
	}
	public void getfree() {
		List<Free> list = FreeDAO.getInstance().getFree();

		System.out.println("===============자유 게시판================================");

		for (Free free : list) {
			System.out.println("---------------제목: " + free.getFreeNum() + "-----------------");
			System.out.println(free.getFreeTaxt());
		}
		System.out.println("=======================================================");
	}

}
