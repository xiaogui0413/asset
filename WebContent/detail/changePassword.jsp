<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <!-- 包含公共的JSP代码片段 -->
	
<title>固定资产管理</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath }/detail/style/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/detail/style/js/page_common.js"></script>

<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/dialog/zepto.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/dialog/mdialog.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/dialog/mdialog.css"> --%>

<script type="text/javascript" src="zepto.min.js"></script>
<script type="text/javascript" src="mdialog.js"></script>
<link rel="stylesheet" type="text/css" href="dialog/mdialog.css">

<link href="${pageContext.request.contextPath }/detail/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/detail/style/css/index_1.css" />
</head>
<body>


<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="${pageContext.request.contextPath }/detail/style/images/title_arrow.gif"/>  修改密码			
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
	<!-- 表单内容 -->
	<form action="${pageContext.request.contextPath }/UserServlet?method=changePassword" method="post">
	
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="${pageContext.request.contextPath }/detail/style/images/item_point.gif"> 密码信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">
					<table cellpadding="0" cellspacing="0" class="mainForm">
						<tr><label class="error" id="msg">${msg }</label><br/></tr>
						<tr>
							<td width="80px">原密码：</td>
							<td>
								<input type="password" name="oldpwd" class="InputStyle" value=""/> *原密码长度3~20之间！<label class="error" id="msg"></label><br/>
								<input type="hidden" name="cid" value="" />
							</td>
						</tr>
						
						<tr>
							<td width="80px">新密码：</td>
							<td>
								<input type="password" name="newpwd" class="InputStyle" value=""/> *原密码长度3~20之间！<label class="error" id="msg"></label><br/>
								<input type="hidden" name="cid" value="" />
							</td>
						</tr>
						
						<tr>
							<td width="80px">确认新密码：</td>
							<td>
								<input type="password" name="confirmpwd" class="InputStyle" value=""/> *原密码要与新密码一致！<label class="error" id="msg"></label><br/>
								<input type="hidden" name="cid" value="" />
							</td>
						</tr>
					</table>
				</div>
            </div>
        </div>
		
		<!-- 表单操作 -->
		<div id="InputDetailBar">	
			 <input type="submit" value="修改" id="success" class="FunctionButtonInput">		
            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>
	</form>
	
</div>

</body>
</html>
