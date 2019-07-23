package com.cafe24.jgmall.controller.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.jgmall.BootApp;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BootApp.class})
public class AdminOrderControllerTest {
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
	 * 관리자 주문내역조회
	 * Case 1) 성공
	 */
	@Test
	public void testGetOrderListSuccess() throws Exception {
		ResultActions resultActions = 
		mockMvc
		.perform(get("/api/admin/order/list").contentType(MediaType.APPLICATION_JSON));

		resultActions
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		;
	}
	
	/**
	 * 관리자 주문내역 상세 조회
	 * Case 1) 성공
	 */
	@Test
	public void testGetOrderProductListSuccess() throws Exception {
		ResultActions resultActions = 
		mockMvc
		.perform(get("/api/admin/order/{orderNo}/product/list", 1).contentType(MediaType.APPLICATION_JSON));

		resultActions
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		;
	}
	
}
