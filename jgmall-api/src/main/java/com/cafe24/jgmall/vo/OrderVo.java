package com.cafe24.jgmall.vo;

import java.util.ArrayList;
import java.util.List;

public class OrderVo {
	Long orderNo;
	String orderNm;
	String addrGb;
	String addr;
	String telNum;
	String memo;
	String orderDate;
	String orderPW;
	Long userNo;
	String userId;
	String orderSt;
	Integer totPayPrc;
	String orderUserId;
	List<OrderProductVo> orderProductVoList = new ArrayList<OrderProductVo>();
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
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
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public List<OrderProductVo> getOrderProductVoList() {
		return orderProductVoList;
	}
	public void setOrderProductVoList(List<OrderProductVo> orderProductVoList) {
		this.orderProductVoList = orderProductVoList;
	}
	@Override
	public String toString() {
		return "OrderVo [orderNo=" + orderNo + ", orderNm=" + orderNm + ", addrGb=" + addrGb + ", addr=" + addr
				+ ", telNum=" + telNum + ", memo=" + memo + ", orderDate=" + orderDate + ", orderPW=" + orderPW
				+ ", userNo=" + userNo + ", userId=" + userId + ", orderSt=" + orderSt + ", totPayPrc=" + totPayPrc
				+ ", orderUserId=" + orderUserId + ", orderProductVoList=" + orderProductVoList + "]";
	}
}
