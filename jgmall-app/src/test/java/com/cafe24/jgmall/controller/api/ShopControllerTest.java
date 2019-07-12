package com.cafe24.jgmall.controller.api;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.jgmall.config.WebConfig;
import com.cafe24.jgmall.vo.FileVo;
import com.cafe24.jgmall.vo.PageVo;
import com.cafe24.jgmall.vo.ProductVo;
import com.cafe24.jgmall.vo.api.ReqProductListVo;
import com.cafe24.jgmall.vo.api.ResProductInfo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=WebConfig.class)
@WebAppConfiguration
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
	 * : 키워드 검색 성공
	 */
	@Ignore	// 구현 예정
	@Test
	public void testProductList() throws Exception {
		ReqProductListVo request = new ReqProductListVo();
		request.setKwd("오리");
		
		ResultActions resultActions = 
		mockMvc
		.perform(get("/api/shop/product/list/{pageNo}", "1").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(request)));

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
		.perform(get("/api/shop/product/{no}", "1").contentType(MediaType.APPLICATION_JSON));
		
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
	 * 상품 장바구니 담기
	 * case 1. 성공
	 */
	@Ignore
	@Test
	public void testBasketSetProduct() throws Exception {
		ResultActions resultActions = 
		mockMvc
		.perform(get("/api/shop/basket/product/set/{no}", "1").contentType(MediaType.APPLICATION_JSON));
		
		ResProductInfo response = new ResProductInfo();
		
		resultActions
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(response)))
		;
	}
	
}
