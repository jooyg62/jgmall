package com.cafe24.jgmall.controller.api;

import static org.hamcrest.Matchers.is;
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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.jgmall.BootApp;
import com.cafe24.jgmall.vo.api.ReqAdminRegistProductVo;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BootApp.class})
@Transactional
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
	 */
	@Test
	@Rollback(true)
	public void testRegistProductSuccess() throws Exception {
		ReqAdminRegistProductVo request = new ReqAdminRegistProductVo();
		request.setProductNm("오리신발");
		request.setSellFl("Y");
		request.setDisplaySt("Y");
		request.setProductDpt("겨울철 따뜻한 실내용 신발, 오리신발과 함께하세요.");
		request.setSellPrc(27000);
		request.setSalePrc(23500);
		request.setOptionFl("N");
		
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
	
}
