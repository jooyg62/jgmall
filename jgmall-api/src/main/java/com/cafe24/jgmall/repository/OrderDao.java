package com.cafe24.jgmall.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jgmall.vo.BasketProductVo;
import com.cafe24.jgmall.vo.OrderProductVo;
import com.cafe24.jgmall.vo.OrderVo;
import com.cafe24.jgmall.vo.ProductVo;

@Repository
public class OrderDao {
	
	@Autowired
	SqlSession sqlSession;

	public int insertPayOrder(OrderVo orderVo) {
		int cnt = sqlSession.insert("order.insertPayOrder", orderVo);
		return cnt;
	}

	public int insertPayOrderProductList(OrderProductVo orderProductVo) {
		int cnt = sqlSession.insert("order.insertPayOrderProductList", orderProductVo);
		return cnt;
	}

}
