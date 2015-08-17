<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.ExcessiveAttemptsException"%>
<%@ page import="org.apache.shiro.authc.IncorrectCredentialsException"%>  
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>登录页面</title>
		<meta name="keywords" content="搜索" />
		<meta name="description" content="测试登录页" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<script type="text/javascript">
			$(function(){ $('input, textarea').placeholder(); });
		</script>
	</head>

	<body class="login-layout">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="icon-leaf green" style="visibility:hidden"></i>
									<span class="red" style="visibility:hidden">Ace</span>
									<span class="white" style="visibility:hidden">Application</span>
								</h1>
								<h4 class="blue" style="visibility:hidden">&copy; Company Name</h4>
							</div>
							<div class="space-6"></div>
							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-home green"></i>
												欢迎登录
											</h4>
											<h6 id="errorMessage" class="text-warning bigger-110 red">${errorMessage}</h6>
											<form:form action="login" commandName="user" method="post">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:input type="text" onclick="javascript:hiddenError();" class="form-control" path="username" placeholder="请输入您的用户名" style="font-size:15px;color:gainsboro"/> <form:errors path="username" cssClass="error"/>
															<i class="icon-user" style="font-size: 20px"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:password class="form-control"  onclick="javascript:hiddenError();" path="password" placeholder="请输入您的密码" style="font-size:15px;color:gainsboro"/> <form:errors path="password" cssClass="error" />
															<i class="icon-lock" style="font-size: 20px"></i>
														</span>
													</label>
													
													<div class="form-inline">
														<input type="text" id="captcha" name="captcha" onclick="javascript:hiddenError();" size="4" maxlength="4" placeholder="请输入右侧的验证码" class="form-control" style="width:180px"/>
															<img title="点击更换" id="img_captcha" onclick="javascript:refreshCaptcha();" src="captchaCode" style="height:33px"/>
															<a href="#" onclick="javascript:refreshCaptcha()">
    															<i class="icon-refresh"></i>
															</a>
													</div>
													
													<div class="field">
														<label for="codeImg" class="field"></label> 
													</div>
													<label class="inline-block">
														<input type="checkbox" name="rememberMe" class="ace"/>
														<span class="lbl"><font size="2">自动登录</font></span>
													</label>
													<a href="register" onclick="show_box('forgot-box'); return false;" class="btn pull-right btn-link" role="button">
													     	<font size="2">忘记密码?</font>
													</a>
													<div class="space-6"></div>
													<div class="clearfix">
														<form:button name="button" style="outline:none;height:35px;font-weight:bold;font-size: 17px" class="width-100 btn btn-sm btn-primary">
															登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录
														</form:button>
													</div>

													<div class="space-2"></div>
												</fieldset>
											</form:form>

											<div class="social-or-login center">
												<span class="bigger-110">
													<a href="register">
												     	<font color="red" size="2">立即注册</font>
													</a>
												</span>
											</div>

											<div class="social-login center">
												<a class="btn btn-primary">
													<i class="icon-facebook"></i>
												</a>

												<a class="btn btn-info">
													<i class="icon-twitter"></i>
												</a>

												<a class="btn btn-danger">
													<i class="icon-google-plus"></i>
												</a>
											</div>
										</div><!-- /widget-main -->
									</div><!-- /widget-body -->
								</div><!-- /login-box -->
							</div><!-- /position-relative -->
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div>
		</div><!-- /.main-container -->

		<!-- inline scripts related to this page -->

		<script type="text/javascript">
			function show_box(id) {
			 jQuery('.widget-box.visible').removeClass('visible');
			 jQuery('#'+id).addClass('visible');
			}
			
			$(document).ready(function() {
				$("#loginForm").validate();
			});
			var _captcha_id = "#img_captcha";
			function refreshCaptcha() {
				$(_captcha_id).attr("src","captchaCode?t=" + Math.random());
			}
			
			function hiddenError() {
				document.getElementById("errorMessage").style.display="none";
			}
			
			function showError() {
				document.getElementById("errorMessage").style.display="inline";
			}
		</script>
</body>
</html>
