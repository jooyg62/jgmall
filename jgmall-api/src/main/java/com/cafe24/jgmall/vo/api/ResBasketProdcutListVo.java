package com.cafe24.jgmall.vo.api;

public class ResBasketProdcutListVo {
	String productNm;
	Integer sellPrc;
	Integer salePrc;
	String optionFl;
	String optionNm;
	Integer addPrc;
	Integer stockAmt;
	String imgType;
	String saveUrl;
	public String getProductNm() {
		return productNm;
	}
	public void setProductNm(String productNm) {
		this.productNm = productNm;
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
	public String getOptionNm() {
		return optionNm;
	}
	public void setOptionNm(String optionNm) {
		this.optionNm = optionNm;
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
	public String getImgType() {
		return imgType;
	}
	public void setImgType(String imgType) {
		this.imgType = imgType;
	}
	public String getSaveUrl() {
		return saveUrl;
	}
	public void setSaveUrl(String saveUrl) {
		this.saveUrl = saveUrl;
	}
	@Override
	public String toString() {
		return "ResBasketProdcutListVo [productNm=" + productNm + ", sellPrc=" + sellPrc + ", salePrc=" + salePrc
				+ ", optionFl=" + optionFl + ", optionNm=" + optionNm + ", addPrc=" + addPrc + ", stockAmt=" + stockAmt
				+ ", imgType=" + imgType + ", saveUrl=" + saveUrl + "]";
	}
}
