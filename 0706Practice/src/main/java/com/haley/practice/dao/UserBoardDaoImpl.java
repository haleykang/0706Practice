package com.haley.practice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haley.practice.domain.UserBoard;

@Repository // 객체 생성을 자동으로 하도록 해주는 어노테이션
public class UserBoardDaoImpl implements UserBoardDao {

	// 마이바티스 연동을 위한 SqlSession 객체 생성
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<UserBoard> boardList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("userboard.boardList");
	}

	@Override
	public UserBoard getBoard(int no) {

		return sqlSession.selectOne("userboard.getBoard", no);
	}

	@Override
	public int updateReadcount(int no) {

		return sqlSession.update("userboard.updateReadcount", no);
	}

	@Override
	public int maxNo() {

		return sqlSession.selectOne("userboard.maxNo");
	}

	@Override
	public int saveBoard(UserBoard userBoard) {

		return sqlSession.insert("userboard.saveBoard", userBoard);
	}

	@Override
	public int deleteBoard(int no) {

		return sqlSession.delete("userboard.deleteBoard", no);
	}

}
