package com.cafe24.jgmall.vo;

public class FileVo {
	String imgType;
	String oriFileNm;
	String saveFileName;
	String saveUrl;
	String extNm;
	String delFl;
	public String getImgType() {
		return imgType;
	}
	public void setImgType(String imgType) {
		this.imgType = imgType;
	}
	public String getOriFileNm() {
		return oriFileNm;
	}
	public void setOriFileNm(String oriFileNm) {
		this.oriFileNm = oriFileNm;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
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
	public String getDelFl() {
		return delFl;
	}
	public void setDelFl(String delFl) {
		this.delFl = delFl;
	}
	@Override
	public String toString() {
		return "FileVo [imgType=" + imgType + ", oriFileNm=" + oriFileNm + ", saveFileName=" + saveFileName
				+ ", saveUrl=" + saveUrl + ", extNm=" + extNm + ", delFl=" + delFl + "]";
	}
}
