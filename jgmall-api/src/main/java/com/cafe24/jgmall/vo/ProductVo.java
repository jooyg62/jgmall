package com.cafe24.jgmall.vo;

import java.util.ArrayList;
import java.util.List;

public class ProductVo {
	Long productNo;
	String productNm;
	String sellFl;
	String displaySt;
	String regDate;
	String productDpt;
	Integer sellPrc;
	Integer salePrc;
	String optionFl;
	String deleteFl;
	String optionNm;
	String addPrc;
	Integer optionOrd;
	Integer stockAmt;
	Integer basketStockAmt;
	String stockFl;
	List<FileVo> fileList = new ArrayList<FileVo>();
	public Long getProductNo() {
		return productNo;
	}
	public void setProductNo(Long productNo) {
		this.productNo = productNo;
	}
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
	public Integer getBasketStockAmt() {
		return basketStockAmt;
	}
	public void setBasketStockAmt(Integer basketStockAmt) {
		this.basketStockAmt = basketStockAmt;
	}
	public String getStockFl() {
		return stockFl;
	}
	public void setStockFl(String stockFl) {
		this.stockFl = stockFl;
	}
	public List<FileVo> getFileList() {
		return fileList;
	}
	public void setFileList(List<FileVo> fileList) {
		this.fileList = fileList;
	}
	@Override
	public String toString() {
		return "ProductVo [productNo=" + productNo + ", productNm=" + productNm + ", sellFl=" + sellFl + ", displaySt="
				+ displaySt + ", regDate=" + regDate + ", productDpt=" + productDpt + ", sellPrc=" + sellPrc
				+ ", salePrc=" + salePrc + ", optionFl=" + optionFl + ", deleteFl=" + deleteFl + ", optionNm="
				+ optionNm + ", addPrc=" + addPrc + ", optionOrd=" + optionOrd + ", stockAmt=" + stockAmt
				+ ", basketStockAmt=" + basketStockAmt + ", stockFl=" + stockFl + ", fileList=" + fileList + "]";
	}
	
	
}
