package com.hippo.dao;

import java.util.ArrayList;

import com.hippo.vo.User;

public interface IUserDao {
	public int deleteByPrimaryKey(Integer id);

	public int insert(User record);

	public int insertSelective(User record);

	public User selectByPrimaryKey(Integer id);
    
	public User selectByName(String name);
    
	public ArrayList<User> getAllUser();

	public int updateByPrimaryKeySelective(User record);

	public int updateByPrimaryKey(User record);
}