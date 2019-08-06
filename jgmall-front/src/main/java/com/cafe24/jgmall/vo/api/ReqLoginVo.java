package com.cafe24.jgmall.vo.api;


import javax.validation.constraints.Pattern;


public class ReqLoginVo {
	@Pattern(regexp="^[a-zA-Z]{1}[a-zA-Z0-9_]{4,14}$", message="아이디 형식이 맞지 않습니다.")
	String userId;
	
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,16}$", message="패스워드 형식이 맞지 않습니다.")
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
