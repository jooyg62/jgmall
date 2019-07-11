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
		.perform(post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data.loginFl", is(Boolean.TRUE)))
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
		.perform(post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data.loginFl", is(Boolean.FALSE)))
		;
	}
	
	/**
	 *	id validation 		
	 *	사용자 아이디: 
	 *	1) 영문 시작
	 */
	@Test
	public void test_c_login_id_valid() throws Exception {
		// 영문 시작
		UserVo vo = new UserVo();
		vo.setUserId("1jgse");
		vo.setPassword("!@jgseo450");
		
		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data.loginFl", is(Boolean.FALSE)))
		;
	}
	
	/**
	 *	id validation 		
	 *	사용자 아이디: 
	 *  2) 5자 이상 15자 이하로 등록.
	 */
	@Test
	public void test_c_login_id_valid_range() throws Exception {
		// 5자 이상 15자 이하로 등록.
		UserVo vo = new UserVo();
		vo.setUserId("jgse");
		vo.setPassword("!@jgseo450");
		
		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data.loginFl", is(Boolean.FALSE)))
		;
	}
	
	/**
	 *	id validation 		
	 *	사용자 아이디: 
	 *  3) 영문과 숫자만 가능
	 */
	@Test
	public void test_c_login_id_valid_comb() throws Exception {
		// 영문과 숫자만 가능
		UserVo vo = new UserVo();
		vo.setUserId("d안녕g세요");
		vo.setPassword("!@jgseo450");
		
		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data.loginFl", is(Boolean.FALSE)))
		;
	}
	
	/**
	 *	password validation 		
	 *  패스워드: 
	 *  1) 숫자, 문자, 특수문자 각각 1개 이상 포함
	 */
	@Test
	public void test_d_login_pw_valid_comb() throws Exception {
		// 최소 8자리에 숫자, 문자, 특수문자 각각 1개 이상 포함
		UserVo vo = new UserVo();
		vo.setUserId("jgseo");
		vo.setPassword("!@jgseowef");
		
		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data.loginFl", is(Boolean.FALSE)))
		;
	}
	
	/**
	 *	password validation 		
	 *  패스워드: 
	 *  2) 8자~16자.
	 */
	@Test
	public void test_d_login_pw_valid_range() throws Exception {	
		// 8자~16자.
		UserVo vo = new UserVo();
		vo.setUserId("jgseo");
		vo.setPassword("!@jgseowef25402918409214");
		
		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data.loginFl", is(Boolean.FALSE)))
		;
	}
	
	/**
	 * id 중복 체크
	 */
	@Test
	public void test_e_exist_id_true() throws Exception {
		// id 중복 존재
		ResultActions resultActions = 
		mockMvc
		.perform(get("/api/user/exist/{id}", "jgseo").contentType(MediaType.APPLICATION_JSON));
		
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data.idExistFl", is(Boolean.TRUE)))
		;
	}
	
	/**
	 * id 중복 체크
	 */
	@Test
	public void test_e_exist_id_false() throws Exception {
		// id 중복 존재 x
		ResultActions resultActions = 
		mockMvc
		.perform(get("/api/user/exist/{id}", "jgseo333").contentType(MediaType.APPLICATION_JSON));
		
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data.idExistFl", is(Boolean.FALSE)))
		;
	}
	
	/**
	 * 회원가입: 성공
	 */
	@Test
	public void test_f_join() throws Exception {
		UserVo vo = new UserVo();
		vo.setUserId("jgseo3");
		vo.setPassword("!@jgseo450");
		vo.setUserNm("서장규");
		vo.setJoinDate("20190710");
		vo.setTelNum("01041156736");
		vo.setGender("M");
		vo.setAge(27);
		
		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/user/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data.joinFl", is(Boolean.TRUE)))
		;
	}
	
	/**
	 * 회원가입 검증
	 */
	
}
