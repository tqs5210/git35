/**
 * @filename UserFilter.java
 * @author lg
 * @date 2018年1月12日 上午8:59:43
 * @version 1.0
 * Copyright (C) 2018 
 */

package com.auth.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

/**
 * 用户过滤器，用于过滤权限
 * @author lg
 * @date 2018-01-12
 */
public class UserFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		//1、获取session中用户信息
		HttpServletRequest  request=(HttpServletRequest)req;//强制类型转换
		Object obj=request.getSession().getAttribute("sessionUser");
		//获取当前请求的地址
		String uri=request.getRequestURI();
		if(uri.endsWith(".action")){//针对动态请求进行处理
			if(obj==null && !uri.endsWith("tologin.action") && !uri.endsWith("validCode.action")){//没有登录或session超时		
				res.setContentType("text/html; charset=UTF-8");
				res.getWriter().println("<script>alert('请登录！');location.href='"+request.getContextPath()+"/pages/login.jsp';</script>");
				return ;
			}else{
				if(!uri.endsWith("tologin.action") && !uri.endsWith("validCode.action")){
					//说明已经登录
					//权限验证
					String domain=request.getContextPath()+"/";//域名
					String actionUrl=request.getSession().getAttribute("buttonUri")+"";//获取用户权限
					//删除uri中包含的域名
					uri=uri.replace(domain, "");
					if(!(actionUrl.indexOf(uri)!=-1)){
						//当前用户没有此权限
						res.setContentType("text/html; charset=UTF-8");
						res.getWriter().println("<script>alert('非法请求！');location.href='"+request.getContextPath()+"/pages/error.jsp';</script>");
						return ;
					}
			}
		  }
		}
		chain.doFilter(req, res);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
