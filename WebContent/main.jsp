<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
</head>
<body>

<img src="img/${user.cartoon}" id="showMyInfo">

欢迎<a href="UserServlet?flag=update">${user.name}</a><a href="UserServlet?flag=logout">&nbsp;&nbsp;退出</a>

<c:if test="${user.level>3}">

<a href="UserServlet?flag=showUser">用户管理</a>

</c:if>

&nbsp;&nbsp;<a href="MessageServlet?flag=myMessage">查看与我有关的消息</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="MessageServlet?flag=removeMyMessage">清空</a>
<%-- <c:if test="${user.level>3}">

<a href="UserServlet?flag=showUser1">超级用户管理</a>

</c:if> --%>

<hr color="red">

<div id="k" style="display:none;border: 2px solid;border-color:#7FFF00; width: 900px; height:300px;float:right;"></div>

<div style="border: 2px solid;border-color:blue; width: 900px; height:300px">
 
 <c:forEach items="${ms}" var="m">
 
 <span>
 
 <img src="img/${m.fromImg}"  width="20px" height="20px"/>${m.fromName}对
 
 <img src="img/${m.toImg}"  width="20px" height="20px"/>${m.toName==user.name?"我":m.toName}说：${m.content}
 
 </span>
 
 <span style="float:right;">
 
    <fmt:formatDate value="${m.messTime}" pattern="HH:mm:ss MM/dd "/>
 
 </span> <br/>

 </c:forEach>
 
 
 
</div>






<c:if test="${user.level>2}">

<div style="position: absolute;left: 554px">

<form action="MessageServlet" method="post">

<input type="hidden" name="flag" value="add">

<textarea name="content" rows="5" cols="40"></textarea><br>

<select name="toName">

<option selected="selected" value="请选择">请选择</option>
<%-- 
 <c:forEach items="${us}" var="u">

<c:if test="${u.name!=user.name}">

<option value="${u.name}">${u.name}</option>

</c:if>
</c:forEach>  --%>
</select>

<button>刷新留言</button>

<input type="submit" value="留言">

</form>

 </div>

</c:if>

</body>


<script type="text/javascript"  src="js/util.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>



<script type="text/javascript">
 
window.onload=function(){
	
	var xhr=ajaxFunction();
	
	xhr.open("POST","UserServlet?flag=showSelectUser",true);
	
	xhr.onreadystatechange=function(){
		
		if(xhr.readyState==4&&xhr.status==200){
			
			var s=document.getElementsByName("toName")[0];//经典错误就是嵌套两个事件的时候上面事件的信息拿不到，必须在下面的事件从新获取一下。
			
			var users=xhr.responseText;        
			
			var list=eval(users);
			
			for(var i=0;i<list.length;i++){
								
				s.options[i+1]=new Option(list[i].name,list[i].name);//前面的参数是value后面的是标签中的东西
			
			}                                                      //下拉菜单在绑定点击事件的时候一定要注意，点击后每次都刷新，所以会导致下拉菜单中的东西上不去。
			
		
			
		}
		
		
		
	}
	
	xhr.send(null);
			
		
	document.getElementById("showMyInfo").onmouseover=function(){
			
		$("#k").show(300);
		
		$("#k").load("UserServlet?flag=myinformation&id="+${user.id});
		
	}
			
	document.getElementById("showMyInfo").onmouseleave=function(){
				
		$("#k").hide(300);
			
	}
		
}

</script>

</html>