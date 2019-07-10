package com.cafe24.jgmall.vo;

public class UserVo {
	Long no;
	String userId;
	String password;
	String userNm;
	String joinDate;
	String telNum;
	String gender;
	int age;
	String delFl;
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
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getTelNum() {
		return telNum;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDelFl() {
		return delFl;
	}
	public void setDelFl(String delFl) {
		this.delFl = delFl;
	}
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", userId=" + userId + ", password=" + password + ", userNm=" + userNm
				+ ", joinDate=" + joinDate + ", telNum=" + telNum + ", gender=" + gender + ", age=" + age + ", delFl="
				+ delFl + "]";
	}
}
