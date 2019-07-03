/**
 *@comment  持久化层用户接口
 *@author tqs521
 *@date 2019年5月29日 上午9:23:29
 *@modifyUser tqs521
 *@modifyDate 2019年5月29日 上午9:23:29
 */
package com.auth.mapper;

import java.util.HashMap;
import java.util.List;

import com.auth.entity.AuthInfo;
import com.auth.entity.UserInfo;

public interface UserInfoMapper {
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
