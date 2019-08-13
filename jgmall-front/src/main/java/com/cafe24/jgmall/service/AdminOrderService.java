package com.cafe24.jgmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.jgmall.dto.JSONResult;
import com.cafe24.jgmall.vo.OrderProductVo;
import com.cafe24.jgmall.vo.OrderVo;

@Service
public class AdminOrderService {
	
	@Autowired
	RestTemplate restTemplate;
	
	/**
	 * 주문 목록
	 * @return
	 */
	public JSONResult<List<OrderVo>> getOrderList() {
		String endpoint = "http://localhost:8888/jgmall-api/api/admin/order/list";
		JSONResult<List<OrderVo>> jsonResult = restTemplate.getForObject(endpoint, AdminOrderListJSONResult.class);
		return jsonResult;
	}
	
	public JSONResult<List<OrderProductVo>> getOrderProductList(String orderNo) {
		String endpoint = "http://localhost:8888/jgmall-api/api/admin/order/"+ orderNo +"/product/list";
		JSONResult<List<OrderProductVo>> jsonResult = restTemplate.getForObject(endpoint, AdminOrderProductListJSONResult.class);
		return jsonResult;
	}
	
	public static class AdminOrderListJSONResult extends JSONResult<List<OrderVo>> {
	}
	
	public static class AdminOrderProductListJSONResult extends JSONResult<List<OrderProductVo>> {
	}
}
