package com.cafe24.jgmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.jgmall.repository.ShopDao;
import com.cafe24.jgmall.vo.ProductVo;
import com.cafe24.jgmall.vo.api.ResBasketProdcutListVo;
import com.cafe24.jgmall.vo.api.ResProductInfo;

@Service
public class ShopService {
	
	@Autowired
	ShopDao shopDao;

	/**
	 *	상품 리스트 가져오기 
	 */
	public List<ProductVo> getProductList() {
		List<ProductVo> productList = shopDao.selectProductList();
		return productList;
	}

	/**
	 * 상품 상세
	 * @param no
	 * @return
	 */
	public ProductVo getProductInfo(Long no) {
		ProductVo productVo = shopDao.selectProductDetailInfo(no);
		return productVo;
	}

	/**
	 * 상품 담기
	 * @param no
	 * @return
	 */
	public Boolean addProductInBasket(Long no) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * 장바구니 조회
	 * @param no
	 * @return
	 */
	@Transactional
	public List<ProductVo> getBasketProductList(Long userNo) {
		List<ProductVo> productList = shopDao.selectBasketProductList(userNo);
		return productList;
	}

	public Boolean removeProductInBasket(Long no) {
		return true;
	}
	
}
