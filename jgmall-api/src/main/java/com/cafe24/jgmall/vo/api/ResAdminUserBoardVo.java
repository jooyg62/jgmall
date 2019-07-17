package com.cafe24.jgmall.vo.api;

import java.util.ArrayList;
import java.util.List;

import com.cafe24.jgmall.vo.UserVo;

public class ResAdminUserBoardVo {
	Integer joinTodayCount;
	Integer totalUserCount;
	List<UserVo> userInfoList = new ArrayList<UserVo>();
	public Integer getJoinTodayCount() {
		return joinTodayCount;
	}
	public void setJoinTodayCount(Integer joinTodayCount) {
		this.joinTodayCount = joinTodayCount;
	}
	public Integer getTotalUserCount() {
		return totalUserCount;
	}
	public void setTotalUserCount(Integer totalUserCount) {
		this.totalUserCount = totalUserCount;
	}
	public List<UserVo> getUserInfoList() {
		return userInfoList;
	}
	public void setUserInfoList(List<UserVo> userInfoList) {
		this.userInfoList = userInfoList;
	}
	@Override
	public String toString() {
		return "ResUserBoardVo [joinTodayCount=" + joinTodayCount + ", totalUserCount=" + totalUserCount
				+ ", userInfoList=" + userInfoList + "]";
	}
}
