package com.cafe24.jgmall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jgmall.repository.ShopDao;
import com.cafe24.jgmall.vo.FileVo;
import com.cafe24.jgmall.vo.ProductVo;
import com.cafe24.jgmall.vo.UserVo;
import com.cafe24.jgmall.vo.api.ResBasketProdcutListVo;
import com.cafe24.jgmall.vo.api.ResProductInfo;

@Service
public class ShopService {
	
	@Autowired
	ShopDao shopDao;

	public UserVo userLogin(UserVo userVo) {
		if("jgseo".equals(userVo.getUserId()) && "!@jgseo450".equals(userVo.getPassword())) {
			userVo.setNo(1L);
			userVo.setUserNm("서장규");
			userVo.setJoinDate("2019.07.10");
			userVo.setTelNum("010-4115-6736");
			userVo.setGender("M");
			userVo.setAge(27);
		} else {
			return null;
		}
		
		return userVo;
	}

	public Boolean existId(String id) {
		return "jgseo".equals(id) ? true : false;
	}

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
	public ResProductInfo getProductInfo(Long no) {
		ResProductInfo resProductInfo = new ResProductInfo();
		resProductInfo.setProductNm("오리인형");
		
		if(no == 9999999L) {
			return null;
		}
		
		return resProductInfo;
	}

	/**
	 * 상품 담기
	 * @param no
	 * @return
	 */
	public Boolean addProductInBasket(Long no) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * 장바구니 조회
	 * @param no
	 * @return
	 */
	public ResBasketProdcutListVo getBasketProductList(Long no) {
		ResBasketProdcutListVo result = new ResBasketProdcutListVo();
		result.setAddPrc(0);
		result.setImgType("T");
		result.setOptionFl("N");
		result.setOptionNm("");
		result.setProductNm("오리인형");
		result.setSalePrc(0);
		result.setSaveUrl("/images/oridoll.jpg");
		result.setSellPrc(10300);
		result.setStockAmt(3);
		
		return result;
	}

	public Boolean removeProductInBasket(Long no) {
		return true;
	}
	
}
