package com.cafe24.jgmall.controller.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.jgmall.BootApp;
import com.cafe24.jgmall.vo.OptionVo;
import com.cafe24.jgmall.vo.ProductVo;
import com.cafe24.jgmall.vo.api.ReqAdminRegistProductVo;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional
public class AdminShopControllerTest {
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.
			webAppContextSetup(webApplicationContext).
			build();
	}
	
	/**
	 * 관리자 상품 등록
	 * Case 1) 성공
	 */
	@Test
//	@Rollback(true)
	public void testRegistProductSuccess() throws Exception {
		ProductVo request = new ProductVo();
		request.setProductNm("오리신발");
		request.setSellFl("Y");
		request.setDisplaySt("Y");
		request.setProductDpt("겨울철 따뜻한 실내용 신발, 오리신발과 함께하세요.");
		request.setSellPrc(27000);
		request.setSalePrc(23500);
		request.setOptionFl("Y");
		
		List<OptionVo> optionVoList = request.getOptionVoList();
		optionVoList.add(new OptionVo());
		optionVoList.add(new OptionVo());
		
		optionVoList.get(0).setOptionNm("색상");
		optionVoList.get(1).setOptionNm("사이즈");
		
		List<String> optionValueList1 = optionVoList.get(0).getOptionValueList();
		optionValueList1.add("Black");
		optionValueList1.add("Red");
		
		List<String> optionValueList2 = optionVoList.get(1).getOptionValueList();
		optionValueList2.add("230");
		optionValueList2.add("240");
		optionValueList2.add("250");
		optionValueList2.add("260");
		optionValueList2.add("270");
		
		System.out.println("body=" + new Gson().toJson(request));
		
		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/admin/shop/product").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(request)));

		resultActions
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		;
	}
	
	/**
	 * 관리자 상품 리스트 조회
	 * Case 1) 성공
	 */
	@Test
	public void testGetProductListSuccess() throws Exception {
		ResultActions resultActions = 
		mockMvc
		.perform(get("/api/admin/shop/product/list").contentType(MediaType.APPLICATION_JSON));

		resultActions
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		;
	}
	
	/**
	 * 관리자 상품 리스트 조회
	 * Case 1) 성공
	 */
	@Test
	public void testGetProductDetailSuccess() throws Exception {
		ResultActions resultActions = 
		mockMvc
		.perform(get("/api/admin/shop/product/{productNo}", 1).contentType(MediaType.APPLICATION_JSON));

		resultActions
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data.productNm", is("오리신발")))
		;
	}
	
	/**
	 * 관리자 상품 리스트 조회
	 * Case 2) 실패 : 존재하지 않는 상품번호 조회
	 * Status 400, result fail 
	 */
	@Test
	public void testGetProductDetailFailNotExistProduct() throws Exception {
		ResultActions resultActions = 
		mockMvc
		.perform(get("/api/admin/shop/product/{productNo}", 900099).contentType(MediaType.APPLICATION_JSON));

		resultActions
		.andDo(print())
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.result", is("fail")))
		;
	}
	
	/**
	 * 관리자 상품삭제
	 * Case 1) 성공
	 */
	@Test
	@Rollback(true)
	public void testDeleteProductSuccess() throws Exception {
		ResultActions resultActions = 
		mockMvc
		.perform(delete("/api/admin/shop/product/{productNo}", 1).contentType(MediaType.APPLICATION_JSON));

		resultActions
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		;
	}
	
	/**
	 * 관리자 상품삭제
	 * Case 2) 실패 : 존재하지 않는 상품번호 조회
	 * Status 400, result fail 
	 */
	@Test
	public void testDeleteProductDetailFailNotExistProduct() throws Exception {
		ResultActions resultActions = 
		mockMvc
		.perform(delete("/api/admin/shop/product").contentType(MediaType.APPLICATION_JSON));

		resultActions
		.andDo(print())
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.result", is("fail")))
		;
	}
	
	/**
	 * 관리자 상품수정
	 * Case 1) 성공
	 */
	@Test
	@Rollback(true)
	public void testModifyProductSuccess() throws Exception {
		ProductVo request = new ProductVo();
		request.setProductNo(1L);
		request.setProductNm("오리신발-업그레이드 버전");
		request.setSellFl("N");
		request.setDisplaySt("N");
		request.setProductDpt("업그레이드 된 버전으로, 오리신발과 함께하세요.");
		request.setSellPrc(47000);
		request.setSalePrc(27700);
		request.setOptionFl("N");
		
		System.out.println("body=" + new Gson().toJson(request));
		
		ResultActions resultActions = 
		mockMvc
		.perform(put("/api/admin/shop/product").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(request)));

		resultActions
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		;
	}
	
	/**
	 * 관리자 상품수정
	 * Case 2) 실패 : 존재하지 않는 상품번호
	 * Status 400, result fail 
	 */
	@Test
	public void testModifyProductFailNotExistProduct() throws Exception {
		ProductVo request = new ProductVo();
		request.setProductNo(900099L);
		request.setProductNm("오리신발-업그레이드 버전");
		request.setSellFl("N");
		request.setDisplaySt("N");
		request.setProductDpt("업그레이드 된 버전으로, 오리신발과 함께하세요.");
		request.setSellPrc(47000);
		request.setSalePrc(27700);
		request.setOptionFl("N");
		
		ResultActions resultActions = 
		mockMvc
		.perform(put("/api/admin/shop/product").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(request)));

		resultActions
		.andDo(print())
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.result", is("fail")))
		;
	}
	
	/**
	 * 관리자 재고 리스트 조회
	 * Case 1) 성공
	 * Status 200, result success 
	 */
	@Test
	public void testGetProductStockListSuccess() throws Exception {
		ResultActions resultActions = 
		mockMvc
		.perform(get("/api/admin/shop/product/stock/list").contentType(MediaType.APPLICATION_JSON));

		resultActions
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		;
	}
	
	/**
	 * 관리자재고내역수정
	 * Case 1) 성공
	 * Status 200, result success
	 */
	@Ignore	// 현재 데이터 없음
	@Test
	@Rollback(true)
	public void testModifyProductStockSuccess() throws Exception {
		ProductVo request = new ProductVo();
		request.setProductNo(1L);
		request.setSellFl("Y");
		request.setDisplaySt("Y");
		request.setStockAmt(30);
		request.setStockFl("N");
		
		System.out.println("body=" + new Gson().toJson(request));
		
		ResultActions resultActions = 
		mockMvc
		.perform(put("/api/admin/shop/product/stock").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(request)));
		
		resultActions
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		;
	}
}
