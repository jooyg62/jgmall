package com.cafe24.jgmall.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jgmall.admin.repository.AdminDao;
import com.cafe24.jgmall.admin.vo.api.ReqAdminLoginVo;
import com.cafe24.jgmall.admin.vo.api.ResAdminLoginVo;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao adminDao;

	public ResAdminLoginVo adminLogin(ReqAdminLoginVo reqAdminLoginVo) {
		ResAdminLoginVo resAdminLoginVo = adminDao.selectAdmin(reqAdminLoginVo);
		return resAdminLoginVo;
	}
	
}
