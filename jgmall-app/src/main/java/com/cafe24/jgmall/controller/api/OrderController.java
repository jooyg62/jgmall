package com.cafe24.jgmall.controller.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.jgmall.service.OrderService;
import com.cafe24.jgmall.vo.UserVo;

/**
 *	주문, 결제 
 */
@RestController("orderAPIController")
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	/**
	 * 주문 내역 확인
	 */
	@RequestMapping(value="/product/list", method=RequestMethod.GET)
	public JSONResult checkOrderProduct(
			@RequestBody UserVo userVo,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		return JSONResult.success(null);
	}
	
	/**
	 * 결제하기
	 */
	@RequestMapping(value="/pay", method=RequestMethod.POST)
	public JSONResult payOrderProduct(
			@RequestBody UserVo userVo,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		return JSONResult.success(null);
	}
	
	/**
	 * 선택한 상품 주문하기
	 * : 단일, 리스트
	 */
	
}
