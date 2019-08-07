package com.cafe24.jgmall.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jgmall.vo.BasketProductVo;
import com.cafe24.jgmall.vo.ProductOptVo;
import com.cafe24.jgmall.vo.ProductVo;

@Repository
public class ShopDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public List<ProductVo> selectProductList() {
		List<ProductVo> productList = sqlSession.selectList("shop.selectProductList", null);
		return productList;
	}

	public ProductVo selectProductDetailInfo(Long no) {
		ProductVo productVo = sqlSession.selectOne("shop.selectProductDetail", no);
		return productVo;
	}
	
	/**
	 * 상품 상세 옵션 조회
	 * @param productNo
	 * @return
	 */
	public List<ProductOptVo> selectProductOptionList(Long productNo) {
		List<ProductOptVo> productOptVo = sqlSession.selectList("shop.selectProductOptionList", productNo);
		return productOptVo;
	}

	public List<ProductVo> selectBasketProductList(Long userNo) {
		List<ProductVo> productList = new ArrayList<ProductVo>();
			List<BasketProductVo> basketproductList = sqlSession.selectList("shop.selectBasketProductList", userNo);
			for(BasketProductVo vo : basketproductList) {
				ProductVo productVo = sqlSession.selectOne("shop.selectProductOptList", vo.getOptionNo());
				productVo.setBasketStockAmt(vo.getProductAmt());
				productList.add(productVo);
			}
		
		return productList;
	}

	public int insertBasketProduct(BasketProductVo basketProductVo) {
		int cnt = sqlSession.insert("shop.insertBasketProduct", basketProductVo);
		return cnt;
	}
	
	public int deleteBasketProduct(Long basketVo) {
		int cnt = sqlSession.update("shop.deleteBasketProduct", basketVo);
		return cnt;
	}

}
