<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'weibo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${ctx}/public/js/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="${ctx}/public/js/jquery-json.js"></script>
  </head>
  
  <body>
    <h3>主页<a href="tencentQQLoginInit"><image src="public/image/qq_logo_4.png"></a> || <a href="tencentQQLogout">退出登陆</a></h3>
  	
  </body>
</html>
