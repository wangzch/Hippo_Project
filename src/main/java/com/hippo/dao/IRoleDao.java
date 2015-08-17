package com.hippo.dao;

import java.util.ArrayList;

import com.hippo.vo.Role;

public interface IRoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);
    
    ArrayList<Role> getRoleByUserId(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}