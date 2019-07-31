package com.cafe24.jgmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.jgmall.repository.OrderDao;
import com.cafe24.jgmall.repository.ShopDao;
import com.cafe24.jgmall.vo.FileVo;
import com.cafe24.jgmall.vo.OrderProductVo;
import com.cafe24.jgmall.vo.OrderVo;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	ShopDao shopDao;

	/**
	 * 결제하기
	 * @param orderVo
	 * @return
	 */
	public Boolean payOrder(OrderVo orderVo) {
		// 주문 등록
		int orderNo = orderDao.insertPayOrder(orderVo);
		orderVo.setOrderNo(Long.parseLong(Integer.toString(orderNo)));
		
		// 주문 상품 등록
		orderDao.insertPayOrderProductList(orderVo);
		
		List<OrderProductVo> orderProductVoList = orderVo.getOrderProductVoList();
		// 장바구니 내역 삭제
		for(OrderProductVo orderProductVo : orderProductVoList) {
			if(orderProductVo.getBasketNo() != null) {
				shopDao.deleteBasketProduct(orderProductVo.getBasketNo());
			}
		}
		
		return true;
	}

	/**
	 * 주문내역 조회
	 * @param userNo
	 * @return
	 */
	public List<OrderVo> getOrderInfo(Long userNo) {
		// 주문 내역 조회
		List<OrderVo> orderVoList = orderDao.selectOrderInfo(userNo);
		for(OrderVo orderVo : orderVoList) {
			// 주문 상품 리스트 조회
			List<OrderProductVo> orderProductVoList = orderDao.selectOrderProductList(userNo);
			orderVo.getOrderProductVoList().addAll(orderProductVoList);
			
			for(OrderProductVo orderproductvo : orderProductVoList) {
				// 주문 이미지 조회
				List<FileVo> fileVoList = orderDao.selectProductImgList(orderproductvo.getProductNo());
				orderproductvo.getFileVoList().addAll(fileVoList);
			}
		}
		
		return orderVoList;
	}
	
}
