package com.cafe24.jgmall.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jgmall.vo.BasketProductVo;
import com.cafe24.jgmall.vo.FileVo;
import com.cafe24.jgmall.vo.OrderProductVo;
import com.cafe24.jgmall.vo.OrderVo;
import com.cafe24.jgmall.vo.ProductVo;

@Repository
public class OrderDao {
	
	@Autowired
	SqlSession sqlSession;

	/**
	 * 결제하기
	 * @param orderVo
	 * @return
	 */
	public int insertPayOrder(OrderVo orderVo) {
		int cnt = sqlSession.insert("order.insertPayOrder", orderVo);
		return cnt;
	}

	/**
	 * 결제상품등록
	 * @param OrderVo
	 * @return
	 */
	public int insertPayOrderProductList(OrderVo OrderVo) {
		int cnt = sqlSession.insert("order.insertPayOrderProductList", OrderVo);
		return cnt;
	}

	/**
	 * 주문내역 조회
	 * @param userNo
	 * @return
	 */
	public List<OrderVo> selectOrderInfo(Long userNo) {
		List<OrderVo> orderVoList = sqlSession.selectList("order.selectOrderInfo", userNo);
		return orderVoList;
	}

	/**
	 * 주문내역 상품 조회
	 * @param userNo
	 * @return
	 */
	public List<OrderProductVo> selectOrderProductList(Long userNo) {
		return sqlSession.selectList("order.selectOrderProductList", userNo);
	}

	/**
	 * 상품 이미지 조회
	 * @param productNo
	 * @return
	 */
	public List<FileVo> selectProductImgList(Long productNo) {
		return sqlSession.selectList("order.selectProductImgList", productNo);
	}
	
}
