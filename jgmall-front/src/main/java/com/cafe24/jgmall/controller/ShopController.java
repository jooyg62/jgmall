package com.cafe24.jgmall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.jgmall.dto.JSONResult;
import com.cafe24.jgmall.service.ShopService;
import com.cafe24.jgmall.vo.BasketProductVo;
import com.cafe24.jgmall.vo.ProductVo;
import com.cafe24.jgmall.vo.UserVo;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	ShopService shopService;
	
	/**
	 * 장바구니 페이지
	 * @return
	 */
	@GetMapping("/basket/user/{userNo}")
	public String getBasketInfo(
			@PathVariable String userNo,
			Model model) {
		JSONResult<List<ProductVo>> vo = shopService.getBasketInfo(userNo);
		model.addAttribute("vo", vo);
		
		if("fail".equals(vo.getResult())) {
			return "user/login";
		}
		
		return "shop/basketList";
	}
	
	/**
	 * 장바구니 담기
	 * @return
	 */
	@PostMapping("/basket/product/{productNo}")
	public String registProductInBasket(
			@PathVariable String productNo,
			@ModelAttribute BasketProductVo basketProductVo,
			Model model) {
		
		JSONResult<Object> vo = shopService.registProductInBasket(basketProductVo);
		model.addAttribute("vo", vo);
		
		if("fail".equals(vo.getResult())) {
			// 현재 보고 있는 페이지를 보도록 수정 필요
			return "user/login";
		}
		
		// 현재 보고 있는 페이지를 보도록 수정 필요
		return "redirect:/shop/product/" + productNo;
	}
	
	/**
	 * 장바구니 삭제
	 * @return
	 */
	@DeleteMapping("/basket/product/user/{userNo}")
	public String deleteProductInBasket(
			@PathVariable String userNo,
			@ModelAttribute BasketProductVo basketProductVo,
			Model model) {
		
		shopService.deleteProductInBasket(basketProductVo);
		
		return "/basket/user/" + userNo;
	}
	
	/**
	 * 상품 상세
	 * @return
	 */
	@GetMapping("/product/{productNo}")
	public String getProductInfo(
			@PathVariable String productNo,
			HttpServletRequest request,
			Model model) {
		
		HttpSession session = request.getSession();
		UserVo mallAuthUser = (UserVo) session.getAttribute("mallAuthUser");
		model.addAttribute("mallAuthUser", mallAuthUser);
		
		JSONResult<ProductVo> vo = shopService.getProductInfo(productNo);
		model.addAttribute("vo", vo);
		
		if("fail".equals(vo.getResult())) {
			return "redirect:/main";
		}
		
		return "admin/shop/item";
	}
	
}
