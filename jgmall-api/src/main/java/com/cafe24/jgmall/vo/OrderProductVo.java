package com.cafe24.jgmall.vo;

public class OrderProductVo {
	Long orderNo;
	Long productOptNo;
	String productNm;
	String productOptNm;
	String returnFl;
	Integer orderAmt;
	String orderSt;
	Integer payPrc;
	Long basketNo;
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public Long getProductOptNo() {
		return productOptNo;
	}
	public void setProductOptNo(Long productOptNo) {
		this.productOptNo = productOptNo;
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
	public Long getBasketNo() {
		return basketNo;
	}
	public void setBasketNo(Long basketNo) {
		this.basketNo = basketNo;
	}
	@Override
	public String toString() {
		return "OrderProductVo [orderNo=" + orderNo + ", productOptNo=" + productOptNo + ", productNm=" + productNm
				+ ", productOptNm=" + productOptNm + ", returnFl=" + returnFl + ", orderAmt=" + orderAmt + ", orderSt="
				+ orderSt + ", payPrc=" + payPrc + ", basketNo=" + basketNo + "]";
	}
}
