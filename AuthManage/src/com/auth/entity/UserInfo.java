/**
 * @filename UserInfo.java
 * @author lg
 * @date 2018年1月11日 下午4:18:23
 * @version 1.0
 * Copyright (C) 2018 
 */

package com.auth.entity;

import java.io.Serializable;

/**
 * 用户实体类
 * @author lg	
 * @date  2018-01-11
 */
public class UserInfo implements Serializable{
	private static final long serialVersionUID = 1103859731870892052L;
	//用户id
	private Integer userId;
	//用户组id
	private Integer groupId;
	//用户昵称
	private String nickName;
	//用户code
	private String userCode;
	//用户密码
	private String userPwd; 
	//用户状态，0 未审核 、1 已审核
	private String userState; 
	//删除状态，0 正常、 1 已删除
	private String isDelete; 
	//创建人
	private Integer createBy; 
	//创建时间
	private String createTime;
	
	private String startTime;
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	private String endTime;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public Integer getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	} 

	  
	
}
