<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>编号</th>
				<th>客户姓名</th>
				<th>性名</th>
				<th>生日</th>
				<th>手机</th>
				<th>电子邮件</th>
				<th>客户爱好</th>
				<th>客户类型</th>
				<th>备注</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="bean" items="${requestScope.pageBean.list }">
				<tr>
					<td>${bean.id }</td>
					<td>${bean.name }</td>
					<td>${bean.gender}</td>
					<td>${bean.birthday }</td>
					<td>${bean.cellphone }</td>
					<td>${bean.email }</td>
					<td>${bean.preference }</td>
					<td>${bean.type }</td>
					<td>${bean.description }</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
	<div>
		<br/>
		<span>共[${pageBean.totalRecord }]条</span>
		<span>每页[${pageBean.pageSize }]条</span>
		<span>当前第[${pageBean.currentPage }]页</span>
		<span>共[${pageBean.totalPage }]页</span>
		
		<!-- url为空，代表当前页面 -->
		<a href="?currentPage=${pageBean.prevPage }">上一页</a>
		
		<!-- 当前在第一页 -->
		<c:if test="${pageBean.currentPage == 1 }">
			<c:if test="${pageBean.currentPage <= pageBean.totalPage }">
				<a href="?currentPage=${pageBean.currentPage }">${pageBean.currentPage }</a>
			</c:if>
			<c:if test="${pageBean.currentPage+1 <= pageBean.totalPage }">
				<a href="?currentPage=${pageBean.currentPage+1 }">${pageBean.currentPage+1 }</a>
			</c:if>
			<c:if test="${pageBean.currentPage+2 <= pageBean.totalPage }">
				<a href="?currentPage=${pageBean.currentPage+2 }">${pageBean.currentPage+2 }</a>
			</c:if>
			<c:if test="${pageBean.currentPage+2 < pageBean.totalPage }">
				...
				<a href="?currentPage=${pageBean.totalPage }">${pageBean.totalPage }</a>
			</c:if>
		</c:if>
		
		<!-- 当前在中间页 -->
		<c:if test="${pageBean.currentPage != 1 && pageBean.currentPage != pageBean.totalPage }">
			<c:if test="${pageBean.currentPage-1 > 1 }">
				<a href="?currentPage=1">1</a>
				...
			</c:if>
			<c:if test="${pageBean.currentPage-1 >= 1 }">	
				<a href="?currentPage=${pageBean.currentPage-1 }">${pageBean.currentPage-1 }</a>
			</c:if>
			<c:if test="${pageBean.currentPage <= pageBean.totalPage }">
				<a href="?currentPage=${pageBean.currentPage }">${pageBean.currentPage }</a>
			</c:if>
			<c:if test="${pageBean.currentPage+1 <= pageBean.totalPage }">
				<a href="?currentPage=${pageBean.currentPage+1 }">${pageBean.currentPage+1 }</a>
			</c:if>
			<c:if test="${pageBean.currentPage+1 < pageBean.totalPage }">
				...
				<a href="?currentPage=${pageBean.totalPage }">${pageBean.totalPage }</a>
			</c:if>
		</c:if>
		
		<!-- 当前在最后一页 -->
		<c:if test="${pageBean.currentPage == pageBean.totalPage && pageBean.currentPage != 1 }">
			<c:if test="${pageBean.currentPage > 3 }">
				<a href="?currentPage=1">1</a>
				...
			</c:if>
			<c:if test="${pageBean.currentPage-2 >= 1 }">
				<a href="?currentPage=${pageBean.currentPage-2 }">${pageBean.currentPage-2 }</a>
			</c:if>
			<c:if test="${pageBean.currentPage-1 >= 1 }">
				<a href="?currentPage=${pageBean.currentPage-1 }">${pageBean.currentPage-1 }</a>
			</c:if>
			<c:if test="${pageBean.currentPage <= pageBean.totalPage }">
				<a href="?currentPage=${pageBean.currentPage }">${pageBean.currentPage }</a>
			</c:if>
		</c:if>
		
		<a href="?currentPage=${pageBean.nextPage }">下一页</a>
		
	</div>
</body>
</html>