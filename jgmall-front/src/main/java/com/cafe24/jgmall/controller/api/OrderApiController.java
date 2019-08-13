package com.cafe24.jgmall.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.jgmall.service.OrderService;
import com.cafe24.jgmall.vo.OrderVo;

/**
 *	주문, 결제 
 */
@RestController("orderAPIController")
@RequestMapping("/api/order")
public class OrderApiController {
	
	@Autowired
	OrderService orderService;
	
	/**
	 * 결제하기
	 */
	@PostMapping(value="/pay")
	public ResponseEntity<JSONResult> payOrderProduct(
			@RequestBody OrderVo orderVo) {
		
		System.out.println("front-orderVo: " + orderVo.toString());
		
		orderService.payOrder(orderVo);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null));
	}
	
}
