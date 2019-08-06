package com.cafe24.jgmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.jgmall.dto.JSONResult;
import com.cafe24.jgmall.dto.jsonresult.ObjectJSONResult;
import com.cafe24.jgmall.dto.jsonresult.UserVoJSONResult;
import com.cafe24.jgmall.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	RestTemplate restTemplate;

	/**
	 * 유저 로그인
	 * @param userVo login 정보
	 * @return 유저 정보
	 */
	public JSONResult<UserVo> login(UserVo userVo) {
		String endpoint = "http://localhost:8888/jgmall-api/api/user/login";
		JSONResult<UserVo> jsonResult = (JSONResult<UserVo>) restTemplate.postForObject(endpoint, userVo, UserVoJSONResult.class);
		return jsonResult;
	}
	
	/**
	 * 유저 회원가입
	 * @param userVo 가입 정보
	 * @return
	 */
	public JSONResult<Object> join(UserVo userVo) {
		String endpoint = "http://localhost:8888/jgmall-api/api/user/join";
		JSONResult<Object> jsonResult = (JSONResult<Object>) restTemplate.postForObject(endpoint, userVo, ObjectJSONResult.class);
		return jsonResult;
	}
	
}
