package com.cafe24.jgmall.controller.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.cafe24.jgmall.vo.FileVo;
import com.cafe24.jgmall.vo.ProductVo;
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
	 * : 키워드 검색
	 */
	@Test
	public void test_a_product_list() throws Exception {
		// request
		Map<String, Object> reqMap = new HashMap<String, Object>();
		reqMap.put("kwd", "오리");
		
		ResultActions resultActions = 
		mockMvc
		.perform(post("/api/shop/product/list/{pageNo}", "1").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(reqMap)));
		
		List<ProductVo> productList = new ArrayList<ProductVo>();
		
		ProductVo productVo1 = new ProductVo();
		productVo1.setProductNm("오리발");
		productVo1.setSellFl("Y");
		productVo1.setDisplaySt("Y");
		productVo1.setRegDate("20180702");
		productVo1.setSellPrc(5300);
		productVo1.setSalePrc(3500);
		
		FileVo fileVo1 = new FileVo();
		fileVo1.setSaveUrl("/images/orifoot.jpg");
		
		List<FileVo> fileList = productVo1.getFileList();
		fileList.add(fileVo1);
		
		
		ProductVo productVo2 = new ProductVo();
		productVo1.setProductNm("오리인형");
		productVo1.setSellFl("N");
		productVo1.setDisplaySt("Y");
		productVo1.setRegDate("20190411");
		productVo1.setSellPrc(10300);
		productVo1.setSalePrc(0);
		
		FileVo fileVo2 = new FileVo();
		fileVo1.setSaveUrl("/images/orifoot.jpg");
		
		List<FileVo> fileList2 = productVo1.getFileList();
		fileList2.add(fileVo2);
		
		productList.add(productVo1);
		productList.add(productVo2);
		
		resultActions
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(productList)))
		;
	}
	
}
