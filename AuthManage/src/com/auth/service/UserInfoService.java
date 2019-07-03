/**
 * @filename UserInfoService.java
 * @author lg
 * @date 2018年1月11日 下午5:03:58
 * @version 1.0
 * Copyright (C) 2018 
 */

package com.auth.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.auth.entity.AuthInfo;
import com.auth.entity.UserInfo;

/**
 * 用户管理业务接口
 * @author lg
 * @date  2018-01-11
 */
public interface UserInfoService {
	/**
	 * 用户登录接口	
	 * @param user 用户对象
	 * @return 用户对象
	 * @author lg
	 * @date  2018-01-11
	 */
	public UserInfo login(UserInfo user);
	
	/**
	 * 查询用户拥有的权限
	 * @comment 
	 * @param map
	 * @return
	 * @version 1.0
	 */
	public  List<AuthInfo> getUserAuth(HashMap map);
	/**
	 * @comment 用户列表查询
	 * @param map
	 * @return
	 * @version 1.0
	 */
	public  List<UserInfo> findAll(HashMap map);
	/**
	 * @comment  分页查询用户总条数
	 * @param user
	 * @return
	 * @version 1.0
	 */
	public int getUserCount(UserInfo user);
}
