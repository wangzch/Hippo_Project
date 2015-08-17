package com.hippo.dao;

import java.util.ArrayList;

import com.hippo.vo.ChainPermission;

public interface IChainPermissionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ChainPermission record);

    int insertSelective(ChainPermission record);

    ChainPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChainPermission record);

    int updateByPrimaryKey(ChainPermission record);
    
    ArrayList<ChainPermission> getAllChainPermission();
}