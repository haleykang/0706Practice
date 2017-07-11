package com.haley.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haley.practice.dao.UserBoardDao;
import com.haley.practice.domain.UserBoard;

@Service // Service Ŭ���� ����
public class UserBoardServiceImpl implements UserBoardService {

	// UserBoardDao ��ü�� �ڵ����� ����
	@Autowired
	private UserBoardDao userBoardDao;

	@Override
	public List<UserBoard> boardList() {
		// �Ű� ������ ���� ��� Dao �޼ҵ常 ȣ���ؼ� ����
		return userBoardDao.boardList();
	}

	@Override
	public UserBoard getBoard(int no) {
		// ��ȸ���� ������Ʈ(+1)�ϴ� �޼ҵ� ����
		userBoardDao.updateReadcount(no);
		// �ϳ��� �����͸� �������� �޼ҵ带 ���� �� return
		return userBoardDao.getBoard(no);
	}

	@Override
	public int saveBoard(UserBoard userBoard) {
		// 1. ���� ū no ���� �������� �޼ҵ� ����
		int no = userBoardDao.maxNo();
		// 2. ���� ū ��ȣ + 1 �ؼ� DTO Ŭ������ ����
		userBoard.setNo(no + 1);
		// 3. �����͸� �����ϴ� �Լ� ���� 
		return userBoardDao.saveBoard(userBoard);
	}

	@Override
	public int deleteBoard(int no) {
		
		return userBoardDao.deleteBoard(no);
	}

}
