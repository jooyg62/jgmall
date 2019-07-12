package com.cafe24.jgmall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cafe24.jgmall.vo.FileVo;
import com.cafe24.jgmall.vo.PageVo;
import com.cafe24.jgmall.vo.ProductVo;
import com.cafe24.jgmall.vo.UserVo;
import com.cafe24.jgmall.vo.api.ResBasketProdcutListVo;
import com.cafe24.jgmall.vo.api.ResProductInfo;

@Service
public class ShopService {

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
	public List<ProductVo> getProductList(int pageNo, String kwd) {
		List<ProductVo> productList = new ArrayList<ProductVo>();
		
		ProductVo productVo1 = new ProductVo();
		productVo1.setProductNm("오리발");
		productVo1.setSellFl("Y");
		productVo1.setDisplaySt("Y");
		productVo1.setRegDate("20180702");
		productVo1.setSellPrc(5300);
		productVo1.setSalePrc(3500);
		
		FileVo fileVo1 = new FileVo();
		fileVo1.setSaveUrl("/images/orifoot.jpg");
		
		List<FileVo> fileList = productVo1.getFileList();
		fileList.add(fileVo1);
		
		
		ProductVo productVo2 = new ProductVo();
		productVo1.setProductNm("오리인형");
		productVo1.setSellFl("N");
		productVo1.setDisplaySt("Y");
		productVo1.setRegDate("20190411");
		productVo1.setSellPrc(10300);
		productVo1.setSalePrc(0);
		
		FileVo fileVo2 = new FileVo();
		fileVo1.setSaveUrl("/images/orifoot.jpg");
		
		List<FileVo> fileList2 = productVo1.getFileList();
		fileList2.add(fileVo2);
		
		productList.add(productVo1);
		productList.add(productVo2);
		
		return productList;
	}

	/**
	 *	상품리스트 페이징 처리 
	 */
	public PageVo getPagingData(int pageNo) {
		return null;
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
