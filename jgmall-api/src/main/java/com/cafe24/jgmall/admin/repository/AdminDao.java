package com.cafe24.jgmall.admin.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jgmall.admin.vo.api.ReqAdminLoginVo;
import com.cafe24.jgmall.admin.vo.api.ResAdminLoginVo;

@Repository
public class AdminDao {
	
	@Autowired
	private SqlSession sqlSession;

	public ResAdminLoginVo selectAdmin(ReqAdminLoginVo reqAdminLoginVo) {
		ResAdminLoginVo resAdminLoginVo = sqlSession.selectOne("admin.getAdminInfo", reqAdminLoginVo);
		return resAdminLoginVo;
	}

}
