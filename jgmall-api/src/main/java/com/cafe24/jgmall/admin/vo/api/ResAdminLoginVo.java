package com.cafe24.jgmall.admin.vo.api;

public class ResAdminLoginVo {
	Long no;
	String userId;
	String password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginDt() {
		return loginDt;
	}
	public void setLoginDt(String loginDt) {
		this.loginDt = loginDt;
	}
	@Override
	public String toString() {
		return "ResAdminLoginVo [no=" + no + ", userId=" + userId + ", password=" + password + ", loginDt=" + loginDt
				+ "]";
	}
}
