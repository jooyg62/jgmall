package com.cafe24.jgmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.jgmall.dto.JSONResult;
import com.cafe24.jgmall.vo.ProductVo;

@Service
public class AdminShopService {
	
	@Autowired
	RestTemplate restTemplate;

	/**
	 * 관리자 상품 목록
	 * @return
	 */
	public JSONResult<List<ProductVo>> getProductList() {
		String endpoint = "http://localhost:8888/jgmall-api/api/admin/shop/product/list";
		JSONResult<List<ProductVo>> jsonResult = restTemplate.getForObject(endpoint, AdminProductListJSONResult.class);
		return jsonResult;
	}
	
	/**
	 * 관리자 상품 등록
	 * @param productVo
	 * @return
	 */
	public JSONResult<ProductVo> registProduct(ProductVo productVo) {
		String endpoint = "http://localhost:8888/jgmall-api/api/admin/shop/product";
		JSONResult<ProductVo> jsonResult = restTemplate.postForObject(endpoint, productVo, AdminProductJSONResult.class);
		return jsonResult;
	}
	
	public static class AdminProductListJSONResult extends JSONResult<List<ProductVo>> {
	}
	
	public static class AdminProductJSONResult extends JSONResult<ProductVo> {
	}
}
