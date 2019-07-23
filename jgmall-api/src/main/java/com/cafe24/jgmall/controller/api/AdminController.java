package com.cafe24.jgmall.controller.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.jgmall.service.AdminService;
import com.cafe24.jgmall.utils.JgmallMsg;
import com.cafe24.jgmall.utils.JgmallUtils;
import com.cafe24.jgmall.vo.api.ReqAdminLoginVo;
import com.cafe24.jgmall.vo.api.ResAdminLoginVo;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.annotations.ApiOperation;

@RestController("adminApiController")
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private JgmallUtils jgmallUtils;
	
	@Autowired
	AdminService adminService;
	
	@ApiOperation(value="관리자 로그인")
	@PostMapping(value="/login")
	public ResponseEntity<JSONResult> login(
			@RequestBody @Valid ReqAdminLoginVo reqAdminLoginVo,
			BindingResult bindingResult,
			HttpServletRequest request) throws JsonProcessingException {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			StringBuilder sb = new StringBuilder();
			for(ObjectError error : allErrors) {
				String message = jgmallUtils.getMessage(error.getCodes()[0], error.getDefaultMessage());
				sb.append(message+"\n");
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(sb.toString()));
		}
		
		// 관리자 정보
		ResAdminLoginVo resAdminLoginVo = adminService.adminLogin(reqAdminLoginVo);
		
		if(resAdminLoginVo == null) {
			return ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail(jgmallUtils.getMessage("api.login.fail.notmatched", JgmallMsg.UNDEFINED_MSG.getMessage())));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(resAdminLoginVo));
	}
	
}
