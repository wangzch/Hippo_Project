<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- basic styles -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/bootstrap.css"/>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/font-awesome.min.css"/>

		<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!-- page specific plugin styles -->

		<!-- fonts -->

		<link rel="stylesheet" href="http://fonts.useso.com/css?family=Open+Sans:400,300" />

		<!-- ace styles -->

		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ace.min.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ace-skins.min.css" />

		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->

		<script src="<%=request.getContextPath()%>/assets/js/ace-extra.min.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="assets/js/html5shiv.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->


		<!-- basic scripts -->

		<!--[if !IE]> -->

		<script src="<%=request.getContextPath()%>/assets/js/jquery-2.1.4.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
		<script src="http://ajax.useso.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		<![endif]-->

		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='<%=request.getContextPath()%>/assets/js/jquery-2.1.4.js'>"+"<"+"script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
		<script type="text/javascript">
		 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"script>");
		</script>
		<![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='<%=request.getContextPath()%>/assets/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
		</script>
		
		<script src="<%=request.getContextPath()%>/assets/js/bootstrap.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/typeahead-bs2.min.js"></script>

		<!-- page specific plugin scripts -->

		<script src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.min.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/jquery.dataTables.bootstrap.js"></script>

		<!-- ace scripts -->
		<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
		<![endif]-->
		<script src="<%=request.getContextPath()%>/assets/js/jquery.placeholder.test.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/jquery.form.js"></script>

		<script src="<%=request.getContextPath()%>/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/jquery.slimscroll.min.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/jquery.easy-pie-chart.min.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/jquery.sparkline.min.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/flot/jquery.flot.min.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/flot/jquery.flot.pie.min.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/flot/jquery.flot.resize.min.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/fuelux/fuelux.wizard.min.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/jquery.validate.min.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/additional-methods.min.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/bootbox.min.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/jquery.maskedinput.min.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/select2.min.js"></script>
		<!-- ace scripts -->

		<script src="<%=request.getContextPath()%>/assets/js/ace-elements.min.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/ace.min.js"></script>
		<link rel='icon' href='<%=request.getContextPath()%>/img/hippo.ico' type=‘image/x-ico’ /> 
		<title>系统测试</title>
	</head>
</html>