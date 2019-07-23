package com.cafe24.jgmall.vo;

public class OrderProductVo {
	Long orderNo;
	Long productNo;
	String productNm;
	String productOptNm;
	String returnFl;
	Integer orderAmt;
	String orderSt;
	Integer payPrc;
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
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
	public String getProductOptNm() {
		return productOptNm;
	}
	public void setProductOptNm(String productOptNm) {
		this.productOptNm = productOptNm;
	}
	public String getReturnFl() {
		return returnFl;
	}
	public void setReturnFl(String returnFl) {
		this.returnFl = returnFl;
	}
	public Integer getOrderAmt() {
		return orderAmt;
	}
	public void setOrderAmt(Integer orderAmt) {
		this.orderAmt = orderAmt;
	}
	public String getOrderSt() {
		return orderSt;
	}
	public void setOrderSt(String orderSt) {
		this.orderSt = orderSt;
	}
	public Integer getPayPrc() {
		return payPrc;
	}
	public void setPayPrc(Integer payPrc) {
		this.payPrc = payPrc;
	}
	@Override
	public String toString() {
		return "OrderDetailVo [orderNo=" + orderNo + ", productNo=" + productNo + ", productNm=" + productNm
				+ ", productOptNm=" + productOptNm + ", returnFl=" + returnFl + ", orderAmt=" + orderAmt + ", orderSt="
				+ orderSt + ", payPrc=" + payPrc + "]";
	}
}
