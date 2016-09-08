package com.wxhledu.cn.domain;

import java.util.List;

public class QueryResult {

	/**
	 * 查询的所有记录行
	 */
	private List<Customer> list;
	
	/**
	 * 记录行的总数
	 */
	private int count;
	
	public QueryResult() {
	}

	public List<Customer> getList() {
		return list;
	}

	public void setList(List<Customer> list) {
		this.list = list;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "QueryResult [list=" + list + ", count=" + count + "]";
	}
	
}
