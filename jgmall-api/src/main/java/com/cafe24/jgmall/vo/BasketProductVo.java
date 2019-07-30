package com.cafe24.jgmall.vo;

public class BasketProductVo {
	Long basketNo;
	String userNo;
	Integer optionNo;
	Integer productAmt;
	public Long getBasketNo() {
		return basketNo;
	}
	public void setBasketNo(Long basketNo) {
		this.basketNo = basketNo;
	}
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
		return "BasketProductVo [basketNo=" + basketNo + ", userNo=" + userNo + ", optionNo=" + optionNo
				+ ", productAmt=" + productAmt + "]";
	}
}
