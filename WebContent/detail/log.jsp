<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
 	<!-- 包含公共的JSP代码片段 -->
	
<title>固定资产管理</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath }/detail/style/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/detail/style/js/page_common.js"></script>
<link href="${pageContext.request.contextPath }/detail/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/detail/style/css/index_1.css" />
</head>
<body>
<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="${pageContext.request.contextPath }/detail/style/images/title_arrow.gif"/> 日志列表
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


<!-- 过滤条件 -->
<div id="QueryArea">
	<form action="${pageContext.request.contextPath }/LogServlet?method=findLogByUsername" method="post">
		<input type="hidden" name="method" value="search">
		<input placeholder="请输入关键词" type="text" name="keyword" >
		<input type="submit" value="搜索">
	</form>
</div>


<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>编号</td>
				<td>操作时间</td>
				<td>操作人</td>
				<td>内容</td>
				<td>备注</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
        <tbody id="TableData">
        
		<c:choose>
			<c:when test="${not empty requestScope.pageBean.pageData}">
				<c:forEach var="log" items="${requestScope.pageBean.pageData}" varStatus="vs">
				
			<tr class="TableDetail1">
				<td align="center">${vs.count }</td>
				<td align="center">${log.create_time } &nbsp;</td>
				<td align="center">${log.operator }</td>
				<td align="center">${log.content }</td>
				<td align="center">${log.remark }</td>
			</tr>
				
				</c:forEach>
			</c:when>
				<c:otherwise>
				<tr>
					<td colspan=3>没有你要找的内容,请先添加！</td>
				</tr>
				</c:otherwise>
		</c:choose>
	
        
        </tbody>
    </table>
	
   <!-- 其他功能超链接 -->
	<div id="TableTail" align="center">
		<div align="right">
		当前${requestScope.pageBean.currentPage }/${requestScope.pageBean.totalPage }页 &nbsp;
		<a title="首页" href="${pageContext.request.contextPath }/LogServlet?method=findByPage&currentPage=1">首页</a>&nbsp;
		<a title="上一页" href="${pageContext.request.contextPath }/LogServlet?method=findByPage&currentPage=${requestScope.pageBean.currentPage-1 }">上一页</a>&nbsp;
		
		<a title="下一页" href="${pageContext.request.contextPath }/LogServlet?method=findByPage&currentPage=${requestScope.pageBean.currentPage+1 }">下一页</a>&nbsp;
		<a title="末页" href="${pageContext.request.contextPath }/LogServlet?method=findByPage&currentPage=${requestScope.pageBean.totalPage }">末页</a>&nbsp;
		共${requestScope.pageBean.totalCount }条数据&nbsp;&nbsp;
		</div>
    </div> 
    

</div>
</body>
</html>
