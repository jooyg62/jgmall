package com.cafe24.jgmall.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jgmall.vo.UserVo;
import com.cafe24.jgmall.vo.api.ReqJoinVo;
import com.cafe24.jgmall.vo.api.ReqLoginVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public UserVo get(String email) {
		return sqlSession.selectOne("user.getByEmail", email);
	}

	public int insertUserInfo(ReqJoinVo reqJoinVo) {
		return sqlSession.insert("user.insertUser", reqJoinVo);
	}

	public UserVo login(ReqLoginVo reqLoginVo) {
		return sqlSession.selectOne("user.login", reqLoginVo);
	}

	public Boolean selectUserId(String id) {
		int count = sqlSession.selectOne("user.selectUserId", id);
		return 1 == count;
	}

}
