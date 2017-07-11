package com.haley.practice.dao;

import java.util.List;

import com.haley.practice.domain.UserBoard;

public interface UserBoardDao {

	//// �Լ� ���� ���� ////
	// 1. ����� SQL ���� ����
	// -> select * from userboard
	// 2. �Է� �޾ƾ� �ϴ� �׸��� ������ �Ű� ������ ����, ������ ����
	// 3. ���� Ÿ���� SQL�� ����� 1������ 0�� �̻������� ���� ����
	// -> ���� 0�� �̻� ���� �� �� : List<> Ÿ�� ���
	// -> <>�� ���� ���� ������ �� �ִ� ������ Ÿ��
	public List<UserBoard> boardList();

	// �� ��ȣ�� �ϳ��� �����͸� ��ȸ�ϴ� �޼ҵ�
	// select * from userboard where no = ?
	public UserBoard getBoard(int no);

	// �� ���� �� ��ȸ���� 1 ���� �����ִ� �޼ҵ�
	// update userboard set readcount = readcount + 1 where no = ?
	public int updateReadcount(int no);

	// 2. �Խñ� �ۼ� ����
	// 1) ���� ū ��ȣ�� ã�ƿ��� �Լ�
	// select max(no) from userboard;
	public int maxNo();

	// 2) ���� �����͸� �����ϴ� �Լ�
	// insert into userboard
	// values(#{no},#{title},#{content},#{writer},#{regdate},#{readcount})
	// ���⼭ regdate�� ���� -> sysdate && ���� �ۼ��� readcount �� 0
	// insert into userboard
	// values(#{no},#{title},#{content},#{writer},sysdate,0)
	public int saveBoard(UserBoard userBoard);

	// 3. �Խñ� ���� ����
	// delete from userboard where no = #{no}
	public int deleteBoard(int no);
}
