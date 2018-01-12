<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp" %>

<div id="userManageListPanel">
<div class="d-flex flex-row">
	
					<button type="button" data-url="/student/toadd" class="btn btn-secondary menu-items">新增学生</button>
	</div>				
	<div class="real-content-panel">
		<table class="table table-sm">
  <thead>
    <tr>
      <th scope="col">序号</th>
      <th scope="col">姓名</th>
      <th scope="col">性别</th>
      <th scope="col">专业</th>
      <th scope="col">方向</th>
      <th scope="col">技术</th>
      <th scope="col">能力</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="students" items="${students }" varStatus="status">
    <tr>
      
      <td>${status.count }</td>
      <td>${students.name }</td>
      <td>${students.sex }</td>
      <td>${students.major }</td>
      <td>${students.direction }</td>
      <td>${students.skill }</td>
      <td>${students.capacity }</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
	</div>
</div>
<script>
	$(function() {
		
		var $userManageListPanel = $("#userManageListPanel");
		$userManageListPanel.on("click",".menu-items",function(){
			var	url=$(this).data("url")
			$rightContentPanel.load("${ctx}" + url);
	})
		// 添加用户
		$userManageListPanel.find(".add-user-btn").on("click", function() {
			// 加载页面
			loadMainContent("/user/content/add", function() {

			}, {
				userId : -1
			});
		});
		
		// 更新用户
		$userManageListPanel.find(".edit-user-btn").on("click", function () {
			var $this = $(this);
			var userId = $this.parent().parent().data("id");
			
			// 加载页面
			loadMainContent("/user/content/add", function() {

			}, {
				userId : userId
			});
		});
		//删除用户
		$userManageListPanel.find(".remove-user-btn").on("click", function () {
						var $this = $(this);
						var userId = $this.parent().parent().data("id");
			
						// 确认操作
						if (!confirm("确认删除该用户？")) {
							return false;
						}
						
						doAction("/user/content/remove", {
							userId: userId
						}, function (data) {
							// 刷新页面
							triggerCurrentMenu();
						}, "删除成功！");
					});
				// 选中所有
					$userManageListPanel.find(".check-all-btn").on("click", function () {
						// 获取所有复选框数量
						var allItemNum = $userManageListPanel.find(".user-item-id").length;
						
						// 获取被选中的复选框数量
						var checkedItemNum = $userManageListPanel.find(".user-item-id:checked").length;
						
						// 对比复选框是否全部被选中
						var isChecked = allItemNum === checkedItemNum;
						
						// 如果全部被选中，则反选，否则全选
						$userManageListPanel.find(".user-item-id").prop("checked", !isChecked);
					});
				
					// 删除多个用户
					$userManageListPanel.find(".remove-users-btn").on("click", function () {
						// 获取被选中复选框
					var checkedItems = $userManageListPanel.find(".user-item-id:checked");
						
						// 非空判断
						if (checkedItems.length === 0) {
							alert("请选择待删除用户！");
							return false;
						}
						
						// 操作确认
					if (!confirm("确定删除选中用户？")) {
							return false;
						}
						
						// 获取所有被选中项的id列表
						var userIds = "";
					
						// 循环遍历被选中项
						checkedItems.each(function () {
							userIds += $(this).val() + ",";
					});
						
						// 截取多余字符
					userIds = userIds.substr(0, userIds.length - 1);
						
						doAction("/user/content/removes", {
							userIds: userIds
						}, function () {
							// 刷新列表
							triggerCurrentMenu();
						}, "删除成功！");
					});
			 	
		
	})
</script> 