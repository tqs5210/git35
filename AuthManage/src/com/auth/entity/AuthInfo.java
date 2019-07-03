/**
 * @filename AuthInfo.java
 * @author lg
 * @date 2017年11月15日 上午11:45:20
 * @version 1.0
 * Copyright (C) 2017 
 */

package com.auth.entity;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author lg
 *
 */
public class AuthInfo {
	//权限主键id
	private int authId;
	//....
	//...
	//parentId 映射,子权限集合
	private List<AuthInfo> childList;
	public int getAuthId() {
		return authId;
	}
	public void setAuthId(int authId) {
		this.authId = authId;
	}
	public List<AuthInfo> getChildList() {
		return childList;
	}
	public void setChildList(List<AuthInfo> childList) {
		this.childList = childList;
	}
	
}
