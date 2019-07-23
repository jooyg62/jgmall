package com.cafe24.jgmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jgmall.vo.ProductVo;

@Repository
public class ShopDao {
	
	@Autowired
	SqlSession sqlSession;

	public List<ProductVo> selectProductList() {
		List<ProductVo> productList = sqlSession.selectList("shop.selectProductList", null);
		
		return productList;
	}

}
