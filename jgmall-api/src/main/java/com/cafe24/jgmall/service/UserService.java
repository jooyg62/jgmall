package com.cafe24.jgmall.service;

import org.springframework.stereotype.Service;

import com.cafe24.jgmall.vo.UserVo;
import com.cafe24.jgmall.vo.api.ReqJoinVo;
import com.cafe24.jgmall.vo.api.ReqLoginVo;

@Service
public class UserService {

	public UserVo userLogin(ReqLoginVo reqLoginVo) {
		UserVo authUser = new UserVo();
		if("jgseo".equals(reqLoginVo.getUserId()) && "!@jgseo450".equals(reqLoginVo.getPassword())) {
			authUser.setNo(1L);
			authUser.setUserId(reqLoginVo.getUserId());
			authUser.setUserNm("서장규");
			authUser.setJoinDate("2019.07.10");
			authUser.setTelNum("01041156736");
			authUser.setGender("M");
			authUser.setAge(27);
		} else {
			return null;
		}
		
		return authUser;
	}

	public Boolean existId(String id) {
		return "jgseo".equals(id) ? true : false;
	}

	public Boolean userJoin(ReqJoinVo reqJoinVo) {
		return true;
	}
	
}
