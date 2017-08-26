<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>固定资产管理</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="style/js/jquery.js"></script>
<script type="text/javascript" src="style/js/page_common.js"></script>
<link href="style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="style/css/index_1.css" />
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="style/images/title_arrow.gif" /> 资产列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>
	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="/wirelessplatform/cuisine.html" method="get">
			<input type="hidden" name="method" value="search">
			<input type="text" name="keyword" title="请输入名称">
			<input type="submit" value="搜索">
		</form>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
				<td>ID</td>
				<td>使用者</td>
				<td>类别</td>
				<td>数量</td>
				<td>型号</td>
				<td>价值</td>
				<td>配置</td>
				<td>序列号</td>
				<td>购买时间</td>
				<td>领取时间</td>
				<td>使用状态</td>
				<td>编号</td>
				<td>备注</td>
				<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
				
			<tr class="TableDetail1">
				<td align="center">1&nbsp;</td>
				<td align="center">铁通机房自有服务器&nbsp;</td>
				<td align="center">计算机.服务器</td>
				<td align="center">1</td>
				<td align="center">thinkpad E550&nbsp;</td>
				<td align="center"> 6300&nbsp;</td>
				<td align="center">intel i7-5500u@2.4HZ/8G/500G</td>
				<td align="center">SN:FF-07RNC3</td>
				<td align="center">7-Mar-16&nbsp;</td>
				<td align="center">7-Mar-16&nbsp;</td>
				<td align="center">在用</td>
				<td align="center">XP001</td>
				<td align="center"></td>
				
				<td>
					<a href="${pageContext.request.contextPath }/detail/undo.jsp" class="FunctionButton">修改</a>				
					<a href="${pageContext.request.contextPath }/detail/undo.jsp" onClick="return delConfirm();"class="FunctionButton">删除</a>				
				</td>
			</tr>
			
			
			<tr class="TableDetail1">
				<td align="center">2&nbsp;</td>
				<td align="center">河南光电NDS增值项目&nbsp;</td>
				<td align="center">计算机.服务器</td>
				<td align="center">1</td>
				<td align="center">thinkpad E550&nbsp;</td>
				<td align="center"> 6300&nbsp;</td>
				<td align="center">intel i7-5500u@2.4HZ/8G/500G</td>
				<td align="center">SN:FF-07RNC3</td>
				<td align="center">7-Mar-16&nbsp;</td>
				<td align="center">7-Mar-16&nbsp;</td>
				<td align="center">在用</td>
				<td align="center">XP001</td>
				<td align="center"></td>
				
				<td>
					<a href="${pageContext.request.contextPath }/detail/undo.jsp" class="FunctionButton">修改</a>				
					<a href="${pageContext.request.contextPath }/detail/undo.jsp" onClick="return delConfirm();"class="FunctionButton">删除</a>				
				</td>
			</tr>
			
			
				
				
					
				
				
			</tbody>
		</table>
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
			<div class="FunctionButton">
				<a href="${pageContext.request.contextPath }/detail/undo.jsp">添加</a>
			</div>
		</div>
	</div>
</body>
</html>
