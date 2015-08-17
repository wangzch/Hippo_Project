package com.hippo.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hippo.service.IUserService;
import com.hippo.vo.User;

@Controller  
public class HandsonTableController {
	
    @Resource  
    private IUserService userService;  
    
	@RequestMapping("handsontable")  
    //@ResponseBody 
    public String loginForm(Model model){  
		
        return "handsontable";  
    } 
	
	@RequestMapping(value="handsontabledata",method=RequestMethod.GET)
    @ResponseBody 
	public JSONObject loginForm(HttpServletRequest request, HttpServletResponse response, HttpSession session){  
		JSONObject json = new JSONObject();
    	json.put("success", true);
    	json.put("msg", "保存成功");
    	JSONArray array = new JSONArray();
    	
    	ArrayList<User> userList = userService.getAllUser();
    	
    	if(userList !=null && userList.size()>0){
        	for(int i = 0;i<userList.size();i++){
            	JSONArray array1 = new JSONArray();

        		User user = userList.get(i);
        		array1.add(0, user.getId());
        		array1.add(1, user.getUsername());
        		array1.add(2, user.getDspname());
        		array1.add(3, user.getCreate_date());
        		array1.add(4, user.getEmail());
        		array1.add(5, user.getTelphone());
        		array.add(array1);
        	}
    	}
    	
    	json.put("data", array);
    	return json;
    } 
}
