package com.cafe24.jgmall.vo.api;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;


public class ReqLoginVo {
	@NotBlank
	@Length(min=5, max=15, message="아이디는 5~15자 사이로 입력해주세요.")
	@Pattern(regexp="^[a-zA-Z]{1}[a-zA-Z0-9_]*$", message="아이디 형식이 맞지 않습니다.")
	String userId;
	
	@NotBlank
	@Length(min=8, max=16, message="패스워드 길이는 8~16자 입니다.")
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]*$", message="패스워드 형식이 맞지 않습니다.")
	String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginVo [userId=" + userId + ", password=" + password + "]";
	}
}
