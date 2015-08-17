<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE" html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
	</head>
	<body>
		<jsp:include page="navigation.jsp" flush="true"/>
		<jsp:include page="menu.jsp" flush="true"/>
		<div class="main-content">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
				</script>
	
				<ul class="breadcrumb">
					<li>
						<i class="icon-home home-icon"></i>
						<a href="#">Home</a>
					</li>
	
					<li>
						<a href="#">Tables</a>
					</li>
					<li class="active">Simple &amp; Dynamic</li>
				</ul><!-- .breadcrumb -->
	
				<div class="nav-search" id="nav-search">
					<form class="form-search">
						<span class="input-icon">
							<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
							<i class="icon-search nav-search-icon"></i>
						</span>
					</form>
				</div><!-- #nav-search -->
			</div>
	
			<div class="page-content">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<h3 class="header smaller lighter blue">用户管理</h3>
						<!-- <div class="table-header"><B>用户管理</B></div> -->
						<button id="add" class="btn btn-success">
							<i class="icon-ok"></i>
							<b>新&nbsp;&nbsp;增</b>
						</button>
						<div class="table-responsive">
							<table id="sample-table-2" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center">
											<label>
												<input type="checkbox" class="ace" />
												<span class="lbl"></span>
											</label>
										</th>
										<th>用户名</th>
										<th>姓名</th>
										<!-- class="hidden-480"数字无固定长度 -->
										<th class="hidden-480">密码
										</th>

										<th>
											<i class="icon-time bigger-110 hidden-480"></i>
											注册时间
										</th>
										<th class="hidden-480">状态</th>

										<th>操作</th>
									</tr>
								</thead>

								<tbody>
								<c:forEach items="${userList}" var="user">  
									<tr>
										<td class="center">
											<label>
												<input type="checkbox" class="ace" />
												<span class="lbl"></span>
											</label>
										</td>

										<td>
											<a href="#">${user.username}</a>
										</td>
										<td>${user.dspname}</td>
										<td>${user.password}</td>
										<td>${user.create_date}</td>

										<td class="hidden-480">
										<!-- label-success 
											 label-inverse arrowed-in 箭头
											 label-info arrowed arrowed-righ
										-->	
											<c:choose>  
											   <c:when test="${user.status == 1}">
												  <span class="label label-sm label-success"><B>生效</B></span>
											   </c:when>
											   <c:when test="${user.status == 0}">
												  <span class="label label-sm"><B>失效</B></span>
											   </c:when> 
											   <c:otherwise>
												  <span class="label label-sm"><B>状态未定义</B></span>
											   </c:otherwise>
											</c:choose>  
										</td>

										<td>
											<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
												<a class="blue" href="#">
													<i class="icon-zoom-in bigger-130"></i>
												</a>

												<a class="green" href="#">
													<i class="icon-pencil bigger-130"></i>
												</a>

												<a class="red" href="deleteUser?id=${user.id}">
													<i class="icon-trash bigger-130"></i>
												</a>
											</div>
											<!-- 移动端显示 -->
											<div class="visible-xs visible-sm hidden-md hidden-lg">
												<div class="inline position-relative">
													<button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown">
														<i class="icon-caret-down icon-only bigger-120"></i>
													</button>

													<ul class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close">
														<li>
															<a href="#" class="tooltip-info" data-rel="tooltip" title="View">
																<span class="blue">
																	<i class="icon-zoom-in bigger-120"></i>
																</span>
															</a>
														</li>

														<li>
															<a href="#" class="tooltip-success" data-rel="tooltip" title="Edit">
																<span class="green">
																	<i class="icon-edit bigger-120"></i>
																</span>
															</a>
														</li>

														<li>
															<a href="deleteUser?id=${user.id}" class="tooltip-error" data-rel="tooltip" title="Delete">
																<span class="red">
																	<i class="icon-trash bigger-120"></i>
																</span>
															</a>
														</li>
													</ul>
												</div>
											</div>
										</td>
									</tr>
									</c:forEach>  
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div><!-- /.page-content -->
			<!-- 回到顶部 -->
			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->
		<div id="add_page" class="modal fade" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header no-padding">
						<div class="table-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
								<span class="white">&times;</span>
							</button>
							Results for "Latest Registered Domains
						</div>
					</div>
	
					<div class="modal-body no-padding">
						<table class="table table-striped table-bordered table-hover no-margin-bottom no-border-top">
							<thead>
								<tr>
									<th>Domain</th>
									<th>Price</th>
									<th>Clicks</th>
	
									<th>
										<i class="icon-time bigger-110"></i>
										Update
									</th>
								</tr>
							</thead>
	
							<tbody>
								<tr>
									<td>
										<a href="#">ace.com</a>
									</td>
									<td>$45</td>
									<td>3,330</td>
									<td>Feb 12</td>
								</tr>
	
								<tr>
									<td>
										<a href="#">base.com</a>
									</td>
									<td>$35</td>
									<td>2,595</td>
									<td>Feb 18</td>
								</tr>
	
								<tr>
									<td>
										<a href="#">max.com</a>
									</td>
									<td>$60</td>
									<td>4,400</td>
									<td>Mar 11</td>
								</tr>
	
								<tr>
									<td>
										<a href="#">best.com</a>
									</td>
									<td>$75</td>
									<td>6,500</td>
									<td>Apr 03</td>
								</tr>
	
								<tr>
									<td>
										<a href="#">pro.com</a>
									</td>
									<td>$55</td>
									<td>4,250</td>
									<td>Jan 21</td>
								</tr>
							</tbody>
						</table>
					</div>
	
					<div class="modal-footer no-margin-top">
						<button class="btn btn-sm btn-danger pull-left" data-dismiss="modal">
							<i class="icon-remove"></i>
							Close
						</button>
	
						<ul class="pagination pull-right no-margin">
							<li class="prev disabled">
								<a href="#">
									<i class="icon-double-angle-left"></i>
								</a>
							</li>
	
							<li class="active">
								<a href="#">1</a>
							</li>
	
							<li>
								<a href="#">2</a>
							</li>
	
							<li>
								<a href="#">3</a>
							</li>
	
							<li class="next">
								<a href="#">
									<i class="icon-double-angle-right"></i>
								</a>
							</li>
						</ul>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal-dialog -->
		</div><!-- PAGE CONTENT ENDS -->
		<script type="text/javascript">
			jQuery(function($) {
				var oTable1 = $('#sample-table-2').dataTable( {
				"aoColumns": [
			      { "bSortable": false },
			      null, null,null, null, null,
				  { "bSortable": false }
				] } );
				
				
				$('table th input:checkbox').on('click' , function(){
					var that = this;
					$(this).closest('table').find('tr > td:first-child input:checkbox')
					.each(function(){
						this.checked = that.checked;
						$(this).closest('tr').toggleClass('selected');
					});
						
				});
			
			
				$('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
				function tooltip_placement(context, source) {
					var $source = $(source);
					var $parent = $source.closest('table')
					var off1 = $parent.offset();
					var w1 = $parent.width();
			
					var off2 = $source.offset();
					var w2 = $source.width();
			
					if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
					return 'left';
				}
			})
		      $(function(){
		        // dom加载完毕
		        var $add = $('#add');
		        var $add_page = $('#add_page');
		        $add.on('click', function(){
		          $add_page.modal({backdrop: 'static'});
		        });
		      });
		</script>
</body>
</html>