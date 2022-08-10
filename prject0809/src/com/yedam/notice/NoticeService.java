package com.yedam.notice;

import java.util.Scanner;

public class NoticeService {
	
	Scanner sc = new Scanner(System.in);
	
	public void registNotice() {
		Notice no = new Notice();
		
		while(true) {
			System.out.println("공지사항에 넣을 내용을 입력하세요, 종료를 원하시면 q를 입력하세요");
			System.out.println("==============공지사항==============");
			String notice = sc.nextLine();
			if(notice.equals("q")) {
				break;
			}
			no.setNotice(notice);
			
			int result = NoticeDAO.getInstance().registNotice(no);
			if(result == 1) {
				System.out.println("등록 완료");
			}else {
				System.out.println("등록 실패");
			}
		}
	}
}
