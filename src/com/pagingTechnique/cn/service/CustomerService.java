package com.pagingTechnique.cn.service;

import com.pagingTechnique.cn.domain.PageBean;
import com.pagingTechnique.cn.domain.QueryInfo;

public interface CustomerService {

	PageBean query(QueryInfo qinfo);

}
