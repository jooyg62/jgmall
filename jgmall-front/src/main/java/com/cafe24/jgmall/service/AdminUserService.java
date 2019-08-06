package com.cafe24.jgmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.jgmall.dto.JSONResult;
import com.cafe24.jgmall.vo.api.ResAdminUserBoardVo;

@Service
public class AdminUserService {
	
	@Autowired
	RestTemplate restTemplate;

	/**
	 * 관리자 회원 현황판 조회
	 * @return
	 */
	public JSONResult<ResAdminUserBoardVo> getUserBoard() {
		String endpoint = "http://localhost:8888/jgmall-api/api/admin/user/board";
		JSONResult<ResAdminUserBoardVo> jsonResult = restTemplate.getForObject(endpoint, AdminUserBoardJSONResult.class);
		return jsonResult;
	}
	
	public static class AdminUserBoardJSONResult extends JSONResult<ResAdminUserBoardVo> {
	}
}
