package com.cafe24.jgmall.controller.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.jgmall.service.UserService;
import com.cafe24.jgmall.vo.UserVo;

/**
 *	상품, 장바구니 
 */
@RestController("shopAPIController")
@RequestMapping("/api/shop")
public class ShopController {
	
	@Autowired
	UserService userService;
	
	/**
	 * 상품 목록 조회
	 */
	@RequestMapping(value="/product/list/kwd/{kwd}/pageNo/{pageNo}", method=RequestMethod.GET)
	public JSONResult productList(
			@RequestBody UserVo userVo,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		return JSONResult.success(null);
	}
	
	/**
	 * 상품 상세 조회
	 */
	@RequestMapping(value="/product/{no}", method=RequestMethod.GET)
	public JSONResult productDetail(
			@RequestBody UserVo userVo,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		return JSONResult.success(null);
	}
	
	/**
	 * 장바구니 담기
	 */
	@RequestMapping(value="/basket/set/product/{no}", method=RequestMethod.POST)
	public JSONResult setBastket(
			@RequestBody UserVo userVo,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		return JSONResult.success(null);
	}
	
	/**
	 * 장바구니 내역 조회
	 */
	@RequestMapping(value="/basket/product/list", method=RequestMethod.GET)
	public JSONResult getBastket(
			@RequestBody UserVo userVo,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		return JSONResult.success(null);
	}
	
	/**
	 * 장바구니 상품 삭제
	 * : 단일, 여러개
	 */
	@RequestMapping(value="/basket/delete/product", method=RequestMethod.DELETE)
	public JSONResult deleteBastket(
			@RequestBody UserVo userVo,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		return JSONResult.success(null);
	}
	
}
