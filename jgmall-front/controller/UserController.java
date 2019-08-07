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
import com.cafe24.jgmall.service.UserService;
import com.cafe24.jgmall.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
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
	public String doLogin(
			@ModelAttribute UserVo userVo,
			HttpServletRequest request,
			Model model) {
		JSONResult<UserVo> vo = userService.login(userVo);
		model.addAttribute("vo", vo);
		
		if("fail".equals(vo.getResult())) {
			return "redirect:/user/login";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("mallAuthUser", vo.getData());
		
		return "redirect:/main";
	}
	
	/**
	 * 회원가입 페이지
	 * @return
	 */
	@GetMapping("/join")
	public String join() {
		return "user/join";
	}
	
	/**
	 * 회원가입
	 * @return
	 */
	@PostMapping("/join")
	public String doJoin(
			@ModelAttribute UserVo userVo,
			Model model) {
		JSONResult<Object> vo = userService.join(userVo);
		model.addAttribute("vo", vo);
		
		if("fail".equals(vo.getResult())) {
			return "redirect:/user/join";
		}
		
		return "redirect:/user/login";
	}
	
}
