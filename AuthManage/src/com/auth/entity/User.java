package com.auth.entity;

import java.io.Serializable;
/**
 * 用户管理
 * @author lg
 * @date 2017-10-10
 */
public class User implements Serializable{
	private Long userId;
	private String userName;
	private String password;
	private String passwordSalt;
	
	public User() {
		
	}
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordSalt() {
		return passwordSalt;
	}
	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}
}
