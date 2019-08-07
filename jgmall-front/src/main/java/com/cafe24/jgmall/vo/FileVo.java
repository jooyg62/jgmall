package com.cafe24.jgmall.vo;

public class FileVo {
	String typeCd;
	String oriNm;
	String saveUrl;
	String extNm;
	String base64EncodingData;
	public String getTypeCd() {
		return typeCd;
	}
	public void setTypeCd(String typeCd) {
		this.typeCd = typeCd;
	}
	public String getOriNm() {
		return oriNm;
	}
	public void setOriNm(String oriNm) {
		this.oriNm = oriNm;
	}
	public String getSaveUrl() {
		return saveUrl;
	}
	public void setSaveUrl(String saveUrl) {
		this.saveUrl = saveUrl;
	}
	public String getExtNm() {
		return extNm;
	}
	public void setExtNm(String extNm) {
		this.extNm = extNm;
	}
	public String getBase64EncodingData() {
		return base64EncodingData;
	}
	public void setBase64EncodingData(String base64EncodingData) {
		this.base64EncodingData = base64EncodingData;
	}
	@Override
	public String toString() {
		return "FileVo [typeCd=" + typeCd + ", oriNm=" + oriNm + ", saveUrl=" + saveUrl + ", extNm=" + extNm
				+ ", base64EncodingData=" + base64EncodingData + "]";
	}
}
