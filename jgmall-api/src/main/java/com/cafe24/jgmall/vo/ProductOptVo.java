package com.cafe24.jgmall.vo;

public class ProductOptVo {
	Integer optionNo;
	String optionNm;
	Integer opttionOrd;
	Integer productNo;
	public Integer getOptionNo() {
		return optionNo;
	}
	public void setOptionNo(Integer optionNo) {
		this.optionNo = optionNo;
	}
	public String getOptionNm() {
		return optionNm;
	}
	public void setOptionNm(String optionNm) {
		this.optionNm = optionNm;
	}
	public Integer getOpttionOrd() {
		return opttionOrd;
	}
	public void setOpttionOrd(Integer opttionOrd) {
		this.opttionOrd = opttionOrd;
	}
	public Integer getProductNo() {
		return productNo;
	}
	public void setProductNo(Integer productNo) {
		this.productNo = productNo;
	}
	@Override
	public String toString() {
		return "ProductOptVo [optionNo=" + optionNo + ", optionNm=" + optionNm + ", opttionOrd=" + opttionOrd
				+ ", productNo=" + productNo + "]";
	}
}
