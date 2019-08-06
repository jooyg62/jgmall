package com.cafe24.jgmall.controller.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.jgmall.service.AdminShopService;
import com.cafe24.jgmall.utils.JgmallUtils;
import com.cafe24.jgmall.vo.ProductVo;

import io.swagger.annotations.ApiOperation;

@RestController("adminShopApiController")
@RequestMapping("/api/admin/shop")
public class AdminShopController {
	
	@Autowired
	private JgmallUtils jgmallUtils;
	
	@Autowired
	AdminShopService adminShopService;
	
	@ApiOperation(value="관리자상품등록")
	@PostMapping(value="/product")
	public ResponseEntity<JSONResult> registProduct(
			@RequestBody @Valid ProductVo productVo,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			StringBuilder sb = new StringBuilder();
			for(ObjectError error : allErrors) {
				String message = jgmallUtils.getMessage(error.getCodes()[0], error.getDefaultMessage());
				sb.append(message+"\n");
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(sb.toString()));
		}
		
		Boolean result = adminShopService.registProduct(productVo);
		
		if(result == false) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(JSONResult.fail(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null));
	}
	
	@ApiOperation(value="관리자상품리스트조회")
	@GetMapping(value="/product/list")
	public ResponseEntity<JSONResult> getProductList() {
		
		List<ProductVo> productList = adminShopService.getProductList();
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(productList));
	}
	
	@ApiOperation(value="관리자상품상세조회")
	@GetMapping(value="/product/{productNo}")
	public ResponseEntity<JSONResult> getProductDetail(
			@PathVariable Long productNo) {
		
		ProductVo productVo = adminShopService.getProductDetail(productNo);
		
		if(productVo == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("존재하지 않는 상품입니다."));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(productVo));
	}
	
	@ApiOperation(value="관리자상품삭제")
	@DeleteMapping(value="/product/{productNo}")
	public ResponseEntity<JSONResult> deleteProduct(
			@PathVariable Long productNo) {
		
		Boolean result = adminShopService.removeProduct(productNo);
		
		if(result != true) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("존재하지 않는 상품입니다."));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null));
	}
	
	@ApiOperation(value="관리자상품수정")
	@PutMapping(value="/product")
	public ResponseEntity<JSONResult> modifyProduct(
			@RequestBody @Valid ProductVo productVo,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			StringBuilder sb = new StringBuilder();
			for(ObjectError error : allErrors) {
				String message = jgmallUtils.getMessage(error.getCodes()[0], error.getDefaultMessage());
				sb.append(message+"\n");
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(sb.toString()));
		}
		
		Boolean result = adminShopService.modifyProduct(productVo);
		
		if(result != true) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("존재하지 않는 상품입니다."));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null));
	}
	
	@ApiOperation(value="관리자재고리스트")
	@GetMapping(value="/product/stock/list")
	public ResponseEntity<JSONResult> getProductStock() {
		
		List<ProductVo> productVo = adminShopService.getProductStockList();
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(productVo));
	}
	
	@ApiOperation(value="관리자재고내역수정")
	@PutMapping(value="/product/stock")
	public ResponseEntity<JSONResult> modifyProductStock(
			@RequestBody @Valid ProductVo productVo,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			StringBuilder sb = new StringBuilder();
			for(ObjectError error : allErrors) {
				String message = jgmallUtils.getMessage(error.getCodes()[0], error.getDefaultMessage());
				sb.append(message+"\n");
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(sb.toString()));
		}
		
		Boolean result = adminShopService.modifyProductStock(productVo);
		
		if(result != true) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("존재하지 않는 상품입니다."));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null));
	}
	
}
