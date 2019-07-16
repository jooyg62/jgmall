package com.cafe24.jgmall.vo;

import java.util.List;

/*
#####################################################################################
#   cur_paging_num              :   현재 보고 있는 페이지 넘버
#   tot_board_count             :   전체 게시물 수
#   page_per_size               :   페이지당 게시물 개수
#   tot_paging_size             :   최대로 넘길 수 있는 페이지 넘버
#   paging_num_size             :   화면에 몇개의 페이징을 줄 것 인지.(1 2 3 4 5)
#   start_view_paging_num       :   시작 페이징 번호
#   is_pre_page                 :   이전 페이징으로 갈수 있는지 여부
#   is_after_page               :   이후 페이징으로 갈수 있는지 여부
#   paging_list                 :   페이징 번호 리스트 (<< 1 2 3 4 5 >>)
######################################################################################
*/
public class PageVo {
	Integer curPagingNum;
	Integer totBoardCount;
	Integer pagePerSize;
	Integer totPagingSize;
	Integer pagingNumSize;
	Integer startViewPagingNum;
	Boolean isPrePage;
	Boolean isAfterPage;
	List<Integer> pagingList;
	public Integer getCurPagingNum() {
		return curPagingNum;
	}
	public void setCurPagingNum(Integer curPagingNum) {
		this.curPagingNum = curPagingNum;
	}
	public Integer getTotBoardCount() {
		return totBoardCount;
	}
	public void setTotBoardCount(Integer totBoardCount) {
		this.totBoardCount = totBoardCount;
	}
	public Integer getPagePerSize() {
		return pagePerSize;
	}
	public void setPagePerSize(Integer pagePerSize) {
		this.pagePerSize = pagePerSize;
	}
	public Integer getTotPagingSize() {
		return totPagingSize;
	}
	public void setTotPagingSize(Integer totPagingSize) {
		this.totPagingSize = totPagingSize;
	}
	public Integer getPagingNumSize() {
		return pagingNumSize;
	}
	public void setPagingNumSize(Integer pagingNumSize) {
		this.pagingNumSize = pagingNumSize;
	}
	public Integer getStartViewPagingNum() {
		return startViewPagingNum;
	}
	public void setStartViewPagingNum(Integer startViewPagingNum) {
		this.startViewPagingNum = startViewPagingNum;
	}
	public Boolean getIsPrePage() {
		return isPrePage;
	}
	public void setIsPrePage(Boolean isPrePage) {
		this.isPrePage = isPrePage;
	}
	public Boolean getIsAfterPage() {
		return isAfterPage;
	}
	public void setIsAfterPage(Boolean isAfterPage) {
		this.isAfterPage = isAfterPage;
	}
	public List<Integer> getPagingList() {
		return pagingList;
	}
	public void setPagingList(List<Integer> pagingList) {
		this.pagingList = pagingList;
	}
	@Override
	public String toString() {
		return "PageVo [curPagingNum=" + curPagingNum + ", totBoardCount=" + totBoardCount + ", pagePerSize="
				+ pagePerSize + ", totPagingSize=" + totPagingSize + ", pagingNumSize=" + pagingNumSize
				+ ", startViewPagingNum=" + startViewPagingNum + ", isPrePage=" + isPrePage + ", isAfterPage="
				+ isAfterPage + ", pagingList=" + pagingList + "]";
	}
}
