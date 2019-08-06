package com.cafe24.jgmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	/**
	 * 로그인 페이지
	 * @return
	 */
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	/**
	 * 로그인
	 * @return
	 */
	@PostMapping("/login")
	public String doLogin() {
		return "user/login";
	}
	
}
