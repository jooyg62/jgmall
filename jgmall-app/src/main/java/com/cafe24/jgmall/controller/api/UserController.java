package com.cafe24.jgmall.controller.api;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.jgmall.service.UserService;
import com.cafe24.jgmall.vo.UserVo;
import com.cafe24.jgmall.vo.api.ResJoinVo;
import com.fasterxml.jackson.core.JsonProcessingException;



@RestController("userAPIController")
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	/**
	 * 유저 로그인
	 * @throws JsonProcessingException 
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<JSONResult> login(
			@RequestBody @Valid UserVo userVo,
			BindingResult bindResult,
			HttpServletRequest request) throws JsonProcessingException {
		
		if(bindResult.hasErrors()) {
			List<ObjectError> allErrors = bindResult.getAllErrors();
			for(ObjectError error : allErrors) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
			}
		}
		
		// 유저 정보
		UserVo authUser = userService.userLogin(userVo);
		
		if(authUser == null) {
			return ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail("아이디, 패스워드가 일치하지 않습니다."));
		}
		
		// 세션 처리
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", authUser);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null));
	}
	
	/**
	 * 아이디 중복 체크
	 */
	@RequestMapping(value="/exist/{id}", method=RequestMethod.GET)
	public JSONResult existId(@PathVariable("id") String id) {
		Boolean result = userService.existId(id);
		
		if(result) {
			return JSONResult.success(null);
		}
		
		return JSONResult.fail("중복된 아이디가 없습니다.");
	}
	
	/**
	 * 회원가입
	 * 이름: 한글, 영문 2~20자까지
	 * 가입일: 숫자 8자
	 * 휴대번호: 숫자 10~11자리
	 * 성별: M,F
	 * 나이: 숫자 한자리 또는 두자리
	 */
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public JSONResult join(
			@RequestBody UserVo userVo,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		ResJoinVo resJoinVo = new ResJoinVo();
		resJoinVo.setJoinFl(Boolean.FALSE);
		resJoinVo.setIdExistFl(Boolean.FALSE);
		
		// Validation
		String idRegex = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,14}$";
		String pwRegex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,16}$";
		String nmRegex = "^[가-힣|a-zA-Z]{2,20}$";
		String telRegex = "^01(?:0|1|[6-9])(\\d{3}|\\d{4})(\\d{4})$";
		String genRegex = "^[M|F]{1}$";
		String ageRegex = "^[0-9]{1,2}$";
		
		if(!Pattern.matches(idRegex, userVo.getUserId())) {
			return JSONResult.success(resJoinVo);
		}
		
		if(!Pattern.matches(pwRegex, userVo.getPassword())) {
			return JSONResult.success(resJoinVo);
		}
		
		if(!Pattern.matches(nmRegex, userVo.getUserNm())) {
			return JSONResult.success(resJoinVo);
		}
		
		if(!Pattern.matches(telRegex, userVo.getTelNum())) {
			return JSONResult.success(resJoinVo);
		}
		
		if(!Pattern.matches(genRegex, userVo.getGender())) {
			return JSONResult.success(resJoinVo);
		}
		
		if(!Pattern.matches(ageRegex, Integer.toString(userVo.getAge()))) {
			return JSONResult.success(resJoinVo);
		}
		
		// 중복 아이디 체크
		Boolean result = userService.existId(userVo.getUserId());
		
		if(result) {
			resJoinVo.setIdExistFl(Boolean.TRUE);
			return JSONResult.success(resJoinVo);
		}
		
		// 사용자 등록
		Boolean joinResult = userService.userJoin(userVo);
		
		if(joinResult == false) {
			return JSONResult.fail("예기치 못한 서버 에러");
		}
		
		resJoinVo.setJoinFl(Boolean.TRUE);
		return JSONResult.success(resJoinVo);
	}
	
}
