package com.cafe24.jgmall.controller;

import java.util.List;

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
import com.cafe24.jgmall.service.AdminShopService;
import com.cafe24.jgmall.vo.ProductVo;
import com.cafe24.jgmall.vo.UserVo;

@Controller
@RequestMapping("/admin/shop")
public class AdminShopController {
	
	@Autowired
	AdminShopService adminShopService;
	
	/**
	 * 관리자 상품 목록 조회
	 * @return
	 */
	@GetMapping("/product/list")
	public String getProductList(
			HttpServletRequest request,
			Model model) {
		
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		if(authUser == null) {
			return "redirect:admin/login";
		}
		
		JSONResult<List<ProductVo>> vo = adminShopService.getProductList();
		model.addAttribute("vo", vo);
		
		if("fail".equals(vo.getResult())) {
			return "redirect:admin/login";
		}
		
		return "admin/product/list";
	}
	
	/**
	 * 관리자 상품 등록
	 * @return
	 */
	@PostMapping("/product")
	public String registProduct(
			@ModelAttribute ProductVo productVo,
			HttpServletRequest request,
			Model model) {
		
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		if(authUser == null) {
			return "redirect:admin/login";
		}
		
		JSONResult<ProductVo> vo = adminShopService.registProduct(productVo);
		model.addAttribute("vo", vo);
		
		if("fail".equals(vo.getResult())) {
			return "redirect:admin/shop/product/list";
		}
		
		return "redirect:/admin/shop/product/list";
	}
	
}
