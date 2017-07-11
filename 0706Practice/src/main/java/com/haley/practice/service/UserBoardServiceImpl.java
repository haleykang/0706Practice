package com.haley.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haley.practice.dao.UserBoardDao;
import com.haley.practice.domain.UserBoard;

@Service // Service 클래스 선언
public class UserBoardServiceImpl implements UserBoardService {

	// UserBoardDao 객체를 자동으로 주입
	@Autowired
	private UserBoardDao userBoardDao;

	@Override
	public List<UserBoard> boardList() {
		// 매개 변수가 없는 경우 Dao 메소드만 호출해서 리턴
		return userBoardDao.boardList();
	}

	@Override
	public UserBoard getBoard(int no) {
		// 조회수를 업데이트(+1)하는 메소드 실행
		userBoardDao.updateReadcount(no);
		// 하나의 데이터를 가져오는 메소드를 실행 후 return
		return userBoardDao.getBoard(no);
	}

	@Override
	public int saveBoard(UserBoard userBoard) {
		// 1. 가장 큰 no 값을 가져오는 메소드 실행
		int no = userBoardDao.maxNo();
		// 2. 가장 큰 번호 + 1 해서 DTO 클래스에 저장
		userBoard.setNo(no + 1);
		// 3. 데이터를 저장하는 함수 실행 
		return userBoardDao.saveBoard(userBoard);
	}

	@Override
	public int deleteBoard(int no) {
		
		return userBoardDao.deleteBoard(no);
	}

}
