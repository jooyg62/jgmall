package com.cafe24.jgmall.exception;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cafe24.jgmall.controller.api.JSONResult;
import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Log LOGGER = LogFactory.getLog(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public void handleException(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
		
		//1. 로깅
		e.printStackTrace();
		StringWriter errors = new StringWriter(); // 버퍼를 두어 개행 등을 처리
		e.printStackTrace(new PrintWriter(errors)); // 내용을 담음.
		LOGGER.error(errors.toString());
		
		String accept = request.getHeader("accept");
		
		// JSON(api)으로 요청했는지 HTTP으로 요청했는지에 따라 나눠서 구분한다.
		if(accept.matches(".*application.json.*")) {
			// JSON 응답
			response.setStatus(HttpServletResponse.SC_OK);
			
			JSONResult jsonResult = JSONResult.fail(errors.toString());
			String result = new ObjectMapper().writeValueAsString(jsonResult);
			
			System.out.println(result);
			OutputStream os = response.getOutputStream();
			os.write(result.getBytes("UTF-8"));
			os.close();
		} else {
			//2. 안내페이지 가기 + 정상종료(response)
			request.setAttribute("uri", request.getRequestURI());
			request.setAttribute("exception", errors.toString());
			request.getRequestDispatcher("/WEB-INF/views/error/exception.jsp").forward(request, response);
		}
		
	}
	
	
}
