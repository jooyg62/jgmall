package com.cafe24.jgmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.jgmall.dto.JSONResult;
import com.cafe24.jgmall.dto.jsonresult.UserVoJSONResult;
import com.cafe24.jgmall.vo.UserVo;

@Service
public class AdminService {
	
	@Autowired
	RestTemplate restTemplate;

	/**
	 * 관리자 로그인
	 * @param userVo login 정보
	 * @return 관리자 정보
	 */
	public JSONResult<UserVo> login(UserVo userVo) {
		String endpoint = "http://localhost:8888/jgmall-api/api/admin/login";
		JSONResult<UserVo> jsonResult = (JSONResult<UserVo>) restTemplate.postForObject(endpoint, userVo, UserVoJSONResult.class);
		return jsonResult;
	}
	
}
