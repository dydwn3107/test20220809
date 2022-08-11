package com.yedam.reserve;

import java.sql.Date;

import lombok.Data;

@Data
public class Reserve {
	private String carmemberId;
	private String reserveRoom;
	private String reserveTime;
	private Date reserveDate;
	

}
