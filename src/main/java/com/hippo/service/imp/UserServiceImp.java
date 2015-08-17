package com.hippo.service.imp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hippo.dao.IRoleDao;
import com.hippo.dao.IUserDao;
import com.hippo.dao.IPermissionDao;
import com.hippo.service.IUserService;
import com.hippo.vo.Permission;
import com.hippo.vo.Role;
import com.hippo.vo.User;

@Service("userService") //Spring创建实例
@Transactional
public class UserServiceImp implements IUserService{

	@Resource
	private IUserDao userDao;
	@Resource
	private IRoleDao roleDao;
	@Resource
	private IPermissionDao permissionDao;

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		//可添加多个Dao类和方法组成一个Service业务方法
		return this.userDao.selectByPrimaryKey(userId);
	}
	
	@Override
	public User getUserByName(String userName) {
		// TODO Auto-generated method stub
		//可添加多个Dao类和方法组成一个Service业务方法
		return this.userDao.selectByName(userName);
	}

	@Override
	public ArrayList<Role> getRoleByUserId(int userId) {
		// TODO Auto-generated method stub
		return this.roleDao.getRoleByUserId(userId);
	}

	@Override
	public Set<String> getRoleNameFromRoleArray(ArrayList<Role> roleArray) {
        Set<String> set=new HashSet<String>();  
        for (Role role : roleArray) {  
            set.add(role.getRoleName());  
        }  
        return set;  
	}

	@Override
	public ArrayList<Permission> getPermissionArrayByRoleId(int role_id) {
		// TODO Auto-generated method stub
		return this.permissionDao.getPermissionByRoleId(role_id);
	}

	@Override
	public Set<String> getPermissionNameFromArray(ArrayList<Permission> PermissionArray) {
		// TODO Auto-generated method stub
        Set<String> set=new HashSet<String>();  
        for (Permission permission : PermissionArray) {  
            set.add(permission.getPermissionName());  
        }  
        return set; 
	}

	@Override
	public ArrayList<User> getAllUser() {
		// TODO Auto-generated method stub
		return this.userDao.getAllUser();
	}

	@Override
	public void saveRegisterUserInfo(User user) {
		// TODO Auto-generated method stub
		userDao.insert(user);
	}

	@Override
	public void deleteUserInfo(int id) {
		// TODO Auto-generated method stub
		userDao.deleteByPrimaryKey(id);
	}

	@Override
	public void updateUserEmailInfo(User user) {
		// TODO Auto-generated method stub
		userDao.updateByPrimaryKeySelective(user);
	}
}
