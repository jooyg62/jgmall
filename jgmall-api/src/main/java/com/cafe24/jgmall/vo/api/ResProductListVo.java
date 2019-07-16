package com.cafe24.jgmall.vo.api;

import java.util.ArrayList;
import java.util.List;

import com.cafe24.jgmall.vo.PageVo;
import com.cafe24.jgmall.vo.ProductVo;

public class ResProductListVo {
	List<ProductVo> productList = new ArrayList<ProductVo>();
	PageVo pageVo;
	public List<ProductVo> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductVo> productList) {
		this.productList = productList;
	}
	public PageVo getPageVo() {
		return pageVo;
	}
	public void setPageVo(PageVo pageVo) {
		this.pageVo = pageVo;
	}
	@Override
	public String toString() {
		return "ResProductListVo [productList=" + productList + ", pageVo=" + pageVo + "]";
	}
}
