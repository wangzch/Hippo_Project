package com.hippo.dao;

import java.util.ArrayList;

import com.hippo.vo.Permission;

public interface IPermissionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    ArrayList<Permission> getPermissionByRoleId(int role_id);
}