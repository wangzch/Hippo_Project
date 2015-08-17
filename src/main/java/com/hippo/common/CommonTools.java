package com.hippo.common;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service("commonTools") //Spring创建实例
public class CommonTools {
	
	public String getDate(){
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		return df.format(new Date());
	}

}
