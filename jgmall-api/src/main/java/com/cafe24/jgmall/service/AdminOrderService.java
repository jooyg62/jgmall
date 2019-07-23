package com.cafe24.jgmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jgmall.repository.AdminOrderDao;
import com.cafe24.jgmall.vo.OrderProductVo;
import com.cafe24.jgmall.vo.OrderVo;

@Service
public class AdminOrderService {
	
	@Autowired
	private AdminOrderDao adminOrderDao;

	public List<OrderVo> getOrderList() {
		List<OrderVo> productList = adminOrderDao.selectOrderList();
		return productList;
	}

	public List<OrderProductVo> getOrderProductList(Long orderNo) {
		List<OrderProductVo> orderProductList = adminOrderDao.selectOrderProductList(orderNo);
		return orderProductList;
	}
	
}
