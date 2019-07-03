package com.auth.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.auth.entity.Role;
import com.auth.service.PermissionService;
import com.auth.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;
	
	@RequestMapping("/list")
	public ModelAndView showRoleList(){
		List list=roleService.getAllRoles();
		
		ModelAndView mav=new ModelAndView("role-list");
		mav.addObject("roles", list);
		return mav;
	}
	

	@RequestMapping("/listperms")
	@ResponseBody
	public List getPerms(){
		return permissionService.getAllPermissions();
	}
	

	@RequestMapping("/add")
	@ResponseBody
	public Role addRole(Role role,Long...permIds){
		roleService.addRole(role, permIds);
		return role;
	}
	

	@RequestMapping("/delete")
	@ResponseBody
	public void deleteRole(Long roleId){
		roleService.deleteRole(roleId);
	}
	

	@RequestMapping("/deletemore")
	@ResponseBody
	public void deleteMoreRoles(Long...roleIds){
		roleService.deleteMoreRoles(roleIds);
	}
	
	@RequestMapping("/showroleperms")
	@ResponseBody
	public List showRolePerms(Long roleId){
		return permissionService.getPermissionsByRoleId(roleId);
	}
	

	@RequestMapping("/getrole")
	@ResponseBody
	public Role getRoleById(Long roleId){
		return roleService.getRoleById(roleId);
	}
	

	@RequestMapping("/updaterole")
	@ResponseBody()
	public void updateRole(Role role,Long...permIds){
		roleService.updateRole(role,permIds);
	}
}
