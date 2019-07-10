package com.cafe24.jgmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.jgmall.controller.api.JSONResult;
import com.cafe24.jgmall.service.UserService;



@RestController("userAPIController")
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login/{id}", method=RequestMethod.GET)
	public JSONResult main(@PathVariable("id") String id) {
		
		// 유저 정보
//		UserService.userLogin();
		
		// 세션 저장
		
		return JSONResult.success(null);
	}
}
