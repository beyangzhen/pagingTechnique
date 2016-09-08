package com.wxhledu.cn.dao;

import java.util.List;

import org.junit.Test;

import com.wxhledu.cn.dao.impl.CustomerDaoImpl;
import com.wxhledu.cn.domain.Customer;
import com.wxhledu.cn.domain.QueryInfo;
import com.wxhledu.cn.domain.QueryResult;

public class CustomerDaoTest {
	
	private CustomerDao dao = new CustomerDaoImpl();

	@Test
	public void testPageQuery() {
		QueryInfo qinfo = new QueryInfo();
		qinfo.setStartIndex(0);
		qinfo.setPageSize(10);
		QueryResult result = dao.query(qinfo );
		List<Customer> list = result.getList();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		System.out.println(result.getCount());
	}

}
