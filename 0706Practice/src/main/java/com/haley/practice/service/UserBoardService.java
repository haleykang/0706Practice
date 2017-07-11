package com.haley.practice.service;

import java.util.List;

import com.haley.practice.domain.UserBoard;

public interface UserBoardService {

	// ��ü �Խñ��� �������� �޼ҵ�
	public List<UserBoard> boardList();

	// �� ��ȣ�� �ϳ��� �����͸� �������� �޼ҵ�
	public UserBoard getBoard(int no);
	
	// !!!! ���񽺿��� �ϳ��� �۾��� �ϳ��� �ֿ� �޼ҵ常 ����
	// �����͸� �����ϴ� �޼ҵ� 
	public int saveBoard(UserBoard userBoard);
	
	// ������ ���� �޼ҵ�
	public int deleteBoard(int no);

}
