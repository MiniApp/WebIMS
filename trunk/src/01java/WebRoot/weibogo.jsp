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
    <div id="showDiv">正在登陆中……</div>
  	<script type="text/javascript">
    	var url = window.location.href;
    	var paraString = url.substring(url.indexOf("#")+1,url.length).split("&"); 
        var paraObj = {};
        for (i=0; j=paraString[i]; i++){ 
        	paraObj[j.substring(0,j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=")+1,j.length); 
        } 
       	var parapp = $.toJSON(paraObj);
        var po = jQuery.parseJSON(parapp);
        //var returnValue = paraObj[paras.toLowerCase()]; 
    	$.ajax({
					type : "POST",
					url : "http://127.0.0.1:8080/web/tencentWeiboLoginCheck",
					data : po,//{"access_token":"38fc777338dfb01e362df4b70dceb32e","expires_in":"8035200","openid":"3A813B88F49FD49170BB32190F96A6B7","openkey":"CD74287163B1A981C4AF0A8473E09ACE","refresh_token":"a078cce342c8e4a01df18637a8fcf508","state":"","name":"TagSue","nick":"%E8%8B%8F%E7%9A%93"},
					dataType : "json",
					success : function(data) {
						var value = 3;  
					    $("body").append("<input type='hidden' id='init_value' value="+value+" />");  
					    time = setInterval('auto_jump()',1000);  
					},
					error : function(data) {
						alert("Failed");
					}
				});
		function auto_jump() {  
		    secs = $("#init_value").val() - 1;  
		    $("#init_value").val(secs);  
		        if(secs < 0){return false;}  
		    if(secs == 0){  
		        clearInterval(time);  
		        $("#showDiv").html('正在载入...');  
		        window.location.href='/web/tencentWeibo';  
		    }else{  
		        $("#showDiv").html(secs+' 秒后自动跳转');  
		    }  
		}  
    </script>
  </body>
</html>
