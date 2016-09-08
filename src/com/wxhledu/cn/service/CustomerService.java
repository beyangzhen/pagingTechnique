package com.wxhledu.cn.service;

import com.wxhledu.cn.domain.PageBean;
import com.wxhledu.cn.domain.QueryInfo;

public interface CustomerService {

	PageBean query(QueryInfo qinfo);

}
