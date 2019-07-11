package com.cafe24.jgmall.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.jgmall.service.ShopService;
import com.cafe24.jgmall.vo.PageVo;
import com.cafe24.jgmall.vo.ProductVo;
import com.cafe24.jgmall.vo.UserVo;

/**
 *	상품, 장바구니 
 */
@RestController("shopAPIController")
@RequestMapping("/api/shop")
public class ShopController {
	
	@Autowired
	ShopService shopService;
	
	/**
	 * 상품 목록 조회
	 */
	@GetMapping(value="/api/shop/product/list/{pageNo}")
	public ResponseEntity<JSONResult> productList(
			@PathVariable int pageNo,
			@RequestParam String kwd) {
		
		// 상품 리스트 가져오기
		List<ProductVo> productVo = shopService.getProductList(pageNo, kwd);
		
		// 페이징 처리
		PageVo pageVo = shopService.getPagingData(pageNo);
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null));
	}
	
	/**
	 * 상품 상세 조회
	 */
	@GetMapping(value="/product/{no}")
	public JSONResult productDetail(
			@RequestBody UserVo userVo,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		return JSONResult.success(null);
	}
	
	/**
	 * 장바구니 담기
	 */
	@PostMapping(value="/basket/set/product/{no}")
	public JSONResult setBastket(
			@RequestBody UserVo userVo,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		return JSONResult.success(null);
	}
	
	/**
	 * 장바구니 내역 조회
	 */
	@GetMapping(value="/basket/product/list")
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
	@DeleteMapping(value="/basket/delete/product")
	public JSONResult deleteBastket(
			@RequestBody UserVo userVo,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		return JSONResult.success(null);
	}
	
}
