<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>

<form action="UserServlet" method="post">
   
<input type="hidden" name="flag" value="register">

姓名:<input type="text" name="name" id="name"><span id="s">随便</span><br/><br/>

密码:<input type="password" name="password"><br/><br/>

年龄:<input type="text" name="age"><br/><br/>

生日:<input type="text" name="birthDay"><br/><br/>

爱好:<input type="checkbox" name="hobby" value="篮球">篮球
    <input type="checkbox" name="hobby" value="台球">台球
    <input type="checkbox" name="hobby" value="足球">足球
    <input type="checkbox" name="hobby" value="乒乓球">乒乓球<br/>
    
头像:<input type="radio" name="cartoon" value="01.gif"><img src="img/01.gif"/>
    <input type="radio" name="cartoon" value="02.gif"><img src="img/02.gif"/>
    <input type="radio" name="cartoon" value="03.gif"><img src="img/03.gif"/>
    <input type="radio" name="cartoon" value="04.gif"><img src="img/04.gif"/>
    <input type="radio" name="cartoon" value="05.gif"><img src="img/05.gif"/>
    <input type="radio" name="cartoon" value="06.gif"><img src="img/06.gif"/>
    <input type="radio" name="cartoon" value="1.ioc"><img src="img/1.ico"/><br/><br/>
    
    <input type="submit" value="注册">
    
</form>


</body>

<script type="text/javascript" src="js/util.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
 
 window.onload=function(){
	 
	 var name=document.getElementById("name");
	 
	 var span=document.getElementById("s");
	 
	 name.onblur=function(){
		 
		 var xhr=ajaxFunction();
		 
		 xhr.open("POST","UserServlet?flag=checkUser&name="+this.value,true);
		 
		 xhr.onreadystatechange=function(){
			 
			 if(xhr.readyState==4&&xhr.status==200){
				 
				 var result=xhr.responseText;
				 
				 if(result=="true"){//数据库中存在该用户，不能注册此用户名了。
					 
					 span.style.color="red";
				 
				     span.innerHTML="×这个用户名火的不行,请换一个";
					 
				 }else{
					 
					 span.style.color="green";
					 
					 span.innerHTML="√";
				 }
			 }
			 
		 }
		 
		 xhr.send(null);
		 
		 
	 }
    
	 $(":root").css("background-color","#7FFF00");

 }

</script>


</html>