package com.hippo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hippo.common.CommonTools;
import com.hippo.service.IUserService;
import com.hippo.vo.User;


@Controller  
public class RegisterController {
	
    @Resource  
    private IUserService userService;
    @Resource  
    private CommonTools commonTools;
    
	@RequestMapping(value="register",method=RequestMethod.GET)  
    public String register(Model model){  
        return "register";  
    }  
    @RequestMapping(value="register",method=RequestMethod.POST)
    @ResponseBody
    public JSONObject registerInfoSave(HttpServletRequest request, HttpServletResponse response, HttpSession session){
    	
    	String name = request.getParameter("name");
    	String password = request.getParameter("password");
    	String telphone = request.getParameter("phone");

		SecureRandomNumberGenerator secureRandomNumberGenerator=new SecureRandomNumberGenerator(); 
        String salt= secureRandomNumberGenerator.nextBytes().toHex(); 
        String password_md5 = new Md5Hash(password,name+salt,2).toHex(); 

        
    	User user = new User();
    	user.setUsername(name);
    	user.setPassword(password_md5);
    	user.setTelphone(telphone);
    	user.setSalt(salt);
    	user.setStatus(0);
    	user.setCreate_date(commonTools.getDate());
    	userService.saveRegisterUserInfo(user);

    	JSONObject json = new JSONObject();
    	json.put("success", true);
    	json.put("msg", "保存成功");    	
    	json.put("id", user.getId());
    	return json;
    }
    
    @RequestMapping(value="registerstep2",method=RequestMethod.POST)
    @ResponseBody
    public JSONObject registerEmailInfoSave(HttpServletRequest request, HttpServletResponse response, HttpSession session){
    	
    	String id = request.getParameter("userid");
    	String dspname = request.getParameter("dspname");
    	String email = request.getParameter("email");
    	User user = new User();
    	user.setId(Integer.parseInt(id));
    	user.setDspname(dspname);
    	user.setEmail(email);
    	user.setStatus(1);
    	userService.updateUserEmailInfo(user);
    	

    	JSONObject json = new JSONObject();
    	json.put("success", true);
    	json.put("msg", "保存成功");    
    	json.put("email", email);
    	json.put("dspname", dspname);
    	return json;
    }
}
