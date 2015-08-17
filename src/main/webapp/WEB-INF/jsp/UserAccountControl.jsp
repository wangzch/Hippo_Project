<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ include file="header.jsp"%>
<!DOCTYPE HTML>  
<html>  
  <head>  
    <title>用户列表</title>  
  </head>  
  <body>  
    <h1>${message }</h1>  
    <h1>用户列表--<a href="/user/add">添加用户</a>---<a href="/logout">退出登录</a>    </h1> 
    <h2>权限列表</h2>  
    <shiro:authenticated>用户已经登录显示此内容</shiro:authenticated><br/>  
    <shiro:hasRole name="manager">manager角色登录显示此内容</shiro:hasRole><br/>    
    <shiro:hasRole name="admin">admin角色登录显示此内容</shiro:hasRole><br/>    
    <shiro:hasRole name="normal">normal角色登录显示此内容</shiro:hasRole><br/>    
      
    <shiro:hasAnyRoles name="manager,admin">**manager or admin 角色用户登录显示此内容**</shiro:hasAnyRoles><br/>    
    <shiro:principal/>-显示当前登录用户名<br/>    
    <shiro:hasPermission name="add">add权限用户显示此内容</shiro:hasPermission><br/>    
    <shiro:hasPermission name="user:query">query权限用户显示此内容<shiro:principal/></shiro:hasPermission><br/>    
    <shiro:lacksPermission name="user:del"> 不具有user:del权限的用户显示此内容 </shiro:lacksPermission><br/>    
    <ul>  
        <c:forEach items="${userList}" var="user">  
            <li>用户名：${user.name }----密码：${user.password }----<a href="/user/edit/${user.id}">修改用户</a>----<a href="javascript:;" class="del" ref="${user.id }">删除用户</a></li>  
        </c:forEach>  
    </ul>  
    <script>  
        $(function(){  
            $(".del").click(function(){  
                var id=$(this).attr("ref");  
                $.ajax({  
	                    type:"delete",  
	                    url:"/user/del/"+id,  
	                    success:function(e){  
                    }  
                });  
            });  
        });  
    </script>  
  </body>  
</html>  