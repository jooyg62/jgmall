package com.cafe24.jgmall.vo;

public class ProductOptVo {
	Integer optionNo;
	Integer optionOrd;
	String optionNmNo;
	String optionValueNo;
	String optionNm;
	String displaySt;
	String sellFl;
	Integer addPrc;
	Integer stockAmt;
	String stockFl;
	Integer productNo;
	public Integer getOptionNo() {
		return optionNo;
	}
	public void setOptionNo(Integer optionNo) {
		this.optionNo = optionNo;
	}
	public Integer getOptionOrd() {
		return optionOrd;
	}
	public void setOptionOrd(Integer optionOrd) {
		this.optionOrd = optionOrd;
	}
	public String getOptionNmNo() {
		return optionNmNo;
	}
	public void setOptionNmNo(String optionNmNo) {
		this.optionNmNo = optionNmNo;
	}
	public String getOptionValueNo() {
		return optionValueNo;
	}
	public void setOptionValueNo(String optionValueNo) {
		this.optionValueNo = optionValueNo;
	}
	public String getOptionNm() {
		return optionNm;
	}
	public void setOptionNm(String optionNm) {
		this.optionNm = optionNm;
	}
	public String getDisplaySt() {
		return displaySt;
	}
	public void setDisplaySt(String displaySt) {
		this.displaySt = displaySt;
	}
	public String getSellFl() {
		return sellFl;
	}
	public void setSellFl(String sellFl) {
		this.sellFl = sellFl;
	}
	public Integer getAddPrc() {
		return addPrc;
	}
	public void setAddPrc(Integer addPrc) {
		this.addPrc = addPrc;
	}
	public Integer getStockAmt() {
		return stockAmt;
	}
	public void setStockAmt(Integer stockAmt) {
		this.stockAmt = stockAmt;
	}
	public String getStockFl() {
		return stockFl;
	}
	public void setStockFl(String stockFl) {
		this.stockFl = stockFl;
	}
	public Integer getProductNo() {
		return productNo;
	}
	public void setProductNo(Integer productNo) {
		this.productNo = productNo;
	}
	@Override
	public String toString() {
		return "ProductOptVo [optionNo=" + optionNo + ", optionOrd=" + optionOrd + ", optionNmNo=" + optionNmNo
				+ ", optionValueNo=" + optionValueNo + ", optionNm=" + optionNm + ", displaySt=" + displaySt
				+ ", sellFl=" + sellFl + ", addPrc=" + addPrc + ", stockAmt=" + stockAmt + ", stockFl=" + stockFl
				+ ", productNo=" + productNo + "]";
	}
}
