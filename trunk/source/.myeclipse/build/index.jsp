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
	<script type="text/javascript" src="${ctx}/public/plugin/listUI/listUI.js"></script>
	<link rel="stylesheet" type="text/css" href="${ctx}/public/plugin/listUI/listUI.css" />
	<script type="text/javascript">
		$(document).ready(function () { 
			$("#test").listUI({
				title : "商品列表",// 是否包含标题
				url : 'queryUserList', // ajax方式对应的url地址
				method : 'POST', // 数据发送方式
				dataType : 'json', // 数据加载的类型
				width : '800px',
				pageSize : 12,
				editMode : true,
				showSort : [{
					name : '销量',
					sortName : 'name',
					sortDes : 'desc',
					action : function(){
						alert(11);
					}
				}, {
					name : '价格',
					sortName : 'price',
					sortDes : 'desc',
					action : function(){
						alert(12);
					}
				}]
			});
			/* $.KBox.show({
			    boxContent   : 'jQuery is a cross-browser JavaScript library designed to simplify the client-side scripting of HTML. It was released in January 2006 at BarCamp NYC by John Resig. Used by over 55% of the 10,000 most visited websites, jQuery is the most popular JavaScript library in use today.',
			    boxWidth     : '1000px',
			    boxHeight    : '200px',
			    boxBgColor   : '#fff',
			    boxSdColor   : '#666',
			    boxFontFamily: 'Georgia',
			    boxFontColor : '#000'
			});  */
		}); 
	</script>
	<style type="text/css">
		.add{width:500px;height:200px; border:2px solid #CCC;}
		.remove{width:500px;height:200px; border:1px solid RED;}
	</style>
  </head>
  
  <body>
   <%--  <form action="addUser" method="get">
     <br><br><br><br>
   <div align="center"><a href="${ctx}">用户管理</a></div>
   <br><br><br><br>
    <table align="center" width="90%" border="0" cellspacing="0" cellpadding="0">
    <tr width=100% align="center"><td>姓名：<input type="text" name="user.name"></td></tr>
    <tr width=100% align="center"><td>年龄：<input type="text" name="user.age"></td></tr>
   <tr><td>&nbsp;</td></tr>
    <tr width=100% align="center"><td><input type="submit" value="添加">  <input type="reset" value="重置"></td> </tr>
    </table>
    </form> --%>
    <div id="test"></div> 
  </body>
</html>