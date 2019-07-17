package com.cafe24.jgmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jgmall.vo.UserVo;
import com.cafe24.jgmall.vo.api.ResAdminUserBoardVo;

@Repository
public class AdminUserDao {
	
	@Autowired
	private SqlSession sqlSession;

	/**
	 *	회원 현황판 조회 
	 */
	public ResAdminUserBoardVo getUserBoard() {
		ResAdminUserBoardVo resUserBoardVo = sqlSession.selectOne("user.getUserStatistics", null);
		return resUserBoardVo;
	}

	/**
	 *	회원 정보 조회 
	 */
	public List<UserVo> getUserInfoList() {
		List<UserVo> userInfoList = sqlSession.selectList("user.getUserList", null);
		return userInfoList;
	}

}
