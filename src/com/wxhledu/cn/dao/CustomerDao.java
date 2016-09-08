package com.wxhledu.cn.dao;

import com.wxhledu.cn.domain.QueryInfo;
import com.wxhledu.cn.domain.QueryResult;

public interface CustomerDao {

	QueryResult query(QueryInfo qinfo);

}
