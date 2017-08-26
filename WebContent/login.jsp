<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 
 	 <meta http-equiv="pragma" content="no-cache"> 
     <meta http-equiv="cache-control" content="no-cache"> 
     <meta http-equiv="expires" content="0"> 
-->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head lang="en">
    <meta charset="UTF-8">
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'/>
    <title>资产管理系统</title>
    <link href="${pageContext.request.contextPath }/detail/style/css/a.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath }/detail/style/css/img/logo.ico" rel="shotcut icon"/>
    <script type="text/javascript">
    	if(window.parent!=window){
    		window.parent.location.reload(true);
    	}
    </script>

</head>
<body>
<header>
    <div class="text"> 
       <a href="http://www.xipunet.com">公司主页</a>
<!--        <a onclick="AddFavorite(window.location,document.title)" href="javascript:void(0)">加入的收藏</a> -->
       <a href='###' onclick="javascript:window.external.AddFavorite('http://www.csdn.net/','csdn')" title="将本站加如您的收藏夹">收藏本站</a>
    </div>
</header>
<div id="content">
    <img src="${pageContext.request.contextPath }/detail/style/css/img/jian1.jpg" />
    <h1>西普数据资产管理</h1>
    <form action="${pageContext.request.contextPath }/UserServlet?method=login" method="post">
        <label class="error" id="msg">${msg }</label><br/>
        <input id="usename" placeholder="用户名/邮箱" name="username" type="text"/><br/>
        <input id="password" placeholder="登录密码" name="password" type="password"/>
        <div class="bt clear">
            <input class="check fl" type="checkbox" value=""/>
            <span class="fl">记住密码</span>
            <em class="fl">忘记密码？</em>
            <input id="submit" type="submit" value="登录" />
        </div>
    </form>
</div>
<div id="footer">
    <p><span>© 2016 陕西西普数据通信股份有限公司</span></p>
</div>
</body>
</html>
