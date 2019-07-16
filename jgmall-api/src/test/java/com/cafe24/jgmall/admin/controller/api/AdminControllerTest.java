package com.cafe24.jgmall.admin.controller.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import com.cafe24.jgmall.admin.vo.api.ReqAdminLoginVo;
import com.google.gson.Gson;

@SuppressWarnings("unused")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BootApp.class})

public class AdminControllerTest {
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
	public void testLoginSuccess() throws Exception {
		// login request
		ReqAdminLoginVo vo = new ReqAdminLoginVo();
		vo.setUserId("jgseo");
		vo.setPassword("!@jgseo450");
		
		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/admin/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions
//		//.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		;
	}
	
	/**
	 * 아이디, 패스워드 불일치 
	 */
	@Test
	public void testLoginNotMatched() throws Exception {
		// login request
		ReqAdminLoginVo vo = new ReqAdminLoginVo();
		vo.setUserId("jgseo");
		vo.setPassword("!@jgseo4508");
		
		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/admin/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions
		//.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("fail")))
		.andExpect(jsonPath("$.message", is("아이디, 패스워드가 일치하지 않습니다.")))
		;
	}
	
	/**
	 *	id validation 		
	 *	사용자 아이디: 
	 *	1) 영문 시작
	 */
	@Test
	public void testLoginIdValid() throws Exception {
		// 영문 시작
		ReqAdminLoginVo vo = new ReqAdminLoginVo();
		vo.setUserId("1jgse");
		vo.setPassword("!@jgseo450");
		
		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/admin/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions
		//.andDo(print())
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.result", is("fail")))
		;
	}
	
	/**
	 *	id validation 		
	 *	사용자 아이디: 
	 *  2) 5자 이상 15자 이하로 등록.
	 */
	@Test
	public void testLoginIdValidRange() throws Exception {
		// 5자 이상 15자 이하로 등록.
		ReqAdminLoginVo vo = new ReqAdminLoginVo();
		vo.setUserId("jgse");
		vo.setPassword("!@jgseo450");
		
		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/admin/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions
		//.andDo(print())
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.result", is("fail")))
		;
	}
	
	/**
	 *	id validation 		
	 *	사용자 아이디: 
	 *  3) 영문과 숫자만 가능
	 */
	@Test
	public void testLoginIdValidChar() throws Exception {
		// 영문과 숫자만 가능
		ReqAdminLoginVo vo = new ReqAdminLoginVo();
		vo.setUserId("d안녕g세요");
		vo.setPassword("!@jgseo450");
		
		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/admin/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions
		//.andDo(print())
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.result", is("fail")))
		;
	}
	
	/**
	 *	id validation 		
	 *	사용자 아이디: 
	 *  빈값 체크
	 */
	@Test
	public void testLoginIdValidEmpty() throws Exception {
		// 영문과 숫자만 가능
		ReqAdminLoginVo vo = new ReqAdminLoginVo();
		vo.setUserId("");
		vo.setPassword("!@jgseo450");
		
		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/admin/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions
		//.andDo(print())
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.result", is("fail")))
		;
	}
	
	/**
	 *	password validation 		
	 *  패스워드: 
	 *  1) 숫자, 문자, 특수문자 각각 1개 이상 포함
	 */
	@Test
	public void testLoginPwValidChar() throws Exception {
		// 최소 8자리에 숫자, 문자, 특수문자 각각 1개 이상 포함
		ReqAdminLoginVo vo = new ReqAdminLoginVo();
		vo.setUserId("jgseo");
		vo.setPassword("!@jgseowef");
		
		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/admin/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions
		//.andDo(print())
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.result", is("fail")))
		;
	}
	
	/**
	 *	password validation 		
	 *  패스워드: 
	 *  2) 8자~16자.
	 */
	@Test
	public void testLoginPwValidRange() throws Exception {	
		// 8자~16자.
		ReqAdminLoginVo vo = new ReqAdminLoginVo();
		vo.setUserId("jgseo");
		vo.setPassword("!@jgseowef25402918409214");
		
		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/admin/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions
		//.andDo(print())
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.result", is("fail")))
		;
	}
	
	/**
	 *	password validation 		
	 *  패스워드: 
	 *  빈값 체크
	 */
	@Test
	public void testLoginPwValidEmpty() throws Exception {	
		// 8자~16자.
		ReqAdminLoginVo vo = new ReqAdminLoginVo();
		vo.setUserId("jgseo");
		vo.setPassword("");
		
		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/admin/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions
		.andDo(print())
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.result", is("fail")))
		;
	}
	
}