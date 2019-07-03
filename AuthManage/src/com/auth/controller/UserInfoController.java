/**
 * @filename UserInfoController.java
 * @author lg
 * @date 2018年1月11日 下午5:13:54
 * @version 1.0
 * Copyright (C) 2018 
 */

package com.auth.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.auth.entity.AuthInfo;
import com.auth.entity.UserInfo;
import com.auth.service.UserInfoService;
import com.auth.util.PageBean;

/**
 * 用户管理控制类
 * @author lg
 * @date  2018-01-11
 */
@Controller
public class UserInfoController {
	//注入用户service业务接口
	@Autowired
	UserInfoService userInfoService;
	
	/**
	 * 用户登录
	 * @param user 用户对象
	 * @return mod对象
	 */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,UserInfo user){
		UserInfo nuser=userInfoService.login(user);
		if(nuser!=null){//用户登录成功
			
			
	//用户列表分页		
			
	//1.查询用户总条数		
			userInfoService.login(user);		
			
			
			
			
			request.getSession().setAttribute("sessionUser", nuser);
			ModelAndView mod=new ModelAndView("index");
			return mod;
		}else{
			//登录失败
			ModelAndView mod=new ModelAndView("error");
			return mod;
		}
	}
	
	
	/**
	 * @comment 拼接用户列表查询请求参数
	 * @param user
	 * @return
	 * @version 1.0
	 */
	public String getParams(UserInfo user) {
		//拼接请求参数
		StringBuilder sb=new StringBuilder();	
		if(StringUtils.isNotBlank(user.getUserCode())){
			sb.append("&userCode=").append(user.getUserCode());
		}
		if(StringUtils.isNotBlank(user.getUserState())){
			sb.append("&userState=").append(user.getUserState());
		}
		 if(StringUtils.isNotBlank(user.getStartTime())){
			sb.append("&startTime=").append(user.getStartTime());
		}
		if(StringUtils.isNotBlank(user.getEndTime())){
			sb.append("&endTime=").append(user.getEndTime());
		}
		return sb.toString();	
		
	}	/**
	 * @comment 用户列表分页
	 * @param request
	 * @param user
	 * @return
	 * @version 1.0
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest request,UserInfo user){
		//每页显示条数
		String page=request.getParameter("page");
		int pageLimit=5;
		if(StringUtils.isNotBlank(page)){
			pageLimit=Integer.parseInt(page);
		}
		//当前页码
		String currNo=request.getParameter("currNo");
		int pageNum=1;
		if(StringUtils.isNotBlank(currNo)){
			pageNum=Integer.parseInt(currNo);
		}
		//1、查询用户总条数
		int totalCount=userInfoService.getUserCount(user);
		
		//2、分页查询用户列表 list
		HashMap map=new HashMap();
		map.put("user", user);
		PageBean pageBean=new PageBean(pageLimit, pageNum);
		map.put("page", pageBean);
		List<UserInfo> userList=userInfoService.findAll(map);
		//3、封装PageBean
		PageBean pb=new PageBean(pageLimit, totalCount, pageNum, userList, "/user/list.action", getParams(user));
		
		ModelAndView mod=new ModelAndView("user-list");
		mod.addObject("page", pb);
		return mod;
	}
}
