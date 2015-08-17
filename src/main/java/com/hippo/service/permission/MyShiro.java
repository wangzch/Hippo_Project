package com.hippo.service.permission;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hippo.service.IUserService;
import com.hippo.vo.Permission;
import com.hippo.vo.Role;
import com.hippo.vo.User;

@Service  
@Transactional
public class MyShiro extends AuthorizingRealm{
	
    @Resource  
    private IUserService userService;  

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		//获取登录时输入的用户名  
        String loginName=(String) principalCollection.fromRealm(getName()).iterator().next();
        //根据登录名查询用户信息
        User user = this.userService.getUserByName(loginName);  
        if(user!=null){  
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）  
            SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();  
            //用户的角色集合
            ArrayList<Role> roleArray = userService.getRoleByUserId(user.getId());
            info.setRoles(userService.getRoleNameFromRoleArray(roleArray));  
            //用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要  
            for (Role role : roleArray) { 
            	ArrayList<Permission> permissionArray = userService.getPermissionArrayByRoleId(role.getId());
                info.addStringPermissions(userService.getPermissionNameFromArray(permissionArray));
            }  
            return info;  
        }  
        return null;  
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		 //UsernamePasswordToken对象用来存放提交的登录信息  
        //UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken; 
        
		UsernamePasswordCaptchaToken token = (UsernamePasswordCaptchaToken)authenticationToken;
		
		String userName = token.getUsername();
		char[] password = token.getPassword();
		String captcha = token.getCaptcha();
		String exitCode = (String) SecurityUtils.getSubject().getSession()
				.getAttribute(CaptchaServlet.KEY_CAPTCHA);
		
		if (userName == null) {
			throw new AccountException( "Null usernames are not allowed by this realm.");
		}
		
        //查出是否有此用户  
        User user=userService.getUserByName(token.getUsername());  
        if(user == null){
            throw new UnknownAccountException();//
        }else if(password.length == 0 || password == null){
            throw new IncorrectCredentialsException();//
        }else if(null == captcha || !captcha.equalsIgnoreCase(exitCode)){
        	throw new CaptchaException();
		}else{
            //若存在，将此用户存放到登录认证info中  
        	SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
        	authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(user.getUsername()+user.getSalt())); 
            return authenticationInfo;
        }  
	}
	
	/**
	 * 更新用户授权信息缓存.
	 */
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清除所有用户授权信息缓存.
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}
	
	 /** 
     * 将一些数据放到ShiroSession中,以便于其它地方使用 
     * @see  比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到 
     */  
 /*   private void setSession(Object key, Object value){  
        Subject currentUser = SecurityUtils.getSubject();  
        if(null != currentUser){  
            Session session = currentUser.getSession();  
            System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");  
            if(null != session){  
                session.setAttribute(key, value);  
            }  
        }  
    } */
}
