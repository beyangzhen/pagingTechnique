package com.wxhledu.cn.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.wxhledu.cn.domain.PageBean;
import com.wxhledu.cn.domain.QueryInfo;
import com.wxhledu.cn.service.CustomerService;
import com.wxhledu.cn.service.impl.CustomerServiceImpl;

/**
 * MVC：控制器作用，将用户请求的数据-》页面对象 --》service执行查询 -》封装的页面信息-》request ==》Dispacter
 */
public class CustomersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CustomerService service = new CustomerServiceImpl();

    public CustomersServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// BeanUtils工具
		QueryInfo qinfo = new QueryInfo();
		try {
			Map<String, String[]> map = request.getParameterMap();
			BeanUtils.populate(qinfo, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		PageBean bean = service.query(qinfo);
		request.setAttribute("pageBean", bean);
		// 转发：为了使点击上下页时，保证刷新的还是跳转前的页面（即：重新service.query()查询数据）
		request.getRequestDispatcher("/WEB-INF/customer/list.jsp").forward(request, response);
	}

}
