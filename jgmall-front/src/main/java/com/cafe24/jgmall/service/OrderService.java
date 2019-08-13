package com.cafe24.jgmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.jgmall.dto.JSONResult;
import com.cafe24.jgmall.dto.jsonresult.ObjectJSONResult;
import com.cafe24.jgmall.vo.OrderVo;

@Service
public class OrderService {
	
	@Autowired
	RestTemplate restTemplate;
	
	/**
	 * 상품 구매하기
	 * @param orderVo
	 * @return
	 */
	public JSONResult<Object> payOrder(OrderVo orderVo) {
		String endpoint = "http://localhost:8888/jgmall-api/api/order/pay";
		JSONResult<Object> jsonResult = (JSONResult<Object>) restTemplate.postForObject(endpoint, orderVo, ObjectJSONResult.class);
		return jsonResult;
	}

}
