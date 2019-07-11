package com.cafe24.jgmall.vo.api;

public class ResJoinVo {
	Boolean joinFl;
	Boolean idExistFl;
	public Boolean getJoinFl() {
		return joinFl;
	}
	public void setJoinFl(Boolean joinFl) {
		this.joinFl = joinFl;
	}
	public Boolean getIdExistFl() {
		return idExistFl;
	}
	public void setIdExistFl(Boolean idExistFl) {
		this.idExistFl = idExistFl;
	}
	@Override
	public String toString() {
		return "ResJoinVo [joinFl=" + joinFl + ", idExistFl=" + idExistFl + "]";
	}
}
