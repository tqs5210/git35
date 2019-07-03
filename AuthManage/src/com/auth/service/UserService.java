package com.auth.service;

import java.util.List;
import java.util.Set;
import com.auth.entity.Navigation;
import com.auth.entity.User;

public interface UserService {
	void addUser(User user,Long...roleIds);//����û�
	void deleteUser(Long userId);//ɾ���û�
	void deleteMoreUsers(Long...userIds);//����ɾ���û�
	User getUserByUserName(String userName);//����û����ȡ�û�
	List<User> getAllUsers();//��ȡ�����û�
	
	void updateUserRoles(Long userId,Long...roleIds);//����û���ɫ����
	
	Set<String> findRolesByUserName(String userName);//����û����ȡ�û����н�ɫ
	Set<String> findPermissionsByUserName(String userName);//����û����ȡ�û�����Ȩ��
	User getUserInfo(User user);
	List<Navigation> getNavigationBar(String userName);//��ȡ����������
}
