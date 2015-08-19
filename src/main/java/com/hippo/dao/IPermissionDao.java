package com.hippo.dao;

import java.util.ArrayList;

import com.hippo.vo.Permission;

public interface IPermissionDao {
	public int deleteByPrimaryKey(Integer id);

    public int insert(Permission record);

    public int insertSelective(Permission record);

    public Permission selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(Permission record);

    public int updateByPrimaryKey(Permission record);
    
    public ArrayList<Permission> getPermissionByRoleId(int role_id);
}