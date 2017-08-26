<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
			
				
					<img border="0" width="13" height="13" src="${pageContext.request.contextPath }/detail/style/images/title_arrow.gif"/>  更新资产
				
				
			
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
	<!-- 表单内容 -->
	<form action="${pageContext.request.contextPath }/AssetsServlet?method=update&type_id=${type_ids}&company_id=${company_ids}" method="post">
	<input type="hidden" name="id" value="${Assets.id }"/>
	
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="${pageContext.request.contextPath }/detail/style/images/item_point.gif"> 资产信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">
					<center>
					<table  cellpadding="0" cellspacing="0" class="mainForm">
						<tr>
							<td>
								&nbsp;使用者：<input type="text" name="users" class="InputStyle" value="${Assets.users }"/> 
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;&nbsp;类别：<input type="text" name="p_type" class="InputStyle" value="${Assets.p_type }"/> 
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;&nbsp;数量：<input type="text" name="amount" class="InputStyle" value="${Assets.amount }"/> 
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;&nbsp;型号：<input type="text" name="model" class="InputStyle" value="${Assets.model }"/> 
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;&nbsp;价值：<input type="text" name="price" class="InputStyle" value="${Assets.price }"/> 
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;&nbsp;配置：<input type="text" name="configration" class="InputStyle" value="${Assets.configration }"/> 
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;序列号：<input type="text" name="serial_number" class="InputStyle" value="${Assets.serial_number }"/> 
							</td>
						</tr>
						<tr>
							<td>
								购买时间：<input type="text" name="buy_time" class="InputStyle" value="${Assets.buy_time }"/> 
							</td>
						</tr>
						<tr>
							<td>
								领取时间：<input type="text" name="receive_time" class="InputStyle" value="${Assets.receive_time }"/> 
							</td>
						</tr>
						<tr>
							<td>
								使用状态：<input type="text" name="p_status" class="InputStyle" value="${Assets.p_status }"/> 
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;&nbsp;编号：<input type="text" name="number" class="InputStyle" value="${Assets.number }"/> 
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;&nbsp;备注：<input type="text" name="remark" class="InputStyle" value="${Assets.remark }"/> 
							</td>
						</tr>
	
					</table>
					</center>
				</div>
            </div>
        </div>
		
		<!-- 表单操作 -->
		<div id="InputDetailBar">
			
				
					 <input type="submit" value="修改" class="FunctionButtonInput">
				
				
			
            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>
	</form>
	
</div>




</body>
</html>
