package com.cafe24.jgmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jgmall.repository.AdminShopDao;
import com.cafe24.jgmall.vo.ProductVo;
import com.cafe24.jgmall.vo.api.ReqAdminRegistProductVo;

@Service
public class AdminShopService {
	
	@Autowired
	private AdminShopDao adminShopDao;

	public Boolean registProduct(ReqAdminRegistProductVo reqAdminRegistProductVo) {
		int result = adminShopDao.insert(reqAdminRegistProductVo);
		return 1 == result;
	}

	public List<ProductVo> getProductList() {
		List<ProductVo> productList = adminShopDao.selectProductList();
		return productList;
	}

	public ProductVo getProductDetail(Long productNo) {
		ProductVo productVo = adminShopDao.selectProductDetail(productNo);
		return productVo;
	}
	
}
