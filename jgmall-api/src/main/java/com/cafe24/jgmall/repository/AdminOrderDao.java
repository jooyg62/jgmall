package com.cafe24.jgmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jgmall.vo.OrderProductVo;
import com.cafe24.jgmall.vo.OrderVo;

@Repository
public class AdminOrderDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<OrderVo> selectOrderList() {
		List<OrderVo> orderList = sqlSession.selectList("order.selectOrderList", null);
		
		return orderList;
	}

	public List<OrderProductVo> selectOrderProductList(Long orderNo) {
		List<OrderProductVo> orderProductList = sqlSession.selectList("order.selectOrderProductList", orderNo);
		return orderProductList;
	}

}
