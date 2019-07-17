package com.cafe24.jgmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jgmall.repository.AdminUserDao;
import com.cafe24.jgmall.vo.UserVo;
import com.cafe24.jgmall.vo.api.ResAdminUserBoardVo;

@Service
public class AdminUserService {
	
	@Autowired
	private AdminUserDao userDao;

	public ResAdminUserBoardVo getUserInfoList() {
		ResAdminUserBoardVo resUserBoardVo = userDao.getUserBoard();
		List<UserVo> userInfoList = userDao.getUserInfoList();
		resUserBoardVo.setUserInfoList(userInfoList);
		return resUserBoardVo;
	}
	
}
