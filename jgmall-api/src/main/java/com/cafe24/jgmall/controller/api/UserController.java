package com.cafe24.jgmall.controller.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.jgmall.service.UserService;
import com.cafe24.jgmall.vo.UserVo;
import com.cafe24.jgmall.vo.api.ReqJoinVo;
import com.cafe24.jgmall.vo.api.ReqLoginVo;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("userAPIController")
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@ApiOperation(value="유저 로그인")
	@ApiImplicitParams({
		@ApiImplicitParam(name="loginVo", value="userId: 유저아이디 \n password: 패스워드", required=true, dataType="ReqLoginVo", defaultValue="")
	})
	@PostMapping(value="/login")
	public ResponseEntity<JSONResult> login(
			@RequestBody @Valid ReqLoginVo loginVo,
			BindingResult bindingResult,
			HttpServletRequest request) throws JsonProcessingException {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for(ObjectError error : allErrors) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
			}
		}
		
		// 유저 정보
		UserVo authUser = userService.userLogin(loginVo);
		
		if(authUser == null) {
			return ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail("아이디, 패스워드가 일치하지 않습니다."));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(authUser));
	}
	
	@ApiOperation(value="아이디 중복체크")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id", value="id: 유저 아이디", required=true, dataType="string", defaultValue="")
	})
	@GetMapping(value="/exist/{id:(?:[a-zA-Z]{1}[a-zA-Z0-9_]{4,14})}")
	public ResponseEntity<JSONResult> existId(@PathVariable("id") String id) {
		Boolean result = userService.existId(id);
		
		if(result) {
			return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail("중복된 아이디가 없습니다."));
	}
	
	@ApiOperation(value="유저 회원가입")
	@ApiImplicitParams({
		@ApiImplicitParam(name="reqJoinVo", value=
				"	 * 이름: 한글, 영문 2~20자까지\r\n" + 
				"	 * 가입일: 숫자 8자\r\n" + 
				"	 * 휴대번호: 숫자 10~11자리\r\n" + 
				"	 * 성별: M,F\r\n" + 
				"	 * 나이: 숫자 한자리 또는 두자리", required=true, dataType="ReqJoinVo", defaultValue="")
	})
	@PostMapping(value="/join")
	public ResponseEntity<JSONResult> join(
			@RequestBody @Valid ReqJoinVo reqJoinVo,
			BindingResult bindResult,
			HttpServletRequest request) {
		
		if(bindResult.hasErrors()) {
			List<ObjectError> allErrors = bindResult.getAllErrors();
			for(ObjectError error : allErrors) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
			}
		}
		
		// 중복 아이디 체크
		Boolean result = userService.existId(reqJoinVo.getUserId());
		
		if(result) {
			return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null));
		}
		
		// 사용자 등록
		Boolean joinResult = userService.userJoin(reqJoinVo);
		
		if(joinResult == false) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(JSONResult.fail(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null));
	}
	
}
