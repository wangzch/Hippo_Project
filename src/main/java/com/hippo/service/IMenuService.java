package com.hippo.service;

import java.util.ArrayList;

import com.hippo.vo.Node;

public interface IMenuService {
	//根据登录用户role_id查询权限
	public ArrayList<Node> getMenu();
}
