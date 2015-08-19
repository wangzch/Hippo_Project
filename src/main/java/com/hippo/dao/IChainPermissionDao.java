package com.hippo.dao;

import java.util.ArrayList;

import com.hippo.vo.ChainPermission;

public interface IChainPermissionDao {
	public int deleteByPrimaryKey(Integer id);

	public int insert(ChainPermission record);

	public int insertSelective(ChainPermission record);

	public ChainPermission selectByPrimaryKey(Integer id);

	public int updateByPrimaryKeySelective(ChainPermission record);

	public int updateByPrimaryKey(ChainPermission record);
    
	public ArrayList<ChainPermission> getAllChainPermission();
}