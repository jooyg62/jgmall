package com.cafe24.jgmall.controller.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ShopControllerTest {
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
	 * 상품 목록 조회
	 * 200, success
	 * 성공
	 */
	@Test
	public void testProductList() throws Exception {
		ResultActions resultActions = 
		mockMvc
		.perform(get("/api/shop/product/list").contentType(MediaType.APPLICATION_JSON));

		resultActions
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		;
	}
	
	/**
	 * 상품 상세 조회
	 * case 1. 성공
	 */
	@Test
	public void testProductInfo() throws Exception {
		ResultActions resultActions = 
		mockMvc
		.perform(get("/api/shop/product/{no}", "2").contentType(MediaType.APPLICATION_JSON));
		
		resultActions
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data.productNm", is("오리인형")))
		;
	}
	
	/**
	 * 상품 상세 조회
	 * case 2. 없는 제품 조회
	 */
	@Test
	public void testNotExistProductInfo() throws Exception {
		ResultActions resultActions = 
		mockMvc
		.perform(get("/api/shop/product/{no}", "9999999").contentType(MediaType.APPLICATION_JSON));
		
		resultActions
		.andDo(print())
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.result", is("fail")))
		.andExpect(jsonPath("$.message", is("존재하지 않는 상품입니다.")))
		;
	}
	
	/**
	 * 상품 상세 조회
	 * case 3. 잘못된 no 요청.
	 * : 404 NOT FOUND
	 */
	@Test
	public void testBadReqeustPathProductInfo() throws Exception {
		ResultActions resultActions = 
		mockMvc
		.perform(get("/api/shop/product/{no}", "99안9녕9").contentType(MediaType.APPLICATION_JSON));
		
		resultActions
		.andDo(print())
		.andExpect(status().isNotFound())
		;
	}
	
	/**
	 * 상품 장바구니 담기
	 * case 1. 성공
	 */
	@Test
	public void testBasketSetProduct() throws Exception {
		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/shop/basket/product/set/{no}", "1").contentType(MediaType.APPLICATION_JSON));
		
		resultActions
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		;
	}
	
	/**
	 * 상품 장바구니 담기
	 * case 2. 잘못된 no 요청.
	 * : 404 NOT FOUND
	 */
	@Test
	public void testBadReqeustBasketSetProduct() throws Exception {
		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/shop/basket/product/set/{no}", "1안녕abc3").contentType(MediaType.APPLICATION_JSON));
		
		resultActions
		.andDo(print())
		.andExpect(status().isNotFound())
		;
	}
	
	/**
	 * 장바구니 내역 조회(회원)
	 * case 1. 성공
	 */
	@Test
	public void testGetBasketProductList() throws Exception {
		ResultActions resultActions = 
		mockMvc
		.perform(get("/api/shop/basket/user/{userNo}", 1).contentType(MediaType.APPLICATION_JSON));
		
		resultActions
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
//		.andExpect(jsonPath("$.data.productNm", is("오리인형")))
//		.andExpect(jsonPath("$.data.sellPrc", is(10300)))
//		.andExpect(jsonPath("$.data.salePrc", is(0)))
//		.andExpect(jsonPath("$.data.optionFl", is("N")))
//		.andExpect(jsonPath("$.data.optionNm", is("")))
//		.andExpect(jsonPath("$.data.addPrc", is(0)))
//		.andExpect(jsonPath("$.data.stockAmt", is(3)))
//		.andExpect(jsonPath("$.data.imgType", is("T")))
//		.andExpect(jsonPath("$.data.saveUrl", is("/images/oridoll.jpg")))
		;
	}
	
	/**
	 * 장바구니 내역 조회(회원)
	 * case 2. 세션정보 없을 경우.
	 */
	@Test
	public void testGetBasketProductListNoneSession() throws Exception {
		ResultActions resultActions = 
		mockMvc
		.perform(get("/api/shop/basket/product/list").contentType(MediaType.APPLICATION_JSON));
		
		resultActions
		.andDo(print())
		.andExpect(status().isBadRequest())
		;
	}
	
	/**
	 * 장바구니 상품 삭제
	 * case 1. 성공
	 */
	@Test
	public void testDeleteBasketProduct() throws Exception {
		ResultActions resultActions = 
		mockMvc
		.perform(delete("/api/shop/basket/product/{no}", 1).contentType(MediaType.APPLICATION_JSON));
		
		resultActions
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		;
	}
	
}
