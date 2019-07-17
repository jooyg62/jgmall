package com.cafe24.jgmall.controller.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.jgmall.service.ShopService;
import com.cafe24.jgmall.vo.PageVo;
import com.cafe24.jgmall.vo.ProductVo;
import com.cafe24.jgmall.vo.UserVo;
import com.cafe24.jgmall.vo.api.ResBasketProdcutListVo;
import com.cafe24.jgmall.vo.api.ResProductInfo;
import com.cafe24.jgmall.vo.api.ResProductListVo;

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
	@GetMapping(value="/product/list/{pageNo}")
	public ResponseEntity<JSONResult> productList(
			@PathVariable int pageNo,
			@RequestParam(value="kwd", required=true, defaultValue="") String kwd) {
		
		// 상품 리스트 가져오기
		List<ProductVo> productList = shopService.getProductList(pageNo, kwd);
		
		// 페이징 처리
		PageVo pageVo = shopService.getPagingData(pageNo);
		
		ResProductListVo response = new ResProductListVo();
		response.setPageVo(pageVo);
		response.setProductList(productList);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(response));
	}
	
	@ApiOperation(value="상품상세조회")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="no: 상품 번호", required=true, dataType="long", defaultValue="")
	})
	@GetMapping(value="/product/{no}")
	public ResponseEntity<JSONResult> productDetail(
			@PathVariable Long no) {
		
		// 상품 상세
		ResProductInfo productList = shopService.getProductInfo(no);
		
		if(productList == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("존재하지 않는 상품입니다."));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(productList));
	}
	
	@ApiOperation(value="장바구니담기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="no: 상품 번호", required=true, dataType="long", defaultValue="")
	})
	@PostMapping(value="/basket/product/set/{no}")
	public ResponseEntity<JSONResult> setBastket(@PathVariable Long no) {
		
		// 상품 등록
		Boolean result = shopService.addProductInBasket(no);
		if(result == false) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(JSONResult.fail(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null));
	}
	
	@ApiOperation(value="장바구니내역조회")
	@GetMapping(value="/basket/product/list")
	public ResponseEntity<JSONResult> getBastket(
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		if(authUser == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("세션 정보가 없음."));
		}
		
		ResBasketProdcutListVo response = shopService.getBasketProductList(authUser.getNo());
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(response));
	}
	
	@ApiOperation(value="장바구니상품삭제")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value="kwd: 검색 키워드", required=true, dataType="long", defaultValue=""),
	})
	@DeleteMapping(value="/basket/product/{no}")
	public ResponseEntity<JSONResult> deleteBastket(
			@PathVariable Long no,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		if(authUser == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("세션 정보가 없음."));
		}
		
		// 상품 삭제
		Boolean result = shopService.removeProductInBasket(no);
		if(result == false) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(JSONResult.fail(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null));
	}
	
}
