package com.hippo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hippo.service.IUserService;
import com.hippo.vo.User;  
 
@Controller  
 
public class UserController {  
    @Resource  
    private IUserService userService;  
      
    @RequestMapping(value="userAccountControl",method=RequestMethod.GET)  
    public String toIndex(@Valid User user,HttpServletRequest request,Model model){
    	
    	ArrayList<User> userList = userService.getAllUser();
    	model.addAttribute("userList",userList);
        return "UserAccountControl";  
    }
    
    @RequestMapping(value="userManagement",method=RequestMethod.GET)  
    public String userManagement(@Valid User user,HttpServletRequest request,Model model){
    	
    	ArrayList<User> userList = userService.getAllUser();
    	model.addAttribute("userList",userList);
    	//model.addAttribute("userManagement","userManagement");
        return "user";  
    }  
    @RequestMapping(value="deleteUser",method=RequestMethod.GET)  
    public String userManagement(@Valid String id,HttpServletRequest request,Model model){
    	
    	userService.deleteUserInfo(Integer.parseInt(id));
        return "redirect:userManagement";  
    } 
    @RequestMapping(value="isExistUser",method=RequestMethod.GET)  
    public void isNotExistUser(@Valid String name,HttpServletResponse response,HttpServletRequest request,Model model) throws IOException{
    	boolean isNotExist = true;
    	User user = userService.getUserByName(name);
    	if(user != null)
    		isNotExist = false;
    	
    	response.getWriter().print(isNotExist);
    } 
}  
