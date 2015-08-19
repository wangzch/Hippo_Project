package com.hippo.service;

import java.util.ArrayList;
import java.util.Set;

import com.hippo.vo.Permission;
import com.hippo.vo.Role;
import com.hippo.vo.User;

public interface IUserService {
	
	//ID查询User信息
    public User getUserById(int userId);  
    
	//根据登录用户名查询User
    public User getUserByName(String userName);  
    
	//根据登录用户id查询role
    public ArrayList<Role> getRoleByUserId(int userId);  
    
	//返回角色名称
    public Set<String> getRoleNameFromRoleArray(ArrayList<Role> roleArray);  
    
	//根据登录用户role_id查询权限
    public ArrayList<Permission> getPermissionArrayByRoleId(int role_id);

	//根据登录用户role_id查询权限
    public ArrayList<User> getAllUser();
    
	//返回权限名称
    public Set<String> getPermissionNameFromArray(ArrayList<Permission> permissionArray);
    
    //保存注册信息
    public void saveRegisterUserInfo(User user);
    
    //删除用户
    public void deleteUserInfo(int id);
    
    //修改用户邮箱，姓名
    public void updateUserEmailInfo(User user);
}
