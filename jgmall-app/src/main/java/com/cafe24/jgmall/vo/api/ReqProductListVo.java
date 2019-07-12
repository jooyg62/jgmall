package com.cafe24.jgmall.vo.api;

public class ReqProductListVo {
	String kwd;

	public String getKwd() {
		return kwd;
	}

	public void setKwd(String kwd) {
		this.kwd = kwd;
	}

	@Override
	public String toString() {
		return "ReqProductListVo [kwd=" + kwd + "]";
	}
}
