package com.cafe24.jgmall.vo;

public class BasketProductVo {
	String userNo;
	Integer optionNo;
	Integer productAmt;
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public Integer getOptionNo() {
		return optionNo;
	}
	public void setOptionNo(Integer optionNo) {
		this.optionNo = optionNo;
	}
	public Integer getProductAmt() {
		return productAmt;
	}
	public void setProductAmt(Integer productAmt) {
		this.productAmt = productAmt;
	}
	@Override
	public String toString() {
		return "BasketProductVo [userNo=" + userNo + ", optionNo=" + optionNo + ", productAmt=" + productAmt + "]";
	}
}
