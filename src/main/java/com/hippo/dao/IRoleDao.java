package com.hippo.dao;

import java.util.ArrayList;

import com.hippo.vo.Role;

public interface IRoleDao {
	public int deleteByPrimaryKey(Integer id);

	public int insert(Role record);

	public int insertSelective(Role record);

	public Role selectByPrimaryKey(Integer id);
    
	public ArrayList<Role> getRoleByUserId(Integer id);

	public int updateByPrimaryKeySelective(Role record);

	public int updateByPrimaryKey(Role record);
}