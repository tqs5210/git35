<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
总 ${page.totalNum} 条&nbsp; 
每页 ${page.page} 条&nbsp; 
总 ${page.totalPage} 页 &nbsp; 
第 ${page.currNo} 页&nbsp; 
<c:if test="${page.currNo==1}">首页</c:if>
<c:if test="${page.currNo!=1}"><a href="${pageContext.request.contextPath}/${page.url}?${page.params}&currNo=1">首页</a></c:if>
&nbsp;
<c:if test="${page.currNo==1}">上一页</c:if>
<c:if test="${page.currNo!=1}"><a href="${pageContext.request.contextPath}/${page.url}?${page.params}&currNo=${page.currNo-1}">上一页</a></c:if>
&nbsp;
<c:if test="${page.currNo==page.totalPage}">下一页</c:if>
<c:if test="${page.currNo!=page.totalPage}"><a href="${pageContext.request.contextPath}/${page.url}?${page.params}&currNo=${page.currNo+1}">下一页</a></c:if>
&nbsp;
<c:if test="${page.currNo==page.totalPage}">尾页</c:if>
<c:if test="${page.currNo!=page.totalPage}"><a href="${pageContext.request.contextPath}/${page.url}?${page.params}&currNo=${page.totalPage}">尾页</a></c:if>
&nbsp;

 第<select onchange="location.href='${pageContext.request.contextPath}/${page.url}?${page.params}&currNo='+this.value">
	<c:forEach var="selectvalue" begin="1" end="${page.totalPage}" step="1">
		<option value="${selectvalue}" ${page.currNo eq selectvalue ?"selected='selected'":""}>
			${selectvalue}   
		</option>
	</c:forEach>
</select>
页 

每页
<select onchange="location.href='${pageContext.request.contextPath}/${page.url}?${page.params}&pageNum='+this.value">
	<option value="5">5</option>
	<option value="10">10</option>
	<option value="15">15</option>
	<option value="20">20</option>
</select>
条


