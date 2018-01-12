<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title></title>
<link rel="stylesheet" href="${ctx}/plugins/bootstrap/css/bootstrap.css">
<style type="text/css">
.btn-withd {
	width: 150px;
}

.error-input {
	border: red solid 1px;
}
a{
color:black;
}
.active{
	color:white;
}
</style>

<link rel="stylesheet" type="text/css" href="${ctx }/css/common.css">
<link rel="stylesheet" type="text/css" href="${ctx }/css/style.css">
<link rel="stylesheet" type="text/css"
	href="${ctx }/plugins/font-awesome/css/font-awesome.min.css">

</head>

<body>

	<div id="topLogoPanel">
		<div class="top-logo-panel">
			<img src="${ctx }/images/logo.png">
		</div>
	</div>
	<div class="d-flex flex-row">
		<div class="menu-item-list ml-5">
			<div class="nav content flex-column nav-pills" id="v-pills-tab"
				role="tablist" aria-orientation="vertical">
				<a class="nav-link menu-item active" 
					data-url="/student/list" data-toggle="pill" href="javascript:;">全部</a>
					
				<a class="nav-link menu-item " id="v-pills-profile-tab"
					data-url="/student/male/list" data-toggle="pill"
					href="javascript:;">男</a>
					
					 <a class="nav-link menu-item "
					id="v-pills-messages-tab" data-url="/student/female/list"
					data-toggle="pill" href="javascript:;">女</a> 
					<a
					class="nav-link menu-item " id="v-pills-settings-tab"
					data-url="/student/java/list" data-toggle="pill"
					href="javascript:;">Java开发</a> 
					
					<a class="nav-link menu-item "
					id="v-pills-messages-tab" data-url="/student/test/list"
					data-toggle="pill" href="javascript:;">软件测试</a> 
					
					<a class="nav-link menu-item " id="v-pills-settings-tab"
					data-url="/student/web/list" data-toggle="pill"
					href="javascript:;">web前端</a> 
					
					<a class="nav-link menu-item "
					id="v-pills-settings-tab" data-url="/student/bigdata/list"
					data-toggle="pill" href="javascript:;">大数据</a> 
					
					
			</div>
		</div>
		<div id="bottomContentPanel">
			<div class="bottom-content-panel">
				<div class="right-content-panel"></div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="${ctx }/plugins/jquery-2.1.3.min.js"></script>

	<script src="${ctx}/plugins/bootstrap/js/popper.min.js"></script>
	<script src="${ctx}/plugins/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript"
		src="${ctx }/plugins/jquery-form/jquery.form.min.js"></script>
	<script type="text/javascript"
		src="${ctx }/plugins/validate/jquery-html5Validate-min.js"></script>
	<script type="text/javascript">
		var g_rootPath = "${ctx}";
		var $topLogoPanel = $("#topLogoPanel");
		var $bottomContentPanel = $("#bottomContentPanel");
		var $menuItemList = $(".menu-item-list");
		var $rightContentPanel = $bottomContentPanel
				.find(".right-content-panel");

		$(function() {
			// 左侧菜单点击
			$menuItemList.find(".menu-item").on("click", function() {
				var $this = $(this);
				var url = $this.data("url");
				// 加载页面
				loadMainContent(url);
			}).first().click();
			var $userManageListPanel = $("#userManageListPanel");
			
		})
		// 加载主页面内容
		function loadMainContent(url, params) {
			var $targes = $("#right")
			$rightContentPanel.load("${ctx}" + url, params);
		}
		// 触发当前菜单点击
		function triggerCurrentMenu() {
			var $content = $(".content");
			$content.find(".menu-item.active").trigger("click");
		}
		function showInputTip($input, value) {
			var $parent = $input.parent();

			$parent.addClass("error-group");
			$parent.find(".input-label span").remove();
			$parent.find(".input-label").append("<span>" + value + "</span>");
			$input.focus();

			return false;
		}


		// 隐藏验证提示
		function hideInputTip($input) {
			var $parent = $input.parent();

			$parent.removeClass("error-group");
			$parent.find(".input-label span").remove();
		}

	</script>
</body>

</html>