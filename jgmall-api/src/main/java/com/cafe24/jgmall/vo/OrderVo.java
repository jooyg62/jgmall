package com.cafe24.jgmall.vo;

public class OrderVo {
	String orderNo;
	String orderNm;
	String addrGb;
	String addr;
	String telNum;
	String memo;
	String orderDate;
	String orderPW;
	String userNo;
	String orderSt;
	Integer totPayPrc;
	String orderUserId;
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderNm() {
		return orderNm;
	}
	public void setOrderNm(String orderNm) {
		this.orderNm = orderNm;
	}
	public String getAddrGb() {
		return addrGb;
	}
	public void setAddrGb(String addrGb) {
		this.addrGb = addrGb;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTelNum() {
		return telNum;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderPW() {
		return orderPW;
	}
	public void setOrderPW(String orderPW) {
		this.orderPW = orderPW;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getOrderSt() {
		return orderSt;
	}
	public void setOrderSt(String orderSt) {
		this.orderSt = orderSt;
	}
	public Integer getTotPayPrc() {
		return totPayPrc;
	}
	public void setTotPayPrc(Integer totPayPrc) {
		this.totPayPrc = totPayPrc;
	}
	public String getOrderUserId() {
		return orderUserId;
	}
	public void setOrderUserId(String orderUserId) {
		this.orderUserId = orderUserId;
	}
	@Override
	public String toString() {
		return "OrderVo [orderNo=" + orderNo + ", orderNm=" + orderNm + ", addrGb=" + addrGb + ", addr=" + addr
				+ ", telNum=" + telNum + ", memo=" + memo + ", orderDate=" + orderDate + ", orderPW=" + orderPW
				+ ", userNo=" + userNo + ", orderSt=" + orderSt + ", totPayPrc=" + totPayPrc + ", orderUserId="
				+ orderUserId + "]";
	}
}
