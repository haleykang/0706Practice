package com.haley.practice.service;

import java.util.List;

import com.haley.practice.domain.UserBoard;

public interface UserBoardService {

	// 전체 게시글을 가져오는 메소드
	public List<UserBoard> boardList();

	// 글 번호로 하나의 데이터를 가져오는 메소드
	public UserBoard getBoard(int no);
	
	// !!!! 서비스에는 하나의 작업당 하나의 주요 메소드만 선언
	// 데이터를 삽입하는 메소드 
	public int saveBoard(UserBoard userBoard);
	
	// 데이터 삭제 메소드
	public int deleteBoard(int no);

}
