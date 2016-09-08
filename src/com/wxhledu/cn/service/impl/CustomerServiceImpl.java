package com.wxhledu.cn.service.impl;

import com.wxhledu.cn.dao.CustomerDao;
import com.wxhledu.cn.dao.impl.CustomerDaoImpl;
import com.wxhledu.cn.domain.PageBean;
import com.wxhledu.cn.domain.QueryInfo;
import com.wxhledu.cn.domain.QueryResult;
import com.wxhledu.cn.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao dao = new CustomerDaoImpl();

	@Override
	public PageBean query(QueryInfo qinfo) {
		QueryResult result = dao.query(qinfo);
		
		PageBean pageBean = new PageBean();
		pageBean.setList(result.getList());
		pageBean.setPageSize(qinfo.getPageSize());
		pageBean.setCurrentPage(qinfo.getCurrentPage());
		pageBean.setTotalRecord(result.getCount());
		
		return pageBean;
	}

}
