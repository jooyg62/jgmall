package com.cafe24.jgmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.jgmall.repository.ShopDao;
import com.cafe24.jgmall.vo.BasketProductVo;
import com.cafe24.jgmall.vo.ProductVo;

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
	 * 장바구니 조회
	 * @param no
	 * @return
	 */
	@Transactional
	public List<ProductVo> getBasketProductList(Long userNo) {
		List<ProductVo> productList = shopDao.selectBasketProductList(userNo);
		return productList;
	}

	/**
	 * 장바구니 담기
	 * @param basketProductVo
	 * @return
	 */
	public Boolean registBasketProduct(BasketProductVo basketProductVo) {
		int cnt = shopDao.insertBasketProduct(basketProductVo);
		return 1 == cnt;
	}
	
	/**
	 * 장바구니 삭제
	 * @param basketProductVo
	 * @return
	 */
	public Boolean removeBasketProduct(BasketProductVo basketProductVo) {
		int cnt = shopDao.deleteBasketProduct(basketProductVo);
		return 1 == cnt;
	}

	
}
