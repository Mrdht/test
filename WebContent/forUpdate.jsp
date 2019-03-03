<%@page import="com.oracle.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>
</head>
<body>

<form action="UserServlet" method="post">

   <input type="hidden" name="flag" value="commitUpdate">
    
    <input type="hidden" name="id" value="${user.id}">
姓名:<input type="text" name="name" value="${user.name}"><br/><br/>

年龄:<input type="text" name="age" value="${user.age}"><br/><br/>

生日:<input type="text" name="birthDay" value="${user.birthDay}"><br/><br/>

爱好:<input type="checkbox" name="hobby" value="篮球">篮球
    <input type="checkbox" name="hobby" value="台球">台球
    <input type="checkbox" name="hobby" value="足球">足球
    <input type="checkbox" name="hobby" value="乒乓球">乒乓球<br/>
    
头像:<input type="radio" name="cartoon" value="01.gif" ${user.cartoon=="01.gif"?"checked":""}><img src="img/01.gif"/>
    <input type="radio" name="cartoon" value="02.gif" ${user.cartoon=="02.gif"?"checked":""}><img src="img/02.gif"/>
    <input type="radio" name="cartoon" value="03.gif" ${user.cartoon=="03.gif"?"checked":""}><img src="img/03.gif"/>
    <input type="radio" name="cartoon" value="04.gif" ${user.cartoon=="04.gif"?"checked":""}><img src="img/04.gif"/>
    <input type="radio" name="cartoon" value="05.gif" ${user.cartoon=="05.gif"?"checked":""}><img src="img/05.gif"/>
    <input type="radio" name="cartoon" value="06.gif" ${user.cartoon=="06.gif"?"checked":""}><img src="img/06.gif"/>
    <input type="radio" name="cartoon" value="1.ioc"  ${user.cartoon=="1.ioc"?"checked":""}><img src="img/1.ico"/><br/><br/>
    
    <input type="submit" value="注册">
    
</form>

</body>

<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">

$(function(){
	
	var h="${hobby}";
	
	var s=h.split(" ");
	
	$("input[name=hobby]").each(function(){
		
		var hy=$(this).val();
		
		for(var i=0;i<h.length;i++){
			
			if(hy==s[i]){
				
				$(this).attr("checked",true)
			}
		}
		
		
		
		
	})
	
	
	
	
})

$(":root").css("background-color","#7FFF00");
</script>




</html>