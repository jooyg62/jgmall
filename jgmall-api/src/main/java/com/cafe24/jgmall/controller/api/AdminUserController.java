package com.cafe24.jgmall.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.jgmall.service.AdminUserService;
import com.cafe24.jgmall.utils.JgmallUtils;
import com.cafe24.jgmall.vo.api.ResAdminUserBoardVo;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.annotations.ApiOperation;

@RestController("adminUserApiController")
@RequestMapping("/api/admin/user")
public class AdminUserController {
	
	@Autowired
	private JgmallUtils jgmallUtils;
	
	@Autowired
	AdminUserService userService;
	
	@ApiOperation(value="회원현황판조회")
	@PostMapping(value="/board")
	public ResponseEntity<JSONResult> login() throws JsonProcessingException {
		
		// 관리자 정보
		ResAdminUserBoardVo resUserBoardVo = userService.getUserInfoList();
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(resUserBoardVo));
	}
	
}
