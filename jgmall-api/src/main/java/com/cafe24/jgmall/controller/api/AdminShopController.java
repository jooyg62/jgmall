package com.cafe24.jgmall.controller.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.jgmall.service.AdminShopService;
import com.cafe24.jgmall.service.AdminUserService;
import com.cafe24.jgmall.utils.JgmallUtils;
import com.cafe24.jgmall.vo.ProductVo;
import com.cafe24.jgmall.vo.api.ReqAdminRegistProductVo;
import com.cafe24.jgmall.vo.api.ResAdminUserBoardVo;

import io.swagger.annotations.ApiOperation;

@RestController("ShopController")
@RequestMapping("/api/admin/shop")
public class AdminShopController {
	
	@Autowired
	private JgmallUtils jgmallUtils;
	
	@Autowired
	AdminShopService adminShopService;
	
	@ApiOperation(value="관리자상품등록")
	@PostMapping(value="/product")
	public ResponseEntity<JSONResult> registProduct(
			@RequestBody @Valid ReqAdminRegistProductVo reqAdminRegistProductVo,
			BindingResult bindingResult,
			HttpServletRequest request) {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			StringBuilder sb = new StringBuilder();
			for(ObjectError error : allErrors) {
				String message = jgmallUtils.getMessage(error.getCodes()[0], error.getDefaultMessage());
				sb.append(message+"\n");
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(sb.toString()));
		}
		
		Boolean result = adminShopService.registProduct(reqAdminRegistProductVo);
		
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
	
}
