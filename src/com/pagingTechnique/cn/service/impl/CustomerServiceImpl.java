package com.pagingTechnique.cn.service.impl;

import com.pagingTechnique.cn.dao.CustomerDao;
import com.pagingTechnique.cn.dao.impl.CustomerDaoImpl;
import com.pagingTechnique.cn.domain.PageBean;
import com.pagingTechnique.cn.domain.QueryInfo;
import com.pagingTechnique.cn.domain.QueryResult;
import com.pagingTechnique.cn.service.CustomerService;

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
