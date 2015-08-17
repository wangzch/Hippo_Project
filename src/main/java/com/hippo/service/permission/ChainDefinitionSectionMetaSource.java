package com.hippo.service.permission;

import java.util.ArrayList;
import java.util.Iterator;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;

import com.hippo.dao.IChainPermissionDao;
import com.hippo.vo.ChainPermission;

public class ChainDefinitionSectionMetaSource implements FactoryBean<Ini.Section>{

	@Resource    
	private IChainPermissionDao chainPermissionDao;  
  
    private String filterChainDefinitions;
    
	/*	通过filterChainDefinitions对默认的url过滤定义 @param 
	 *  filterChainDefinitions 默认的url过滤定义 
	 */    
	public void setFilterChainDefinitions(String filterChainDefinitions) {  
        this.filterChainDefinitions = filterChainDefinitions;  
    }  
	
	@Override
	public Section getObject() throws BeansException {
		
		//获取所有路径、权限  
        ArrayList<ChainPermission> list = chainPermissionDao.getAllChainPermission();  
  
        Ini ini = new Ini();  
        //加载默认的url  
        ini.load(filterChainDefinitions);
        
        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        
        //循环Resource的url,逐个添加到section中。section就是filterChainDefinitionMap,  
        //里面的键就是链接URL,值就是存在什么条件才能访问该链接  
        for (Iterator<ChainPermission> it = list.iterator(); it.hasNext();) {  
  
        	ChainPermission chainPermission = it.next();  
            //如果不为空值添加到section中  
            if(StringUtils.isNotEmpty(chainPermission.getUrl()) && StringUtils.isNotEmpty(chainPermission.getPermissionType())) {  
                section.put(chainPermission.getUrl(),  chainPermission.getPermissionType());  
            }  
        }  
  
        return section;  
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return this.getClass();
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}
