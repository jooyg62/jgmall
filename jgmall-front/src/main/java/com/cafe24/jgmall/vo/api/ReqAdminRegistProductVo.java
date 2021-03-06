package com.cafe24.jgmall.vo.api;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class ReqAdminRegistProductVo {
	@NotBlank
	String productNm;
	
	@NotBlank
	@Pattern(regexp="^[YN]{1}$")
	String sellFl;
	
	@NotBlank
	@Pattern(regexp="^[YN]{1}$")
	String displaySt;
	String regDate;
	String productDpt;
	
	@DecimalMin("0")
	Integer sellPrc;
	Integer salePrc;
	
	@NotBlank
	@Pattern(regexp="^[YN]{1}$")
	String optionFl;
	String deleteFl;
	
	String optionNm;
	String addPrc;
	Integer optionOrd;
	Integer stockAmt;

	public String getProductNm() {
		return productNm;
	}

	public void setProductNm(String productNm) {
		this.productNm = productNm;
	}

	public String getSellFl() {
		return sellFl;
	}

	public void setSellFl(String sellFl) {
		this.sellFl = sellFl;
	}

	public String getDisplaySt() {
		return displaySt;
	}

	public void setDisplaySt(String displaySt) {
		this.displaySt = displaySt;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getProductDpt() {
		return productDpt;
	}

	public void setProductDpt(String productDpt) {
		this.productDpt = productDpt;
	}

	public Integer getSellPrc() {
		return sellPrc;
	}

	public void setSellPrc(Integer sellPrc) {
		this.sellPrc = sellPrc;
	}

	public Integer getSalePrc() {
		return salePrc;
	}

	public void setSalePrc(Integer salePrc) {
		this.salePrc = salePrc;
	}

	public String getOptionFl() {
		return optionFl;
	}

	public void setOptionFl(String optionFl) {
		this.optionFl = optionFl;
	}

	public String getDeleteFl() {
		return deleteFl;
	}

	public void setDeleteFl(String deleteFl) {
		this.deleteFl = deleteFl;
	}

	public String getOptionNm() {
		return optionNm;
	}

	public void setOptionNm(String optionNm) {
		this.optionNm = optionNm;
	}

	public String getAddPrc() {
		return addPrc;
	}

	public void setAddPrc(String addPrc) {
		this.addPrc = addPrc;
	}

	public Integer getOptionOrd() {
		return optionOrd;
	}

	public void setOptionOrd(Integer optionOrd) {
		this.optionOrd = optionOrd;
	}

	public Integer getStockAmt() {
		return stockAmt;
	}

	public void setStockAmt(Integer stockAmt) {
		this.stockAmt = stockAmt;
	}

	@Override
	public String toString() {
		return "ReqAdminRegistProductVo [productNm=" + productNm + ", sellFl=" + sellFl + ", displaySt=" + displaySt
				+ ", regDate=" + regDate + ", productDpt=" + productDpt + ", sellPrc=" + sellPrc + ", salePrc="
				+ salePrc + ", optionFl=" + optionFl + ", deleteFl=" + deleteFl + ", optionNm=" + optionNm + ", addPrc="
				+ addPrc + ", optionOrd=" + optionOrd + ", stockAmt=" + stockAmt + "]";
	}
}
