<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${ctx}/public/js/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="${ctx}/public/plugin/plugin.js"></script>
	
  </head>
  
  <body>
    <form action="addUser" method="post">
     <br><br><br><br>
   <div align="center"><a href="${ctx}">用户管理</a></div>
   <br><br><br><br>
    <table align="center" width="90%" border="0" cellspacing="0" cellpadding="0">
    <tr width=100% align="center"><td>姓名：<input type="text" name="user.name"></td></tr>
    <tr width=100% align="center"><td>年龄：<input type="text" name="user.age"></td></tr>
   <tr><td>&nbsp;</td></tr>
    <tr width=100% align="center"><td><input type="submit" value="添加">  <input type="reset" value="重置"></td> </tr>
    </table>
    </form>
  </body>
</html>