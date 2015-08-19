package com.hippo.dao;

import java.util.ArrayList;

import com.hippo.vo.Node;

public interface IMenuDao {
	public int deleteByPrimaryKey(Integer id);

	public int insert(Node record);

	public int insertSelective(Node record);

	public Node selectByPrimaryKey(Integer id);

	public int updateByPrimaryKeySelective(Node record);

	public int updateByPrimaryKey(Node record);
    
	public ArrayList<Node> getAllMenu();

}