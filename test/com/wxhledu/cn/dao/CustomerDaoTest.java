package com.wxhledu.cn.dao;

import java.util.List;

import org.junit.Test;

import com.pagingTechnique.cn.dao.CustomerDao;
import com.pagingTechnique.cn.dao.impl.CustomerDaoImpl;
import com.pagingTechnique.cn.domain.Customer;
import com.pagingTechnique.cn.domain.QueryInfo;
import com.pagingTechnique.cn.domain.QueryResult;

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
