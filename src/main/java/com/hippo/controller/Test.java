package com.hippo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;

import test.mybatis.TestMenu;

public class Test {
	
	public static void main(String[] args){
		
		TestMenu test = new TestMenu();
		test.test();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		
		
		
		SecureRandomNumberGenerator secureRandomNumberGenerator=new SecureRandomNumberGenerator(); 
        String salt= secureRandomNumberGenerator.nextBytes().toHex();
        System.out.println(salt);
        //组合username,两次迭代，对密码进行加密 
        String password_cipherText= new Md5Hash("qwe123","employee"+salt,2).toHex(); 
        
        System.out.println(new Md5Hash("123456").toHex());
        
        System.out.println(password_cipherText+"-------"+salt);
        

	}
}
