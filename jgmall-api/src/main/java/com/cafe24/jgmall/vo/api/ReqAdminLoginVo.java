package com.cafe24.jgmall.vo.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class ReqAdminLoginVo {
	@NotBlank
	@Length(min=5, max=15)
	@Pattern(regexp="^[a-zA-Z]{1}[a-zA-Z0-9_]{4,14}$")
	String userId;
	
	@NotBlank
	@Length(min=8, max=16)
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,16}$")
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
