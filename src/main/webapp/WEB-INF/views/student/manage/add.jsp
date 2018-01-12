<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<style type="text/css">
.error-input {
	border: red solid 1px;
}
</style>
<div id="userAddPanel">
	<div class="headline">
		<h2>
			新增用户
		</h2>
	</div>
	<form class="real-content-form form" name="user" action="${ctx }/student/save" method="post">
	
		<div class="form-group">
			<label class="input-label">姓名</label> <input name="name" class="form-control" type="text" placeholder="请输入姓名" value="${user.name }" autofocus>
		</div>
		<div class="form-group">
			<label class="input-label">专业</label> <input name="major"  class="form-control" type="text" placeholder="请输入专业" value="${user.mobile }">
		</div>
		<div class="form-group">
			<label class="input-label">方向</label> <input name="direction"  class="form-control" type="text" placeholder="请输入方向" value="${user.mobile }">
		</div>
		<div class="form-group">
			<label class="input-label">技术</label> <input name="capacity"  class="form-control" type="text" placeholder="请输入能力" value="${user.mobile }">
		</div>
		<div class="form-group">
			<label class="input-label">能力</label> <input name="skill"  class="form-control" type="text" placeholder="请输入技能" value="${user.mobile }">
		</div>
		<div class="form-group">
			<label class="input-label">性别</label> 
			<div class="radio-content">
				<label><input type="radio" name="sex" value="男" checked> 男</label>
				<label><input type="radio" name="sex" value="女"> 女</label>
			</div>
		</div>
	</form>
	<div class="bottom-menu-panel">
		<button class="btn btn-bg save-user-btn">保存</button>
		<button class="btn btn-bg cancel-btn">取消</button>
	</div>
</div>

<script>
var $userAddPanel = $("#userAddPanel");
		var $userContentForm = $userAddPanel.find("form");

		// 初始化表单提交
		$userContentForm.on("submit", function(e) {
			// 阻止表单默认提交事件
			e.preventDefault();

			var $this = $(this);

			// jquery-form的异步提交方式
			$this.ajaxSubmit({
				beforeSubmit : function(data, $form) {
					var name = $form.find("input[name='name']");
					var major = $form.find("input[name='major']");
					var direction = $form.find("input[name='direction']");
					var capacity = $form.find("input[name='capacity']");
					var skill = $form.find("input[name='skill']");
					var sex = $form.find("input[name='sex']");
					
					if ($.trim(name.val()) === "") {
						
						return showInputTip(name, "请输入姓名");
					} else {
						hideInputTip(name);
					}
					if ($.trim(major.val()) === "") {
						
						return showInputTip(major, "请输入专业");
					} else {
						hideInputTip(major);
					}
					if ($.trim(direction.val()) === "") {
						
						return showInputTip(direction, "请输入方向");
					} else {
						hideInputTip(direction);
					}
					if ($.trim(capacity.val()) === "") {
						
						return showInputTip(capacity, "请输入能力");
					} else {
						hideInputTip(capacity);
					}
					if ($.trim(skill.val()) === "") {
						
						return showInputTip(skill, "请输入技能");
					} else {
						hideInputTip(skill);
					}
					
				},
				success : function() {
					// 刷新页面
					alert(1)
					triggerCurrentMenu();
				}
			});
		});

		// 保存用户
		$userAddPanel.find(".save-user-btn").on("click", function() {
			$userContentForm.trigger("submit");
		});

		// 取消保存
		$userAddPanel.find(".cancel-btn").on("click", function() {
			// 刷新页面
			triggerCurrentMenu();
		});
	
</script>