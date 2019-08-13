package com.cafe24.jgmall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.jgmall.dto.JSONResult;
import com.cafe24.jgmall.service.AdminOrderService;
import com.cafe24.jgmall.vo.OrderProductVo;
import com.cafe24.jgmall.vo.OrderVo;
import com.cafe24.jgmall.vo.UserVo;

@Controller
@RequestMapping("/admin/order")
public class AdminOrderController {
	
	@Autowired
	AdminOrderService adminOrderService;
	
	/**
	 * 주문 내역 조회
	 * @return
	 */
	@GetMapping("/list")
	public String getOrderList(
			HttpServletRequest request,
			Model model) {
		
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		if(authUser == null) {
			return "redirect:/admin/login";
		}
		
		JSONResult<List<OrderVo>> vo = adminOrderService.getOrderList();
		model.addAttribute("vo", vo);
		
		if("fail".equals(vo.getResult())) {
			return "redirect:/admin/login";
		}
		
		return "admin/order/list";
	}
	
	/**
	 * 주문 내역 상세조회
	 * @return
	 */
	@GetMapping("/{orderNo}/product/list")
	public String getOrderProductList(
			@PathVariable String orderNo,
			HttpServletRequest request,
			Model model) {
		
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		if(authUser == null) {
			return "redirect:/admin/login";
		}
		
		JSONResult<List<OrderProductVo>> vo = adminOrderService.getOrderProductList(orderNo);
		model.addAttribute("vo", vo);
		
		if("fail".equals(vo.getResult())) {
			return "redirect:/admin/login";
		}
		
		return "admin/order/items";
	}
	
}
