package com.hippo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hippo.common.Menu;
import com.hippo.service.IMenuService;
import com.hippo.vo.Node;

@Controller  
public class MenuController {
	
    @Resource  
    private IMenuService menuService; 
    
	@RequestMapping(value="menu",method=RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
    public String getMenu(Model model){
		
	    List<Node> nodesList = new ArrayList<Node>();  
		List<Node> nodes = menuService.getMenu();
		for(Node node : nodes){
			Node nodeObject = new Node();  
			nodeObject.setId(node.getId()); 
			nodeObject.setParentid(node.getParentid());
			nodeObject.setMenuNo(node.getMenuNo());
			nodeObject.setName(node.getName());
			nodeObject.setUrl(node.getUrl());
			nodeObject.setIcon(node.getIcon());
			nodeObject.setPermission(node.getPermission());
	        nodesList.add(nodeObject);  	
		}
	    Menu tree = new Menu(nodes);  
	    
    	return tree.buildTree();
    } 
}
