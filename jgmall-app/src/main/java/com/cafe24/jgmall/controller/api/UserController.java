package com.cafe24.jgmall.controller.api;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.jgmall.service.UserService;
import com.cafe24.jgmall.vo.UserVo;



@RestController("userAPIController")
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	/**
	 * 유저 로그인
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public JSONResult login(
			@RequestBody UserVo userVo,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		// Validation
		String idRegex = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,14}$";
		String pwRegex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,16}$";
		
		if(!Pattern.matches(idRegex, userVo.getUserId())) {
			return JSONResult.fail("아이디 형식이 맞지 않습니다.");
		}
		
		if(!Pattern.matches(pwRegex, userVo.getPassword())) {
			return JSONResult.fail("패스워드 형식이 맞지 않습니다.");
		}
		
		
		// 유저 정보
		UserVo authUser = userService.userLogin(userVo);
		
		if(authUser == null) {
			return JSONResult.fail("아이디와 패스워드가 일치하지 않습니다.");
		}
		
		// 세션 처리
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", authUser);
		
		return JSONResult.success(authUser);
	}
	
	/**
	 * 아이디 중복 체크
	 */
	@RequestMapping(value="/exist/{id}", method=RequestMethod.GET)
	public JSONResult existId(
			@PathVariable("id") String id) {
		
		Boolean result = userService.existId(id);
		
		if(result) {
			return JSONResult.success(null);
		}
		
		return JSONResult.fail("중복되는 아이디 없음.");
	}
	
	/**
	 * 회원가입 
	 */
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public JSONResult join(
			@RequestBody UserVo userVo,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		return JSONResult.success(null);
	}
	
}
