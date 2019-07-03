package com.auth.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.auth.entity.Permission;
import com.auth.service.PermissionService;

@Controller
@RequestMapping("/perm")
public class PermissionController {
	@Autowired
	private PermissionService permissionService;
	
	@RequestMapping("/list")
	public ModelAndView showRoleList(){
		List<Permission> list=permissionService.getAllPermissions();
		
		ModelAndView mav=new ModelAndView("permission-list");
		mav.addObject("perms", list);
		
		return mav;
	}
	

	@RequestMapping("/add")
	@ResponseBody
	public Permission addPermission(Permission permission){
		permissionService.addPermission(permission);
		return permission;
	}
	

	@RequestMapping("/delete")
	@ResponseBody
	public void deletePermission(Long permId){
		permissionService.deletePermission(permId);
	}
	

	@RequestMapping("/deletemore")
	@ResponseBody
	public void deleteMorePerms(Long...permIds){
		permissionService.deleteMorePermissions(permIds);
	}
	

	@RequestMapping("/getperm")
	@ResponseBody
	public Permission getPermById(Long permId){
		return permissionService.findById(permId);
	}
	

	@RequestMapping("/update")
	@ResponseBody
	public void updatePermission(Permission permission){
		permissionService.updatePermission(permission);
	}
}
