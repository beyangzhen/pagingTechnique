package com.wxhledu.cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wxhledu.cn.dao.CustomerDao;
import com.wxhledu.cn.domain.Customer;
import com.wxhledu.cn.domain.QueryInfo;
import com.wxhledu.cn.domain.QueryResult;
import com.wxhledu.cn.util.JdbcUtil;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public QueryResult query(QueryInfo qinfo) {
		QueryResult result = new QueryResult();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		try {
			// 获取连接
			connection = JdbcUtil.getConnection();
			String sql = "select * from t_customer limit ?, ?";
			// 创建pstmt对象
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, qinfo.getStartIndex());
			pstmt.setInt(2, qinfo.getPageSize());
			// 执行sql
			resultSet = pstmt.executeQuery();
			List<Customer> list = new ArrayList<>();
			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setId(resultSet.getLong("id"));
				customer.setName(resultSet.getString("name")); 
				customer.setGender(resultSet.getString("gender")); 
				customer.setBirthday(resultSet.getString("birthday")); 
				customer.setCellphone(resultSet.getString("cellphone")); 
				customer.setEmail(resultSet.getString("email")); 
				customer.setPreference(resultSet.getString("preference")); 
				customer.setType(resultSet.getString("type")); 
				customer.setDescription(resultSet.getString("description")); 
				list.add(customer);
			}
			
			result.setList(list );
			resultSet.close();
			
			resultSet = pstmt.executeQuery("select count(*) from t_customer");
			while (resultSet.next()) {
				result.setCount(resultSet.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放连接
			JdbcUtil.release(connection, pstmt, resultSet);
		}
		return result;
	}

}
