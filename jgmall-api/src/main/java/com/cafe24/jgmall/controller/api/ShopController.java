package com.cafe24.jgmall.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.jgmall.service.ShopService;
import com.cafe24.jgmall.vo.BasketProductVo;
import com.cafe24.jgmall.vo.ProductVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 *	상품, 장바구니 
 */
@RestController("shopAPIController")
@RequestMapping("/api/shop")
public class ShopController {
	
	@Autowired
	ShopService shopService;
	
	@ApiOperation(value="상품목록조회")
	@ApiImplicitParams({
		@ApiImplicitParam(name="kwd", value="kwd: 검색 키워드", required=true, dataType="int", defaultValue=""),
		@ApiImplicitParam(name="pageNo", value="pageNo: 페이지 번호", required=true, dataType="string", defaultValue="")
	})
	@GetMapping(value="/product/list")
	public ResponseEntity<JSONResult> productList() {
		
		// 상품 리스트 가져오기
		List<ProductVo> productList = shopService.getProductList();
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(productList));
	}
	
	@ApiOperation(value="상품상세조회")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="no: 상품 번호", required=true, dataType="long", defaultValue="")
	})
	@GetMapping(value="/product/{no}")
	public ResponseEntity<JSONResult> productDetail(
			@PathVariable Long no) {
		
		// 상품 상세
		ProductVo productVo = shopService.getProductInfo(no);
		
		if(productVo == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("존재하지 않는 상품입니다."));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(productVo));
	}
	
	@ApiOperation(value="회원장바구니내역조회")
	@GetMapping(value="/basket/user/{userNo}")
	public ResponseEntity<JSONResult> getBasket(
			@PathVariable Long userNo) {
		
		List<ProductVo> productVo = shopService.getBasketProductList(userNo);
		
		System.out.println("회원장바구니내역조회 productVo: " + productVo.toString());
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(productVo));
	}
	
	@ApiOperation(value="회원장바구니담기")
	@PostMapping(value="/basket/product")
	public ResponseEntity<JSONResult> registProductInBasket(
			@RequestBody BasketProductVo basketProductVo) {
		
		Boolean result = shopService.registBasketProduct(basketProductVo);
		if(result == false) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(JSONResult.fail(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null));
	}
	
	@ApiOperation(value="장바구니상품삭제")
	@DeleteMapping(value="/basket/product")
	public ResponseEntity<JSONResult> deleteBastket(
			@RequestBody BasketProductVo basketProductVo) {
		
		// 상품 삭제
		Boolean result = shopService.removeBasketProduct(basketProductVo.getBasketNo());
		if(result == false) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(JSONResult.fail(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null));
	}
	
}
