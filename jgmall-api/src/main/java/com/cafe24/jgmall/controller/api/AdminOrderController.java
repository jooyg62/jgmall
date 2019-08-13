package com.cafe24.jgmall.controller.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.jgmall.service.AdminOrderService;
import com.cafe24.jgmall.vo.OrderProductVo;
import com.cafe24.jgmall.vo.OrderVo;

import io.swagger.annotations.ApiOperation;

@RestController("adminOrderApiController")
@RequestMapping("/api/admin/order")
public class AdminOrderController {
	
	@Autowired
	AdminOrderService adminOrderService;
	
	@GetMapping(value="/list")
	public ResponseEntity<JSONResult> getOrderList() {
		
		List<OrderVo> productList = adminOrderService.getOrderList();
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(productList));
	}
	
	@ApiOperation(value="관리자주문상품리스트조회")
	@GetMapping(value="/{orderNo}/product/list")
	public ResponseEntity<JSONResult> getOrderProductList(
			@PathVariable Long orderNo) {
		
		List<OrderProductVo> orderProductList = adminOrderService.getOrderProductList(orderNo);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(orderProductList));
	}
}
