package com.cafe24.jgmall.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.jgmall.service.OrderService;
import com.cafe24.jgmall.vo.OrderVo;
import com.cafe24.jgmall.vo.ProductVo;
import com.cafe24.jgmall.vo.UserVo;

/**
 *	주문, 결제 
 */
@RestController("orderAPIController")
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	/**
	 * 주문 내역 조회
	 */
	@GetMapping(value="/list")
	public ResponseEntity<JSONResult> getOrderInfo(
			@RequestBody UserVo userVo) {
		
		List<OrderVo> orderVo = orderService.getOrderInfo(userVo.getNo());
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(orderVo));
	}
	
	/**
	 * 결제하기
	 */
	@PostMapping(value="/pay")
	public ResponseEntity<JSONResult> payOrderProduct(
			@RequestBody OrderVo orderVo) {
		
		// 상품 리스트 가져오기
		Boolean result = orderService.payOrder(orderVo);
		if(result == false) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(JSONResult.fail(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null));
	}
	
}
