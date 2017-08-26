<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <!-- 包含公共的JSP代码片段 -->
	
<title>固定资产管理</title>


<meta http-equiv="Content-Type" content="text/html; charset=UFT-8" />
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
			
				
				
					<img border="0" width="13" height="13" src="${pageContext.request.contextPath }/detail/style/images/title_arrow.gif"/>  添加资产
				
			
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
	<!-- 表单内容 -->
				<%
				String name=request.getParameter("type_id");
				String name2=request.getParameter("company_id");
				request.setAttribute("type_ids", name);
				request.setAttribute("company_ids", name2);
				%>
	<form action="${pageContext.request.contextPath }/AssetsServlet?method=saveAssetsWH&type_id=${type_ids}&company_id=${company_ids}" method="post" id="assetsForm">
	     	  	 
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="style/images/item_point.gif"> 资产信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">

					<table  cellpadding="0" cellspacing="0" class="mainForm">
						<tr>
							<td>
								&nbsp;使用者：<input type="text" maxlength="5" name="users" id="user" class="InputStyle" value=""/>
							</td>
							<td>
								<label class="errorClass" id="userError">${errors.loginpass }</label>
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;&nbsp;类别：<input type="text" maxlength="10" name="p_type" id="p_type" class="InputStyle" value=""/>
							</td>
							<td>
								<label class="errorClass" id="p_typeError">${errors.loginpass }</label>
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;&nbsp;数量：<input type="number" max="9999" name="amount" id="amount" class="InputStyle" value=""/>
							</td>
							<td>
								<label class="errorClass" id="amountError">${errors.loginpass }</label>
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;&nbsp;型号：<input type="text" maxlength="25" name="model" id="model" class="InputStyle" value=""/>
							</td>
							<td>
								<label class="errorClass" id="modelError">${errors.loginpass }</label>
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;&nbsp;价值：<input type="text" name="price" id="price" class="InputStyle" value=""/>
							</td>
							<td>
								<label class="errorClass" id="priceError">${errors.loginpass }</label>
							</td>

						</tr>
						<tr>
							<td>
								&nbsp;&nbsp;配置：<input type="text" name="configration" id="configration" class="InputStyle" value=""/>
							</td>
							<td>
								<label class="errorClass" id="comfigrationError">${errors.loginpass }</label>
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;序列号：<input type="text" name="serial_number" id="serial_number" class="InputStyle" value=""/>
							</td>
							<td>
								<label class="errorClass" id="serial_numberError">${errors.loginpass }</label>
							</td>
						</tr>
						<tr>
							<td>
								购买时间：<input type="text" maxlength="19" required="required" name="buy_time" id="buy_time" class="sang_Calender" value=""/>
							</td>
							<td>
								<label class="errorClass" id="buy_timeError">${errors.loginpass }</label>
							</td>
						</tr>
						<tr>
							<td>
								领取时间：<input type="text" maxlength="10" name="receive_time" id="receive_time" class="sang_Calender" value=""/>
							</td>
							<td>
								<label class="errorClass" id="receive_timeError">${errors.loginpass }</label>
							</td>
						</tr>
						<tr>
							<td>
								使用状态：<input type="text" name="p_status" id="p_status" class="InputStyle" value=""/>
							</td>
							<td>
								<label class="errorClass" id="p_statusError">${errors.loginpass }</label>
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;&nbsp;编号：<input type="text" name="number" id="number" class="InputStyle" value=""/>
							</td>
							<td>
								<label class="errorClass" id="numberError">${errors.loginpass }</label>
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;&nbsp;备注：<input type="text" name="remark" id="remark" class="InputStyle" value=""/>
								<input type="hidden" name="${type_ids }" id="remark" class="InputStyle" value=""/>
								<input type="hidden" name="${company_ids }" id="remark" class="InputStyle" value=""/>
								
							</td>
							<td>
								<label class="errorClass" id="remarkError">${errors.loginpass }</label>
							</td>
						</tr>

					</table>

				</div>
            </div>
        </div>
		
		<!-- 表单操作 -->
		<div id="InputDetailBar">
			
				
				
					 <input type="submit" value="添加" class="FunctionButtonInput">
				
			
            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>
	</form>
	
</div>

<script type="text/javascript" src="${pageContext.request.contextPath }/detail/style/js/datetime.js"></script>
</body>
</html>
