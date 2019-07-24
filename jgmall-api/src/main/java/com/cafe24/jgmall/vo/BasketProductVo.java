package com.cafe24.jgmall.vo;

public class BasketProductVo {
	Integer optionNo;
	Integer productAmt;
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
		return "BasketProductVo [optionNo=" + optionNo + ", productAmt=" + productAmt + "]";
	}
}
