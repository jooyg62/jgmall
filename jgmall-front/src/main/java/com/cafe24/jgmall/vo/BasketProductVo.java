package com.cafe24.jgmall.vo;

public class BasketProductVo {
	Long basketNo;
	Long userNo;
	Long optionNo;
	Integer productAmt;
	public Long getBasketNo() {
		return basketNo;
	}
	public void setBasketNo(Long basketNo) {
		this.basketNo = basketNo;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public Long getOptionNo() {
		return optionNo;
	}
	public void setOptionNo(Long optionNo) {
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
