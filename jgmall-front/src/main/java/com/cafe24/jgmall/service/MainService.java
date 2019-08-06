package com.cafe24.jgmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.jgmall.dto.JSONResult;
import com.cafe24.jgmall.vo.ProductVo;

@Service
public class MainService {
	
	@Autowired
	RestTemplate restTemplate;

	/**
	 * 관리자 상품 목록
	 * @return
	 */
	public JSONResult<List<ProductVo>> getProductList() {
		String endpoint = "http://localhost:8888/jgmall-api/api/shop/product/list";
		JSONResult<List<ProductVo>> jsonResult = restTemplate.getForObject(endpoint, ProductListJSONResult.class);
		return jsonResult;
	}
	
	public static class ProductListJSONResult extends JSONResult<List<ProductVo>> {
	}
	
}
