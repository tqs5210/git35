/**
 * @filename AuthInfoMapper.java
 * @author lg
 * @date 2017年10月26日 下午1:47:49
 * @version 1.0
 * Copyright (C) 2017 
 */

package com.auth.mapper;

import com.auth.entity.Role;

public interface AuthInfoMapper {
	/**
	 * 添加角色
	 * @param role
	 */
	void addRole(Role role);
	/**
	 * 
	 * @param roleId
	 */
	void deleteRole(Long roleId);
	/**
	 * 
	 * @param roleId
	 * @return
	 */
	Role findById(Long roleId);

}
