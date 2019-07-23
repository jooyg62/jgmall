package com.cafe24.jgmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jgmall.vo.ProductVo;
import com.cafe24.jgmall.vo.api.ReqAdminRegistProductVo;

@Repository
public class AdminShopDao {
	
	@Autowired
	private SqlSession sqlSession;

	public int insert(ReqAdminRegistProductVo reqAdminRegistProductVo) {
		int result = sqlSession.insert("shop.insert", reqAdminRegistProductVo);
		return result;
	}

	public List<ProductVo> selectProductList() {
		List<ProductVo> productList = sqlSession.selectList("shop.selectProductList", null);
		return productList;
	}

	public ProductVo selectProductDetail(Long productNo) {
		ProductVo productVo = sqlSession.selectOne("shop.selectProductDetail", productNo);
		return productVo;
	}

	public int deleteProduct(Long productNo) {
		int result = sqlSession.update("shop.deleteProduct", productNo);
		return result;
	}

	public int updateProduct(ProductVo productVo) {
		int result = sqlSession.update("shop.updateProduct", productVo);
		return result;
	}

	public List<ProductVo> selectProductStockList() {
		List<ProductVo> productList = sqlSession.selectList("shop.selectProductStockList", null);
		return productList;
	}

	public int updateProductStock(ProductVo productVo) {
		int result = sqlSession.update("shop.updateProductStock", productVo);
		return result;
	}

}
