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
		vo.setPassword("!@jgseo450");
		
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
		vo.setPassword("!@jgseo4508");
		
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
	 *	id validation 		
	 *	사용자 아이디: 
	 *	1) 영문 시작
	 *  2) 5자 이상 15자 이하로 등록.
	 *  3) 영문과 숫자만 가능
	 */
	@Test
	public void test_c_login_id_valid() throws Exception {
		// 1) 영문 시작
		UserVo vo = new UserVo();
		vo.setUserId("1jgse");
		vo.setPassword("!@jgseo450");
		
		ResultActions resultActions = 
		mockMvc
		.perform(get("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("fail")))
		.andExpect(jsonPath("$.message", is("아이디 형식이 맞지 않습니다.")))
		;
		
		// 2) 5자 이상 15자 이하로 등록.
		UserVo vo2 = new UserVo();
		vo2.setUserId("jgse");
		vo2.setPassword("!@jgseo450");
		
		ResultActions resultActions2 = 
		mockMvc
		.perform(get("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo2)));
		
		resultActions2
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("fail")))
		.andExpect(jsonPath("$.message", is("아이디 형식이 맞지 않습니다.")))
		;
		
		// 3) 영문과 숫자만 가능
		UserVo vo3 = new UserVo();
		vo3.setUserId("d안녕g세요");
		vo3.setPassword("!@jgseo450");
		
		ResultActions resultActions3 = 
		mockMvc
		.perform(get("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo3)));
		
		resultActions3
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("fail")))
		.andExpect(jsonPath("$.message", is("아이디 형식이 맞지 않습니다.")))
		;
	}
	
	/**
	 *	password validation 		
	 *  패스워드: 최소 8자리에 숫자, 문자, 특수문자 각각 1개 이상 포함, 8자~16자.
	 */
	@Test
	public void test_d_login_pw_valid() throws Exception {
		// login request
		UserVo vo = new UserVo();
		vo.setUserId("jgseo");
		vo.setPassword("!@jgseowef");
		
		ResultActions resultActions = 
		mockMvc
		.perform(get("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("fail")))
		.andExpect(jsonPath("$.message", is("패스워드 형식이 맞지 않습니다.")))
		;
	}
	
}
