package com.cafe24.jgmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.cafe24.jgmall.dto.JSONResult;
import com.cafe24.jgmall.dto.jsonresult.ObjectJSONResult;
import com.cafe24.jgmall.dto.jsonresult.ProductVoListJSONResult;
import com.cafe24.jgmall.vo.BasketProductVo;
import com.cafe24.jgmall.vo.ProductVo;

@Service
public class ShopService {
	
	@Autowired
	RestTemplate restTemplate;

	/**
	 * 장바구니 내역 조회
	 * @param userNo 회원 번호
	 * @return
	 */
	public JSONResult<List<ProductVo>> getBasketInfo(String userNo) {
		String endpoint = "http://localhost:8888/jgmall-api/api/shop/basket/user/" + userNo;
		JSONResult<List<ProductVo>> jsonResult = restTemplate.getForObject(endpoint, null, ProductVoListJSONResult.class);
		return jsonResult;
	}

	/**
	 * 장바구니 상품 담기
	 * @param basketProductVo
	 * @return
	 */
	public JSONResult<Object> registProductInBasket(BasketProductVo basketProductVo) {
		String endpoint = "http://localhost:8888/jgmall-api/api/shop/basket/product";
		JSONResult<Object> jsonResult = (JSONResult<Object>) restTemplate.postForObject(endpoint, basketProductVo, ObjectJSONResult.class);
		return jsonResult;
	}

	/**
	 * 장바구니 상품 삭제
	 * @param basketProductVo
	 */
	public void deleteProductInBasket(BasketProductVo basketProductVo) {
		String endpoint = "http://localhost:8888/jgmall-api/api/shop/basket/product";
		restTemplate.delete(endpoint, basketProductVo);
	}
	
}
