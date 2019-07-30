package com.cafe24.jgmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.jgmall.repository.OrderDao;
import com.cafe24.jgmall.repository.ShopDao;
import com.cafe24.jgmall.vo.OrderProductVo;
import com.cafe24.jgmall.vo.OrderVo;
import com.cafe24.jgmall.vo.UserVo;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	ShopDao shopDao;

	public Boolean payOrder(OrderVo orderVo) {
		// 주문 등록
		orderDao.insertPayOrder(orderVo);
		
		// 주문 상품 등록
		List<OrderProductVo> orderProductVoList = orderVo.getOrderProductVoList();
		for(OrderProductVo orderProductVo : orderProductVoList) {
			orderDao.insertPayOrderProductList(orderProductVo);
			if(orderProductVo.getBasketNo() != null) {
				shopDao.deleteBasketProduct(orderProductVo.getBasketNo());
			}
		}
		
		return true;
	}
	
}
