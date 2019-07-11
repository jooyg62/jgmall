package com.cafe24.jgmall.vo.api;


import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;


public class ReqJoinVo {
	@NotBlank
	@Length(min=5, max=15, message="아이디는 5~15자 사이로 입력해주세요.")
	@Pattern(regexp="^[a-zA-Z]{1}[a-zA-Z0-9_]*$", message="아이디 형식이 맞지 않습니다.")
	String userId;
	
	@NotBlank
	@Length(min=8, max=16, message="패스워드 길이는 8~16자 입니다.")
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]*$", message="패스워드 형식이 맞지 않습니다.")
	String password;
	
	@NotBlank
	@Pattern(regexp="^[가-힣|a-zA-Z]{2,20}$", message="이름 형식이 맞지 않습니다.")
	String userNm;
	
	@NotBlank
	@Pattern(regexp="[0-9]{4}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])", message="가입일 형식이 맞지 않습니다.")
	String joinDate;
	
	@NotBlank
	@Pattern(regexp="^01(?:0|1|[6-9])(\\d{3}|\\d{4})(\\d{4})$", message="휴대번호 형식이 맞지 않습니다.")
	String telNum;
	
	@NotBlank
	@Pattern(regexp="^[M|F]{1}$", message="성별 형식이 맞지 않습니다.")
	String gender;
	
	@DecimalMin(value="1", message="나이 형식이 맞지 않습니다.")
	@DecimalMax(value="100", message="나이 형식이 맞지 않습니다.")
	int age;

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

	@Override
	public String toString() {
		return "ReqJoinVo [userId=" + userId + ", password=" + password + ", userNm=" + userNm + ", joinDate="
				+ joinDate + ", telNum=" + telNum + ", gender=" + gender + ", age=" + age + "]";
	}
}
