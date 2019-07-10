package com.cafe24.jgmall.controller.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.cafe24.jgmall.vo.UserVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=WebConfig.class)
@WebAppConfiguration
public class UserControllerTest {
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
	 * 로그인 성공
	 */
	@Test
	public void test_a_login_success() throws Exception {
		// login request
		UserVo vo = new UserVo();
		vo.setUserId("jgseo");
		vo.setPassword("1234");
		
		ResultActions resultActions = 
		mockMvc
		.perform(get("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		;
	}
	
	/**
	 * 아이디, 패스워드 불일치 
	 */
	@Test
	public void test_b_login_fail() throws Exception {
		// login request
		UserVo vo = new UserVo();
		vo.setUserId("jgseo");
		vo.setPassword("12345");
		
		ResultActions resultActions = 
		mockMvc
		.perform(get("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("fail")))
		.andExpect(jsonPath("$.message", is("아이디와 패스워드가 일치하지 않습니다.")))
		;
	}
	
	/**
	 *	id, password validation 		
	 *	사용자 아이디: 5자 이상 15자 이하로 등록.
	 *  패스워드: 영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 8자~16자.
	 */
	@Ignore
	@Test
	public void test_c_loginValid() throws Exception {
		// login request
		UserVo vo = new UserVo();
		vo.setUserId("jgse");
		vo.setPassword("1234");
		
		ResultActions resultActions = 
		mockMvc
		.perform(get("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("fail")))
		.andExpect(jsonPath("$.message", is("")))
		;
	}
	
	
}
