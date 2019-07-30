package com.cafe24.jgmall.vo;

import java.util.ArrayList;
import java.util.List;

public class OptionVo {
	Long optionNmNo;
	String optionNm;
	int optionOrd;
	Long productNo;
	List<String> optionValueList = new ArrayList<String>();
	public Long getOptionNmNo() {
		return optionNmNo;
	}
	public void setOptionNmNo(Long optionNmNo) {
		this.optionNmNo = optionNmNo;
	}
	public String getOptionNm() {
		return optionNm;
	}
	public void setOptionNm(String optionNm) {
		this.optionNm = optionNm;
	}
	public int getOptionOrd() {
		return optionOrd;
	}
	public void setOptionOrd(int optionOrd) {
		this.optionOrd = optionOrd;
	}
	public Long getProductNo() {
		return productNo;
	}
	public void setProductNo(Long productNo) {
		this.productNo = productNo;
	}
	public List<String> getOptionValueList() {
		return optionValueList;
	}
	public void setOptionValueList(List<String> optionValueList) {
		this.optionValueList = optionValueList;
	}
	@Override
	public String toString() {
		return "OptionVo [optionNmNo=" + optionNmNo + ", optionNm=" + optionNm + ", optionOrd=" + optionOrd
				+ ", productNo=" + productNo + ", optionValueList=" + optionValueList + "]";
	}
}
