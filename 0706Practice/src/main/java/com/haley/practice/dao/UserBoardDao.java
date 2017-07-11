package com.haley.practice.dao;

import java.util.List;

import com.haley.practice.domain.UserBoard;

public interface UserBoardDao {

	//// 함수 구상 과정 ////
	// 1. 사용할 SQL 구문 구상
	// -> select * from userboard
	// 2. 입력 받아야 하는 항목이 있으면 매개 변수에 기재, 없으면 생략
	// 3. 리턴 타입은 SQL의 결과가 1개인지 0개 이상인지에 따라 구상
	// -> 행이 0개 이상 리턴 될 때 : List<> 타입 사용
	// -> <>는 열을 전부 저장할 수 있는 데이터 타입
	public List<UserBoard> boardList();

	// 글 번호로 하나의 데이터를 조회하는 메소드
	// select * from userboard where no = ?
	public UserBoard getBoard(int no);

	// 상세 보기 시 조회수를 1 증가 시켜주는 메소드
	// update userboard set readcount = readcount + 1 where no = ?
	public int updateReadcount(int no);

	// 2. 게시글 작성 구현
	// 1) 가장 큰 번호를 찾아오는 함수
	// select max(no) from userboard;
	public int maxNo();

	// 2) 실제 데이터를 삽입하는 함수
	// insert into userboard
	// values(#{no},#{title},#{content},#{writer},#{regdate},#{readcount})
	// 여기서 regdate는 오늘 -> sysdate && 최초 작성시 readcount 는 0
	// insert into userboard
	// values(#{no},#{title},#{content},#{writer},sysdate,0)
	public int saveBoard(UserBoard userBoard);

	// 3. 게시글 삭제 구현
	// delete from userboard where no = #{no}
	public int deleteBoard(int no);
}
