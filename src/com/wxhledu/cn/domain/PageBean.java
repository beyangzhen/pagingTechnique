package com.wxhledu.cn.domain;

import java.util.List;

public class PageBean {

	/**
	 * 所有记录行
	 */
	private List<?> list;

	/**
	 * 总的记录条数
	 */
	private int totalRecord;

	/**
	 * 页大小
	 */
	private int pageSize;

	/**
	 * 总页数
	 */
	private int totalPage;

	/**
	 * 当前页数
	 */
	private int currentPage;

	/**
	 * 上一页
	 */
	private int prevPage;

	/**
	 * 下一页
	 */
	private int nextPage;

	/**
	 * 分布数目栏
	 */
	private int[] pageBar = new int[10];

	public PageBean() {
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		if (this.totalRecord % this.pageSize == 0) {
			// 求余为0，刚好占满最后一页
			totalPage = totalRecord / pageSize;
		} else {
			// 求余>0，最后一页未满
			totalPage = totalRecord / pageSize + 1;
		}
		
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPrevPage() {
		if (this.currentPage - 1 < 1) {
			this.prevPage = 1;
		} else {
			this.prevPage = this.currentPage - 1;
		}
		
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() { 
		if (this.currentPage + 1 > this.totalPage) {
			this.nextPage = this.totalPage;
		} else {
			this.nextPage = this.currentPage + 1;
		}
		
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int[] getPageBar() {
		return pageBar;
	}

	public void setPageBar(int[] pageBar) {
		//int[] pb = new int[10];
		//for(int i = 0; i<pageBar)
		this.pageBar = pageBar;
	}

}
