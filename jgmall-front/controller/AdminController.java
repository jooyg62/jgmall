package com.cafe24.jgmall.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.jgmall.dto.JSONResult;
import com.cafe24.jgmall.service.AdminService;
import com.cafe24.jgmall.vo.UserVo;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	/**
	 * 관리자 로그인 페이지
	 * @return
	 */
	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}
	
	/**
	 * 관리자 로그인
	 * @return
	 */
	@PostMapping("/login")
	public String doLogin(
			@ModelAttribute UserVo userVo,
			HttpServletRequest request,
			Model model) {
		JSONResult<UserVo> vo = adminService.login(userVo);
		model.addAttribute("vo", vo);
		
		if("fail".equals(vo.getResult())) {
			return "redirect:/admin/login";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("authUser", vo.getData());
		
		return "redirect:/admin/user/board";
	}
	
}
