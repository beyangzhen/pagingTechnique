package com.pagingTechnique.cn;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import com.pagingTechnique.cn.domain.QueryInfo;

public class BeanUtilTest {

	@Test
	public void test(){
		QueryInfo qinfo = new QueryInfo();
		try {
			Map<String, String[]> map = new HashMap<String, String[]>();
			map.put("currentPage", new String[] {"1","2"});
			BeanUtils.populate(qinfo, map);
			System.out.println(qinfo);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
