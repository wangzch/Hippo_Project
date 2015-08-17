<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript">
			  var InterValObj; //timer变量，控制时间
			  var count = 10; //间隔函数，1秒执行
			  var curCount;//当前剩余秒数
			  var code = ""; //验证码
			  var codeLength = 6;//验证码长度
			  function sendCode() {
			      curCount = count;
			      var dealType; //验证方式
			  	  var uid=$("#uid").val();//用户uid
			 	  if ($("#phone").attr("checked") == true) {
		                 dealType = "phone";
		             }
		             else {
		                 dealType = "email";
		             }
			      //产生验证码
		  		  for (var i = 0; i < codeLength; i++) {
		                 code += parseInt(Math.random() * 9).toString();
		             }
		             //设置button效果，开始计时
		             $("#send_btn").attr("disabled", "true");
		             $("#send_btn").val(curCount + "秒后重新获取");
		             InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次
				  //向后台发送处理数据
		             $.ajax({
		                 type: "POST", //用POST方式传输
		                 dataType: "text", //数据格式:JSON
		                 url: '/', //目标地址
		                 data: "dealType=" + dealType +"&uid=" + uid + "&code=" + code,
		                 error: function (XMLHttpRequest, textStatus, errorThrown) { },
		                 success: function (msg){ }
		             });
		          }
		         //timer处理函数
		  	  function SetRemainTime() {
		             if (curCount == 0) {                
		                 window.clearInterval(InterValObj);//停止计时器
		                 $("#send_btn").removeAttr("disabled");//启用按钮
		                 $("#send_btn").val("获取手机验证码");
		                 code = ""; //清除验证码。如果不清除，过时间后，输入收到的验证码依然有效    
		             }
		             else {
		                 curCount--;
		                 $("#send_btn").val(curCount + "秒后重新获取");
		             }
		         }
				$(function(){ $('input, textarea').placeholder(); });
		</script>
		<title>用户注册</title>
	</head>
	<body>
		<div class="main-container">
			<div class="row-fluid">
				<div class="page-content">
					<div class="page-header">
						<h1>
							<b>用户注册</b>
						</h1>
					</div><!-- /.page-header -->
					<div class="row">
						<div class="span12">
							<div class="widget-box" style="border:none">
								<div class="widget-body" style="border:none">
									<div class="widget-main">
										<!-- 步骤导航框 -->
										<div id="fuelux-wizard" class="row-fluid" data-target="#step-container">
											<ul class="wizard-steps">
												<li data-target="#step1" class="active">
													<span class="step">1</span>
													<span class="title">用户注册</span>
												</li>
	
												<li data-target="#step2">
													<span class="step">2</span>
													<span class="title">绑定邮箱</span>
												</li>
	
												<li data-target="#step3">
													<span class="step">3</span>
													<span class="title">邮箱验证</span>
												</li>
	
												<li data-target="#step4">
													<span class="step">4</span>
													<span class="title">完成注册</span>
												</li>
											</ul>
										</div>
	
										<hr />
										<div class="step-content row-fluid position-relative" id="step-container">
											<div class="step-pane active" id="step1" style="height:320px">
												<form class="form-horizontal" id="validation-form" method="post">
													<div class="space-8"></div>
													<div class="form-group">
														<label class="col-sm-4 control-label no-padding-right" for="name"> 用户名 </label>
														<div class="col-sm-8">
															<input type="text" id="name" name="name" placeholder="请输入用户名" class="col-xs-10 col-sm-6" />
														</div>
													</div>
													<div class="space-2"></div>
													<div class="form-group">
														<label class="col-sm-4 control-label no-padding-right" for="password"> 密码 </label>
														<div class="col-sm-8">
															<input type="password" id="password" placeholder="请输入密码" name="password" class="col-xs-10 col-sm-6" />
														</div>
													</div>
													<div class="space-2"></div>
													<div class="form-group">
														<label class="col-sm-4 control-label no-padding-right" for="password2"> 确认密码 </label>
														<div class="col-sm-8">
															<input type="password" id="password2" placeholder="请再次输入密码" name="password2" class="col-xs-10 col-sm-6" />
														</div>
													</div>
													<div class="space-2"></div>
													<div class="form-group">
														<label class="col-sm-4 control-label no-padding-right" for="phone"> 手机号 </label>
														<div class="col-sm-8">
															<input type="tel" id="phone" name="phone" placeholder="请输入手机号" class="col-xs-10 col-sm-6" />
														</div>
													</div>
													<div class="space-2"></div>
													<div class="row">
														<label class="col-sm-4 control-label no-padding-right" for="form-field-2"> 手机验证码 </label>
														<div class="col-xs-12 col-sm-4">
															<div class="input-group">
																<input type="text" id='code' name='code' class="form-control" placeholder="输入验证码"/>
																<span class="input-group-btn">
																	<input type="button" id="send_btn" value="获取手机验证码" onclick="sendCode()" style="left:15px;width:150px" class="btn btn-success"/>
																</span>
															</div>
														</div>
													</div>
												</form>
											</div>
	
											<div class="step-pane" id="step2" style="height:320px" >
												<div class="space-8"></div>
												<div class="alert alert-success">
													<button type="button" class="close" data-dismiss="alert">
														<i class="icon-remove"></i>
													</button>
													<strong>
														<i class="icon-ok"></i>
														注册成功! &nbsp;&nbsp;&nbsp;&nbsp;
													</strong>
													恭喜您已经成功注册我们的系统，请继续绑定邮箱以保证账号安全。
												</div>
												<form class="form-horizontal" id="step2-form" method="post">
													<div class="form-group">
														<label class="control-label col-sm-4 no-padding-right" for="dspname">真实姓名</label>
														<div class="col-sm-8">
															<input type="text" name="dspname" id="dspname" class="col-xs-10 col-sm-6" />
														</div>
													</div>
													<div class="space-2"></div>
													<div class="form-group">
														<label class="control-label col-sm-4 no-padding-right" for="email">电子邮箱</label>
														<div class="col-sm-8">
															<div class="clearfix">
																<input type="email" name="email" id="email" class="col-xs-10 col-sm-6" />
															</div>
														</div>
													</div>
												</form>
											</div>
	
											<div class="step-pane" id="step3" style="height:320px">
												<div class="space-8"></div>
												<div id='step3_message' class="alert alert-success">
													<button type="button" class="close" data-dismiss="alert">
														<i class="icon-remove"></i>
													</button>
													<strong>
														<i class="icon-ok"></i>
													</strong>
													喜您已经成功注册我们的系统，请继续绑定邮箱以保证账号安全。
												</div>
											</div>
											<div class="step-pane" style="height:320px" id="step4">
												<div class="center">
													<h3 class="green">Congrats!</h3>
													Your product is ready to ship! Click finish to continue!
												</div>
											</div>
										</div>
	
										<hr />
										<div class="row-fluid wizard-actions text-center">
											<button class="btn btn-primary btn-next" data-last="完成">
												继  续
												<i class="icon-arrow-right icon-on-right"></i>
											</button>
										</div>
									</div><!-- /widget-main -->
								</div><!-- /widget-body -->
							</div>
						</div>
					</div>
				</div><!-- /.col -->
			</div><!-- /.main-content -->
		</div>
		<script type="text/javascript">
			jQuery(function($) {
				$('[data-rel=tooltip]').tooltip();
				$('#fuelux-wizard').ace_wizard().on('change' , function(e, info){
					if(info.step == 1) {
						
						//return true;

						if($('#validation-form').valid() == true){
		                    $('#dspname').attr("placeholder","请输入您的真实姓名");
		                    $('#email').attr("placeholder","请输入您的电子邮箱");
							$(document).ready(function () { 
				                 $("#validation-form").ajaxSubmit({//提交表单   
				                        beforeSubmit: function () {  
				                        	var element=document.getElementById("message");
				                        	if(element){
				                        		element.parentNode.removeChild(element); 
				                        	}
				                        },  
				                        url: 'register' , //提交给哪个执行   
				                        type: 'POST',  
				                        dataType: "json",//这里是指控制器处理后返回的类型，这里返回json格式。  
				                        success: function (context) {
				                        	var MySpan=document.createElement("span"); 
				                            document.getElementById("step2-form").appendChild(MySpan); 
				                            MySpan.id = "message"; 
				                            MySpan.innerHTML = "<input type='hidden' id='userid' name='userid' value='"+context.id+"'/>";
				                        },
				                        error: function (XMLResponse) { 
				                            alert(XMLResponse.responseText);  
										//这里是错误处理，通过这个alert可以看到错误的信息。对于你调试来说是比较重要的哦。  
				                        }  
				                 }); 
							}); 
						}else{
							return false;
						}
					}else if(info.step == 2){
						
						//return true;

						if($('#step2-form').valid() == true){
							$(document).ready(function () {
				                 $("#step2-form").ajaxSubmit({//提交表单   
				                        url: 'registerstep2' , //提交给哪个执行   
				                        type: 'POST',  
				                        dataType: "json",//这里是指控制器处理后返回的类型，这里返回json格式。  
				                        success: function (context) {
				                        	document.getElementById("step3_message").innerHTML = 
				                        		'您好'+context.dspname+'！我们已经向您的注册邮箱'+context.email+'发送了一封验证邮件，验证完成后您将正常使用我们的产品。谢谢！'; 
				                        },
				                        error: function (XMLResponse) { 
				                            alert(XMLResponse.responseText);  
										//这里是错误处理，通过这个alert可以看到错误的信息。对于你调试来说是比较重要的哦。  
				                        }  
				                 }); 
							}); 
						}
					}
				}).on('finished', function(e) {
					title: "提示",
					bootbox.dialog({
						message: "Thank you! Your information was successfully saved!", 
						buttons: {
							"success" : {
								"label" : "OK",
								"className" : "btn-sm btn-primary"
							}
						}
					});
				}).on('stepclick', function(e){
					return false;//prevent clicking on steps
				});
				//documentation : http://docs.jquery.com/Plugins/Validation/validate
				$.mask.definitions['~']='[+-]';
				jQuery.validator.addMethod("checkName", function (value, element) {
					return this.optional(element) ||  /^[a-zA-Z][a-zA-Z0-9_]{3,15}$/.test(value);
				}, "用户名由字母、数字、下划线组成，字母开头，4-16位。");
				jQuery.validator.addMethod("checkPassword", function (value, element) {
					return this.optional(element) ||  /^[a-zA-Z][a-zA-Z0-9_]{5,15}$/.test(value);
				}, "密码由字母、数字、下划线组成，字母开头，6-16位。");
				jQuery.validator.addMethod("phone", function (value, element) {
					return this.optional(element) ||  /^0{0,1}(13[0-9]|15[7-9]|153|156|17[0-9]|18[7-9])[0-9]{8}$/.test(value);
				}, "请输入正确的手机号");
				
				$('#validation-form').validate({
					errorElement: 'lable',
					errorClass: 'help-block',
					focusInvalid: false,
					rules: {
						name: {
							required: true,
							checkName: true,
							//异步校验，注意返回值形式
							remote:{   
	                            url: "isExistUser", 	//后台处理程序    
	                            type: "get",  			//数据发送方式   
	                            dataType: "json",       //接受数据格式       
	                            data:  {                //要传递的数据   
	                            	name: function() {
	                                    return $("#name").val();   
	                            	}   
	                            }   
	                        }    
						},
						password: {
							required: true,
							checkPassword: true
						},
						password2: {
							required: true,
							equalTo: "#password"
						},
						phone: {
							required: true,
							phone: true
						}
					},
					// jQuery.format("密码不能小于{0}个字符")
					messages: {
						name: {
							required: "用户名为必填项",
							remote: "用户名已存在"
						},
						password: {
							required: "密码为必填项"
						},
						password2: {
							required: "确认密码为必填项",
							equalTo:  "两次密码需一致"
						},
						phone: {
							required: "手机号为必填项"
						}
					},
			
					invalidHandler: function (event, validator) { //display error alert on form submit   
						$('.alert-danger', $('.login-form')).show();
					},
			
					highlight: function (e) {
						$(e).closest('.form-group').removeClass('has-info').addClass('has-error');
					},
			
					success: function (e) {
						$(e).closest('.form-group').removeClass('has-error').addClass('has-info');
						$(e).remove();
					},
					//提示信息显示位置
					errorPlacement: function (error, element) {
						if(element.is(':checkbox') || element.is(':radio')) {
							var controls = element.closest('div[class*="col-"]');
							if(controls.find(':checkbox,:radio').length > 1) controls.append(error);
							else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
						}
						else if(element.is('.select2')) {
							error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
						}
						else if(element.is('.chosen-select')) {
							error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
						}
						else error.appendTo(element.parent());
					},
			
					submitHandler: function (form) {
					},
					invalidHandler: function (form) {
					}
				});
				
				$('#step2-form').validate({
					errorElement: 'lable',
					errorClass: 'help-block',
					focusInvalid: false,
					rules: {
						dspname: {
							required: true
						},
						email: {
							required: true,
							email: true
						}
					},
					// jQuery.format("密码不能小于{0}个字符")
					messages: {
						dspname: {
							required: "真实姓名为必填项"
						},
						email: {
							required: "邮箱为必填项",
							email: "邮箱格式不正确，正确的格式例如：xxx@xx.com"
						}
					},
			
					invalidHandler: function (event, validator) { //display error alert on form submit   
						$('.alert-danger', $('.login-form')).show();
					},
			
					highlight: function (e) {
						$(e).closest('.form-group').removeClass('has-info').addClass('has-error');
					},
			
					success: function (e) {
						$(e).closest('.form-group').removeClass('has-error').addClass('has-info');
						$(e).remove();
					},
					//提示信息显示位置
					errorPlacement: function (error, element) {
						error.appendTo(element.parent());
					},
					submitHandler: function (form) {
						
					},
					invalidHandler: function (form) {
						
					}
				});
			})
		</script>
	</body>
</html>