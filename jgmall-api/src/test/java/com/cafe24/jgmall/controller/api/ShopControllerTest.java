package com.cafe24.jgmall.controller.api;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cafe24.jgmall.config.WebConfig;
import com.cafe24.jgmall.vo.UserVo;
import com.cafe24.jgmall.vo.api.ReqProductListVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=WebConfig.class)
@WebAppConfiguration
public class ShopControllerTest {
	private MockMvc mockMvc;
	private UserVo authUser;
	private MockHttpSession session;
	private MockHttpServletRequest request;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.
			webAppContextSetup(webApplicationContext).
			build();
		
		authUser = new UserVo();
		authUser.setNo(1L);
		authUser.setUserId("jgseo");
		authUser.setPassword("1234");
		authUser.setUserNm("서장규");
		authUser.setJoinDate("20190710");
		authUser.setTelNum("01041156736");
		authUser.setGender("M");
		authUser.setAge(27);
		
		session = new MockHttpSession();
		session.setAttribute("authUser", authUser);
		
		request = new MockHttpServletRequest();
		request.setSession(session);
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	}
	
	@After
	public void clear() {
		session.clearAttributes();
		session = null;
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
		.perform(get("/api/shop/basket/product/list").session(session).contentType(MediaType.APPLICATION_JSON));
		
		resultActions
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data.productNm", is("오리인형")))
		.andExpect(jsonPath("$.data.sellPrc", is(10300)))
		.andExpect(jsonPath("$.data.salePrc", is(0)))
		.andExpect(jsonPath("$.data.optionFl", is("N")))
		.andExpect(jsonPath("$.data.optionNm", is("")))
		.andExpect(jsonPath("$.data.addPrc", is(0)))
		.andExpect(jsonPath("$.data.stockAmt", is(3)))
		.andExpect(jsonPath("$.data.imgType", is("T")))
		.andExpect(jsonPath("$.data.saveUrl", is("/images/oridoll.jpg")))
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
		.perform(delete("/api/shop/basket/product/{no}", 1).session(session).contentType(MediaType.APPLICATION_JSON));
		
		resultActions
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		;
	}
	
}
