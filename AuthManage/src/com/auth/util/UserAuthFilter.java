/**
 * @filename UserAuthFilter.java
 * @author lg
 * @date 2018年7月9日 上午11:09:01
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
/**
 * 权限过滤器
 * @author lg
 * 
 */
public class UserAuthFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest requ, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("UserAuthFilter ............");
		HttpServletRequest request=(HttpServletRequest)requ; 
		//获取请求路径
		String path=request.getContextPath();
		String url=request.getServletPath();
		//request.getRequestURI();//部分
		if(url.endsWith(".action")){
			//1、获取session中用户对象
			Object obj=request.getSession().getAttribute("users");
			if(obj==null && url.indexOf("validCode.action")!=-1 && url.indexOf("login.action")!=-1){
				//未登录或登录超时,返回登录页面
				//没有登录
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().println("<script>alert('请登录！');location.href='"+request.getContextPath()+"/pages/login.jsp';</script>");
				return;
			}else{
				//已登录
				//获取当前用户拥有的列表权限
				String authUrl=request.getSession().getAttribute("authUrl")+"";
				if(!(authUrl.indexOf(url)!=-1)){//没有权限
					//判断当前请求url是否在用户的列表权限中
					response.setContentType("text/html; charset=UTF-8");
					response.getWriter().println("<script>alert('非法访问！');location.href='"+request.getContextPath()+"/pages/login.jsp';</script>");
					return;
				}
				
			}
		}
	
		//正常逻辑过滤器向下走
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
