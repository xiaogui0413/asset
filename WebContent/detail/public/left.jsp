<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>

<head>

  <meta charset="UTF-8">

  <title>Frame left</title>

  <link rel="stylesheet" href="${pageContext.request.contextPath }/css/normalize.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" media="screen" type="text/css" />
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/index.js"></script>
</head>


  <div class="container">

  
  <ul>
    <li class="dropdown">
      <a target="right" a href="${pageContext.request.contextPath }/detail/public/right.jsp" data-toggle="dropdown">首页</a>
    </li>
    <li class="dropdown">
      <a href="#" data-toggle="dropdown">宝鸡总部 <i class="icon-arrow"></i></a>
      <ul class="dropdown-menu">
      	<li><a target="right" href="${pageContext.request.contextPath }/AssetsServlet?method=findByPage&type_id=1&company_id=2">武汉全部资产</a></li>
        <li><a target="right" href="${pageContext.request.contextPath }/AssetsServlet?method=findByPage&type_id=1&company_id=1">计算机类</a></li>
        <li><a target="right" href="${pageContext.request.contextPath }/AssetsServlet?method=findByPage&type_id=2&company_id=1">工具类</a></li>
        <li><a target="right" href="${pageContext.request.contextPath }/AssetsServlet?method=findByPage&type_id=3&company_id=1">桌椅类</a></li>
        <li><a target="right" href="${pageContext.request.contextPath }/AssetsServlet?method=findByPage&type_id=4&company_id=1">耗材类</a></li>
      </ul>
    </li>
    <li class="dropdown">
      <a href="#" data-toggle="dropdown">上海分公司 <i class="icon-arrow"></i></a>
      <ul class="dropdown-menu">
      	<li><a target="right" href="${pageContext.request.contextPath }/AssetsServlet?method=findByPage&type_id=1&company_id=2">上海全部资产</a></li>
        <li><a target="right" href="${pageContext.request.contextPath }/AssetsServlet?method=findByPage&type_id=1&company_id=3">计算机类</a></li>
        <li><a target="right" href="${pageContext.request.contextPath }/AssetsServlet?method=findByPage&type_id=2&company_id=3">工具类</a></li>
        <li><a target="right" href="${pageContext.request.contextPath }/AssetsServlet?method=findByPage&type_id=3&company_id=3">桌椅类</a></li>
        <li><a target="right" href="${pageContext.request.contextPath }/AssetsServlet?method=findByPage&type_id=4&company_id=3">耗材类</a></li>
      </ul>
    </li>
    <li class="dropdown">
      <a href="#" data-toggle="dropdown">武汉分公司 <i class="icon-arrow"></i></a>
      <ul class="dropdown-menu">
      	<li><a target="right" href="${pageContext.request.contextPath }/AssetsServlet?method=findByPage&type_id=1&company_id=2">武汉全部资产</a></li>
        <li><a target="right" href="${pageContext.request.contextPath }/AssetsServlet?method=findByPage&type_id=1&company_id=2">计算机类</a></li>
        <li><a target="right" href="${pageContext.request.contextPath }/AssetsServlet?method=findByPage&type_id=2&company_id=2">工具类</a></li>
        <li><a target="right" href="${pageContext.request.contextPath }/AssetsServlet?method=findByPage&type_id=3&company_id=2">桌椅类</a></li>
        <li><a target="right" href="${pageContext.request.contextPath }/AssetsServlet?method=findByPage&type_id=4&company_id=2">耗材类</a></li>
      </ul>
    </li>
    <li class="dropdown">
      <a href="#" data-toggle="dropdown">资产分布图 <i class="icon-arrow"></i></a>
      <ul class="dropdown-menu">
        <li><a target="right" href="${pageContext.request.contextPath }/AssetsServlet?method=sumByCompany">按公司</a></li>
        <li><a target="right" href="${pageContext.request.contextPath }/AssetsServlet?method=sumByType">按资产类型</a></li>
      </ul>
    </li>
    <li class="dropdown">
      <a target="right" href="${pageContext.request.contextPath }/chart.jsp" data-toggle="dropdown">资产分布图<i class="icon-arrow"></i></a>
    </li>
    <li class="dropdown">
      <a target="right" href="${pageContext.request.contextPath }/LogServlet?method=findByPage" data-toggle="dropdown">日志管理</a>
    </li>
  </ul>
</div>
 <script src="${pageContext.request.contextPath }/js/index.js"></script>
 <!--   <script src="js/index.js"></script>-->

</body>

</html>
