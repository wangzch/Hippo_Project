package com.hippo.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import com.hippo.service.permission.UsernamePasswordCaptchaToken;

public class CaptchaFormAuthenticationFilter extends FormAuthenticationFilter {
	public static final String DEFAULT_CAPTCHA_PARAM = "captcha";

	private String captchaParam = DEFAULT_CAPTCHA_PARAM;

	public String getCaptchaParam() {

		return captchaParam;

	}
	
	@Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response)
            throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
         
        subject.getSession().setAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY, subject.getPrincipals());    //设置用户身份进session属性
       
        String url = this.getSuccessUrl();
        
        boolean isAdmin = SecurityUtils.getSubject().hasRole("admin");
        //redirectAttributes.addFlashAttribute("user", user);
        if(isAdmin){
        	url = "/userManagement";  
        }
        
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + url);    //页面跳转
        
        return false;
    }
	
	protected String getCaptcha(ServletRequest request) {

		return WebUtils.getCleanParam(request, getCaptchaParam());

	}

	protected AuthenticationToken createToken(

	ServletRequest request, ServletResponse response) {

		String username = getUsername(request);

		String password = getPassword(request);

		String captcha = getCaptcha(request);

		boolean rememberMe = isRememberMe(request);

		String host = getHost(request);

		return new UsernamePasswordCaptchaToken(username,
				password != null ? password.toCharArray() : null, rememberMe, host, captcha);

	}
}
