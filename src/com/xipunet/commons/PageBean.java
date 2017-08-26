package com.xipunet.commons;

import java.util.List;


public class PageBean<T> {
	private int currentPage = 1; //当前页，默认第一页
	private int pageCount = 12;   //每页显示数据条数（页大小），默认四条
	private int totalCount;      //总记录数   
	private int totalPage;       //总页数
	private List<T> pageData;    //每页的数据
	
	public int getTotalPage(){
		 	totalPage = totalCount / pageCount;
		return totalCount % pageCount == 0 ? totalPage : totalPage +1;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getPageData() {
		return pageData;
	}
	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}
	
	


	
}
