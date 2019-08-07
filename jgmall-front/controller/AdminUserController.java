package com.cafe24.jgmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.jgmall.dto.JSONResult;
import com.cafe24.jgmall.service.AdminUserService;
import com.cafe24.jgmall.vo.api.ResAdminUserBoardVo;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {
	
	@Autowired
	AdminUserService adminUserService;
	
	/**
	 * 관리자 회원 현황판 조회
	 * @return
	 */
	@GetMapping("/board")
	public String login(Model model) {
		JSONResult<ResAdminUserBoardVo> vo = adminUserService.getUserBoard();
		model.addAttribute("vo", vo);
		
		if("fail".equals(vo.getResult())) {
			return "redirect:admin/login";
		}
		
		return "admin/user/board";
	}
	
}
