package test.mybatis;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.hippo.common.Menu;
import com.hippo.service.IMenuService;
import com.hippo.vo.Node;

public class TestMenu {
    @Resource  
    private IMenuService service; 
    
	public void test(){
		
		List<Node> nodesList = new ArrayList<Node>();  
		List<Node> nodes = service.getMenu();
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
        System.out.println(tree.buildTree());
	}
}
