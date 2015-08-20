package com.hippo.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hippo.service.permission.CaptchaException;
import com.hippo.service.permission.CaptchaUtil;
import com.hippo.service.permission.UsernamePasswordCaptchaToken;
import com.hippo.vo.User;

@Controller  
public class LogController {
	
	public static final String KEY_CAPTCHA = "SE_KEY_MM_CODE";

	@RequestMapping(value="login",method=RequestMethod.GET)  
    public String loginForm(Model model){  
        model.addAttribute("user", new User());  
        return "login";  
    }  
     
    @RequestMapping(value="login",method=RequestMethod.POST)  
    public String login(@Valid User user,String captcha,BindingResult bindingResult,RedirectAttributes redirectAttributes,HttpServletRequest request){  
        
        UsernamePasswordCaptchaToken token = new UsernamePasswordCaptchaToken(user.getUsername(), user.getPassword() != null ? user.getPassword().toCharArray() : null, false, null, captcha);
        String errorMessage = "";
        try {  
            SecurityUtils.getSubject().login(token); 
        } catch (UnknownAccountException e) {
        	errorMessage = "用户名错误";  
        } catch (IncorrectCredentialsException e) {  
        	errorMessage = "密码错误";  
        } catch (CaptchaException e) {  
            //其他错误，比如锁定，如果想单独处理请单独catch处理  
        	errorMessage = "验证码错误";  
        } catch (AuthenticationException e) {  
            //其他错误，比如锁定，如果想单独处理请单独catch处理  
        	errorMessage = "其他错误：" + e.getMessage();  
        }  
        if(errorMessage != null && !errorMessage.equals("")) {//出错了，返回登录页面  
            redirectAttributes.addFlashAttribute("errorMessage", errorMessage);
            return "redirect:login";  
        }
        
        return null;
    }  
      
    @RequestMapping(value="logout",method=RequestMethod.GET)    
    public String logout(RedirectAttributes redirectAttributes ){   
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息  
        SecurityUtils.getSubject().logout();    
        redirectAttributes.addFlashAttribute("message", "您已安全退出");    
        return "redirect:login";  
    }   
      
    @RequestMapping("403")  
    public String unauthorizedRole(){  
        return "403";  
    }
    
	@RequestMapping(value="captchaCode",method=RequestMethod.GET)  
    public void loginForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {  
		// 设置相应类型,告诉浏览器输出的内容为图片
		resp.setContentType("image/jpeg");
		// 不缓存此内容
		resp.setHeader("Pragma", "No-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expire", 0);
		try {

			HttpSession session = req.getSession();

			CaptchaUtil tool = new CaptchaUtil();
			StringBuffer code = new StringBuffer();
			BufferedImage image = tool.genRandomCodeImage(code);
			session.removeAttribute(KEY_CAPTCHA);
			session.setAttribute(KEY_CAPTCHA, code.toString());

			// 将内存中的图片通过流动形式输出到客户端
			ImageIO.write(image, "JPEG", resp.getOutputStream());

		} catch (Exception e) {
			e.printStackTrace();
		}
    }  
}
