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

  </head>
  
  <body>
    <h3><a href="tencentWeiboLoginInit">腾讯微博授权链接</a></h3>
    <script type="text/javascript">
    	var url = window.location.href;
    	var paraString = url.substring(url.indexOf("#")+1,url.length).split("&"); 
        var paraObj = {};
        for (i=0; j=paraString[i]; i++){ 
        paraObj[j.substring(0,j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=")+1,j.length); 
        } 
        //var returnValue = paraObj[paras.toLowerCase()]; 
    	$.ajax({
					type : "POST",
					url : "http://127.0.0.1:8080/web/testLoginCheck",
					data : {'name':'admin'},
					dataType : "json",
					success : function(data) {
						alert("Success");
					},
					error : function(data) {
						alert("Failed");
					}
				});
    </script>
  </body>
</html>
