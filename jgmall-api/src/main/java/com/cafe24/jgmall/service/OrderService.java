package com.cafe24.jgmall.service;

import org.springframework.stereotype.Service;

import com.cafe24.jgmall.vo.UserVo;

@Service
public class OrderService {

	public UserVo userLogin(UserVo userVo) {
		if("jgseo".equals(userVo.getUserId()) && "!@jgseo450".equals(userVo.getPassword())) {
			userVo.setNo(1L);
			userVo.setUserNm("서장규");
			userVo.setJoinDate("2019.07.10");
			userVo.setTelNum("010-4115-6736");
			userVo.setGender("M");
			userVo.setAge(27);
		} else {
			return null;
		}
		
		return userVo;
	}

	public Boolean existId(String id) {
		return "jgseo".equals(id) ? true : false;
	}
	
}
