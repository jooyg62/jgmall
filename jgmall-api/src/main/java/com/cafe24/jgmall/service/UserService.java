package com.cafe24.jgmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jgmall.repository.UserDao;
import com.cafe24.jgmall.vo.UserVo;
import com.cafe24.jgmall.vo.api.ReqJoinVo;
import com.cafe24.jgmall.vo.api.ReqLoginVo;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;

	public UserVo userLogin(ReqLoginVo reqLoginVo) {
		UserVo userVo = userDao.login(reqLoginVo);
		return userVo;
	}

	public Boolean existId(String id) {
		Boolean result = userDao.selectUserId(id);
		return result;
	}

	public Boolean userJoin(ReqJoinVo reqJoinVo) {
		int result = userDao.insertUserInfo(reqJoinVo);
		return 1 == result;
	}
	
}
