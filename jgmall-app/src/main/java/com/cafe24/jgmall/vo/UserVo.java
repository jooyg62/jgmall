package com.cafe24.jgmall.vo;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;


public class UserVo {
	Long no;
	@NotBlank(message="아이디를 입력해 주세요.")
	@Length(min=5, max=15, message="아이디는 5~15자 사이로 입력해주세요.")
	@Pattern(regexp="^[a-zA-Z]{1}[a-zA-Z0-9_]*$", message="아이디 형식이 맞지 않습니다.")
	String userId;
	
	@NotBlank(message="패스워드를 입력해 주세요.")
	@Length(min=8, max=16, message="패스워드 길이는 8~16자 입니다.")
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]*$", message="패스워드는 숫자, 문자, 특수문자 각각 1개 이상 포함해야합니다.")
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
