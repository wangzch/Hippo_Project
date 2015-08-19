package com.hippo.service.imp;

import java.util.ArrayList;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hippo.dao.IMenuDao;
import com.hippo.service.IMenuService;
import com.hippo.vo.Node;

@Service("menuService") //Spring创建实例
@Transactional
public class MenuServiceImp implements IMenuService{

	@Resource
	private IMenuDao menuDao;
	
	@Override
	public ArrayList<Node> getMenu() {
		
		return menuDao.getAllMenu();
	}
}
