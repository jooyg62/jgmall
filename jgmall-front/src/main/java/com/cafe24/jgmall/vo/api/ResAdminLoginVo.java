package com.cafe24.jgmall.vo.api;

public class ResAdminLoginVo {
	Long no;
	String userId;
	String loginDt;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLoginDt() {
		return loginDt;
	}
	public void setLoginDt(String loginDt) {
		this.loginDt = loginDt;
	}
	@Override
	public String toString() {
		return "ResAdminLoginVo [no=" + no + ", userId=" + userId + ", loginDt=" + loginDt + "]";
	}
}
