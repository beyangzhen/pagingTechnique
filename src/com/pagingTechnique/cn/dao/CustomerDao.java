package com.pagingTechnique.cn.dao;

import com.pagingTechnique.cn.domain.QueryInfo;
import com.pagingTechnique.cn.domain.QueryResult;

public interface CustomerDao {

	QueryResult query(QueryInfo qinfo);

}
