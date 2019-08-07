package com.cafe24.jgmall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.jgmall.dto.JSONResult;
import com.cafe24.jgmall.service.MainService;
import com.cafe24.jgmall.vo.ProductVo;

@Controller
public class MainController {
	
	@Autowired
	MainService mainService;
	
	/**
	 * 메인 페이지
	 * @return
	 */
	@RequestMapping({"/", "/main"})
	public String main() {
		return "main/index";
	}
	
	/**
	 * 메인 페이지
	 * @return
	 */
	@GetMapping({"/", "/main"})
	public String main(
			HttpServletRequest request,
			Model model) {
		
		JSONResult<List<ProductVo>> vo = mainService.getProductList();
		model.addAttribute("vo", vo);
		
		if("fail".equals(vo.getResult())) {
			return "redirect:/user/login";
		}
		
		return "main/index";
	}
	
}
