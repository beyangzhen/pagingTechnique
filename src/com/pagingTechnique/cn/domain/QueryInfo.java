package com.pagingTechnique.cn.domain;

/**
 * 页面信息
 * @author wxhl
 *
 */
public class QueryInfo {

	/**
	 * 当前页面
	 */
	private int currentPage = 1;

	/**
	 * 页面展示条数
	 */
	private int pageSize = 5;

	/**
	 * 开始页面
	 */
	private int startIndex;

	public QueryInfo() {
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartIndex() {
		//TODO 
		this.startIndex = this.pageSize * (this.currentPage-1);
		
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	@Override
	public String toString() {
		return "QueryInfo [currentPage=" + currentPage + ", pageSize=" + pageSize + ", startIndex=" + startIndex + "]";
	}

}
