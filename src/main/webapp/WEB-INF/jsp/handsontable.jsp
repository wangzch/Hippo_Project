<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/handsontable.full.min.css"/>
	<script src="<%=request.getContextPath()%>/dist/handsontable.full.min.js"></script>
	<script src="<%=request.getContextPath()%>/dist/handsontable/ZeroClipboard.js"></script>
	<script src="<%=request.getContextPath()%>/dist/handsontable/pikaday.js"></script>
</head>
<body>
		<jsp:include page="navigation.jsp" flush="true"/>
		<jsp:include page="menu.jsp" flush="true"/>
		<div class="main-container" id="main-container">
			<div class="main-content">
					<div class="col-xs-12">
					
						<div class="space-6"></div>
						<div id="example"></div>
					</div>
			</div><!-- main-content -->
		</div>
		<script type="text/javascript">
		  		var container = document.getElementById('example');
		  		var hot = new Handsontable(container, {
			  		  colHeaders: ['id', '用户名', '姓名', '注册日期', '电子邮箱', '手机号'],
			  		  minSpareRows: 1,
			  		  rowHeaders: true,
			  		  contextMenu: true
				});
		  		$.ajax({
	                type: "get",
	                async: true, //同步执行
	                url: "handsontabledata",
	                dataType: "json", //返回数据形式为json
	                success: function (result) {
	                    hot.loadData(result.data);
                	},
	                error: function (errorMsg) {
	                	alert("图表请求数据失败!");
                	}
                });
		</script>
</body>
</html>