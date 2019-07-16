package com.cafe24.jgmall.vo;

public class CategoryVo {
	String productNo;
	String categoryNo;
	Integer depth;
	String parentCd;
	String codeNm;
	Integer categoryOrd;
	String useFl;
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}
	public Integer getDepth() {
		return depth;
	}
	public void setDepth(Integer depth) {
		this.depth = depth;
	}
	public String getParentCd() {
		return parentCd;
	}
	public void setParentCd(String parentCd) {
		this.parentCd = parentCd;
	}
	public String getCodeNm() {
		return codeNm;
	}
	public void setCodeNm(String codeNm) {
		this.codeNm = codeNm;
	}
	public Integer getCategoryOrd() {
		return categoryOrd;
	}
	public void setCategoryOrd(Integer categoryOrd) {
		this.categoryOrd = categoryOrd;
	}
	public String getUseFl() {
		return useFl;
	}
	public void setUseFl(String useFl) {
		this.useFl = useFl;
	}
	@Override
	public String toString() {
		return "CategoryVo [productNo=" + productNo + ", categoryNo=" + categoryNo + ", depth=" + depth + ", parentCd="
				+ parentCd + ", codeNm=" + codeNm + ", categoryOrd=" + categoryOrd + ", useFl=" + useFl + "]";
	}
}
