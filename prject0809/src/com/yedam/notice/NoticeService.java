package com.yedam.notice;

import java.util.List;
import java.util.Scanner;

public class NoticeService {

	Scanner sc = new Scanner(System.in);

	public void registNotice() {
		Notice no = new Notice();
		System.out.println("공지사항의 제목을 입력하세요>");
		String noticeNum = sc.nextLine();

		StringBuilder builder = new StringBuilder();
		System.out.println("공지사항에 넣을 내용을 입력하세요, 종료를 원하시면 q를 입력하세요");
		System.out.println("==============공지사항==============");
		while (true) {
			String noticeTaxt = sc.nextLine();
			if (noticeTaxt.equals("q")) {
				break;
			}
			builder.append(System.lineSeparator());
			builder.append(noticeTaxt);
		}
		no.setNoticeNum(noticeNum);
		no.setNoticeTaxt(builder.toString());
		int result = NoticeDAO.getInstance().registNotice(no);
		if (result == 1) {
			System.out.println("등록 완료");
		} else {
			System.out.println("등록 실패");
		}

	}

	public void getNotice() {
		List<Notice> list = NoticeDAO.getInstance().getNotice();

		System.out.println("===============공지사항================================");

		for (Notice notice : list) {
			System.out.println("---------------제목: " + notice.getNoticeNum() + "-----------------");
			System.out.println(notice.getNoticeTaxt());
		}
		System.out.println("====================================================");
	}

	public void deleteNotice() {
		System.out.println("삭제할 공지사항의 제목을 입력하세요> ");
		String noticeNum = sc.nextLine();

		int result = NoticeDAO.getInstance().deleteNotice(noticeNum);
		if (result == 0) {
			System.out.println("정확한 제목을 입력해 주세요 ※삭제 실패※");
		} else {
			System.out.println("삭제 완료");
		}
	}
	public void updateNotice() {
		Notice notice = new Notice();
		System.out.println("변경할 제목을 입력하세요>");
		String noticeNum = sc.nextLine();
		System.out.println("공지사항에 넣을 내용을 입력하세요, 종료를 원하시면 q를 입력하세요");
		System.out.println("==============공지사항==============");
		StringBuilder builder = new StringBuilder();
		while (true) {
			String noticeTaxt = sc.nextLine();
			if (noticeTaxt.equals("q")) {
				break;
			}
			builder.append(System.lineSeparator());
			builder.append(noticeTaxt);
		}
		notice.setNoticeNum(noticeNum);
		notice.setNoticeTaxt(builder.toString());
		
		int result = NoticeDAO.getInstance().updateNotice(notice);
		if(result == 1) {
			System.out.println("공지사항 변경 완료");
		}else {
			System.out.println("공지사항 변경 실패");
		}
	}
}
