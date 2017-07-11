package com.haley.practice.domain;

import java.sql.Date;

public class UserBoard {
	
	// 1. 테이블에서 생성한 컬럼이름과 동일한 변수 생성
	private int no;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	/*
	 * java.util.Date - 시간 값이 필요할 때 사용
	 * java.sql.Date - 시간 값이 필요 없을 때 사용
	 */
	private int readcount;
	
	// 2. getter, setter 함수 생성
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	
	// 3. toString() 함수 재정의
	@Override
	public String toString() {
		return "UserBoard [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate="
				+ regdate + ", readcount=" + readcount + "]<br>";
	}
	
	
	
	
	

}
