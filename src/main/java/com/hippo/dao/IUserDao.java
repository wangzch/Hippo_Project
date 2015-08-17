package com.hippo.dao;

import java.util.ArrayList;

import com.hippo.vo.User;

public interface IUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    
    User selectByName(String name);
    
    ArrayList<User> getAllUser();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}