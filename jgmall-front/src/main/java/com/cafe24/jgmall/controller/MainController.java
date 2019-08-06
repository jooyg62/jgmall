package com.cafe24.jgmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	/**
	 * 메인 페이지
	 * @return
	 */
	@RequestMapping({"/", "/main"})
	public String main() {
		return "main/index";
	}
	
}
