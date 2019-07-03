/**
 * @filename UserFilter.java
 * @author lg
 * @date 2017年10月31日 下午1:56:02
 * @version 1.0
 * Copyright (C) 2017 
 */

package com.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.auth.entity.User;

public class UserFilter implements Filter{

	public UserFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		//session中是否包含用户信息
	    HttpServletRequest req=(HttpServletRequest)request;
	    User user=(User)req.getSession().getAttribute("user");
	    //获取请求url
	    String uri=req.getRequestURI();
	    if(uri.endsWith(".action") && user==null){
	    	//当前用户没有登录
	    	response.setContentType("text/html; charset=UTF-8");
			response.getWriter().println("<script>alert('请登录！！');location.href='"+req.getContextPath()+"/pages/login.jsp';</script>");
			return; 
	    }else{
	    	if(uri.endsWith(".action")){
	    		String authInfos=req.getSession().getAttribute("authInfos")+"";
	    		if(authInfos.indexOf(uri)!=-1 ){ //login.action 、destory.action
		    		//包含此url权限
		    	}else{
		    		//不包含当前url,说明没有权限
		    		 response.setContentType("text/html;charset=UTF-8");
		           	 response.getWriter().println("<script>alert('非法请求！');location.href='"+req.getContextPath()+"/pages/login.jsp';</script>");
		           	 return ;
		    	}
	  	    }
	  	  }
	    //正常请求
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	
/*	
 <filter>
	<filter-name>userFilter</filter-name>
	<filter-class>com.util.UserFilter</filter-class>
</filter>
<filter-mapping>
	<filter-name>userFilter</filter-name>
	<url-pattern>/*</url-pattern>
</filter-mapping>

*/

}
