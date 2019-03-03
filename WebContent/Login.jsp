<%@page import="com.oracle.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>

<form action="UserServlet" method="post">

<input type="hidden" name="flag" value="login">

<c:if  test="${user!=null}">

<div align="center" style="background-color:green; width:300px; height:50px;padding-top: 15px;" >

<font color="red" size="5px">您已注册成功,请登录</font>

</div><br/>
</c:if>

<c:if  test="${f==false}">

<div align="center" style="background-color:green; width:320px; height:50px;padding-top: 15px;" >

<font color="red" size="5px">用户名或密码错误,请重新登录</font>

</div><br/>

</c:if>
用户名:<input type="text" name="name" id="name"><br/><div id="d"></div><br/>

密码:<input type="password" name="password"><br/><br/>

<button>登录</button>

</form>

</body>

<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">

$(function(){
		
	 $("#name").keyup(function(){
		
		$.post("UserServlet?flag=likename",{name:$(this).val()+"%"},function(s){
				 			
	    	  for(var i=0;i<s.length;i++){
	    		  	    		 
	    		$("#d").append("<div onclick='fun(this)'>"+s[i]+"</div>");
    	
	    	  } 
	    	  	    					
		},"json");
		
				
	  $("#d").html("");
					
	}) 
	
	
	
	/* $("#name").blur(function(){
		
	$.ajax({
		
		url:"UserServlet?flag=likename",
				
	   data:{name:$(this).val()+"%"},
	    
	    async:false,
	    
	    dataType:"json",
	    
	    success:function(s){
	    	
	    	  for(var i=0;i<s.length;i++){
	    		  	    		 
	    	  $(this).append("<table><tr>"+s[i]+"</tr></table>");
	    		
	    		
	    	  } 
	       		
					
	    }
		
		
		
	})
	
	
	}) */

})		

function fun(a){
	
	//$("#name").val(a.innerHTML);
	
	$("#name").val($(a).html());
	
}
 
 
</script>



</html>