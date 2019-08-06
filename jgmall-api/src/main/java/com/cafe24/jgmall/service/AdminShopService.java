package com.cafe24.jgmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jgmall.repository.AdminShopDao;
import com.cafe24.jgmall.vo.OptionVo;
import com.cafe24.jgmall.vo.ProductOptVo;
import com.cafe24.jgmall.vo.ProductVo;

@Service
public class AdminShopService {
	
	@Autowired
	private AdminShopDao adminShopDao;

	public Boolean registProduct(ProductVo productVo) {
		// 1. 상품 등록
		adminShopDao.insert(productVo);
		
		if("Y".equals(productVo.getOptionFl())) {
			long lastInsertProductNo = productVo.getProductNo();
			
			// 2. 옵션명, 옵션값 등록
			List<OptionVo> optionVoList = productVo.getOptionVoList();
			for(int i=0; i < optionVoList.size(); i++) {
				OptionVo optionVo = optionVoList.get(i);
				optionVo.setOptionOrd(i+1);
				optionVo.setProductNo(lastInsertProductNo);
				adminShopDao.insertOptionNm(optionVo);
				adminShopDao.insertOptionValue(optionVo);
			}
		} else {
			adminShopDao.insertNonOptionProduct(productVo);
		}
		
		return true;
	}

	public List<ProductVo> getProductList() {
		List<ProductVo> productList = adminShopDao.selectProductList();
		return productList;
	}

	public ProductVo getProductDetail(Long productNo) {
		ProductVo productVo = adminShopDao.selectProductDetail(productNo);
		
		List<ProductOptVo> productOptVoList = adminShopDao.selectProductOptionList(productNo);
		productVo.setProductOptVoList(productOptVoList);
		
		return productVo;
	}

	public Boolean removeProduct(Long productNo) {
		int result = adminShopDao.deleteProduct(productNo);
		return 1 == result;
	}

	public Boolean modifyProduct(ProductVo productVo) {
		int result = adminShopDao.updateProduct(productVo);
		return 1 == result;
	}

	public List<ProductVo> getProductStockList() {
		List<ProductVo> productList = adminShopDao.selectProductStockList();
		return productList;
	}

	public Boolean modifyProductStock(ProductVo productVo) {
		int result = adminShopDao.updateProductStock(productVo);
		return 1 == result;
	}
	
}
