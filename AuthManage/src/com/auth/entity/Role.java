package com.auth.entity;

import java.io.Serializable;
/**
 * 
 * @author lg
 *
 */
public class Role implements Serializable{
	//½ÇÉ«id
	private Long roleId;
	//½ÇÉ«Ãû³Æ
	private String roleName;
	private String roleDesc;
	private String roleCode;
	
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
}
