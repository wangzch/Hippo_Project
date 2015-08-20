package com.hippo.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;

import com.hippo.vo.Node;

public class Menu {
	private StringBuffer html = new StringBuffer();  
    private List<Node> nodes;  
      
    public Menu(List<Node> nodes){  
        this.nodes = nodes;  
    }  
      
    public String buildTree(){  
        for (Node node : nodes) {  
        	
            Integer id = node.getId();
            String name = node.getName();
            String url = node.getUrl();
            String icon = node.getIcon();
            String permission = node.getPermission();
            
        	if(permission != null && !permission.equals("")){
            	if(!SecurityUtils.getSubject().hasRole(permission)){
            		continue;
            	}
        	}

            if (node.getParentid() == null) {
                html.append("\r\n<li id= '"+ id +"'>");
                html.append("\r\n<a href='"+ url +"' class='dropdown-toggle'>");
                html.append("\r\n<i class= '"+ icon +"'></i>");
                html.append("\r\n<span class= 'menu-text'>"+ name +"</span>");
                if(hasChildren(node))
                    html.append("\r\n<b class= 'arrow icon-angle-down'></b>");
                html.append("\r\n</a>");
                
                build(node); 
                
                html.append("\r\n</li>");
            }  
        }  
        return html.toString();  
    }  
      
    private void build(Node node){  
        List<Node> children = getChildren(node);  
        if (!children.isEmpty()) {  
            html.append("\r\n<ul class='submenu'>");  
            for (Node child : children) {  
                Integer id = child.getId();
                /*
	                <li>
						<a href="elements.html">
							<i class="icon-double-angle-right"></i>
							组件
						</a>
					</li>
				*/
                String name = child.getName();
                String icon = child.getIcon();//icon-double-angle-right
                String url = child.getUrl();
                String permission = child.getPermission();
                
            	if(permission != null && !permission.equals("")){
                	if(!SecurityUtils.getSubject().hasRole(permission)){
                		continue;
                	}
            	}
            	
                boolean hasChildren = false;
                if(hasChildren(child))
                	hasChildren = true;

                html.append("\r\n<li id= '"+ id +"'>");
                if(hasChildren){
                	html.append("\r\n<a href='"+ url +"' class='dropdown-toggle'>");
                }else{
                	html.append("\r\n<a href='"+ url +"'>");
                }
                html.append("\r\n<i class='"+ icon +"'></i>");
                html.append(name);
                if(hasChildren)
                    html.append("\r\n<b class= 'arrow icon-angle-down'></b>");
                html.append("\r\n</a>");
                
                if(hasChildren)
                	build(child); 
            }  
            html.append("\r\n</ul>");  
        }   
    }  
      
    private List<Node> getChildren(Node node){  
        List<Node> children = new ArrayList<Node>();  
        Integer id = node.getId();  
        for (Node child : nodes) {  
            if (id.equals(child.getParentid())) {  
                children.add(child);  
            }  
        }  
        return children;  
    }  
    
    private boolean hasChildren(Node node){
    	
    	boolean hasChildren = false;
        Integer id = node.getId();  
        for (Node child : nodes) {  
            if (id.equals(child.getParentid())) {  
            	hasChildren = true;
            	break;
            }  
        }  
        return hasChildren;  
    }  
}
