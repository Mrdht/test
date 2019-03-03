<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div style="border: 2px solid;border-color:blue; width: 900px; height:300px">

<c:if test="${myMessage !=null}">


 <c:forEach items="${myMessage}" var="m">
 
 <span>
 
 <img src="img/${m.fromImg}"  width="20px" height="20px"/>${m.fromName==user.name?"我":m.fromName}对
 
 <img src="img/${m.toImg}"  width="20px" height="20px"/>${m.toName==user.name?"我":m.toName}说：${m.content}
 
 </span>
 
 <span style="float:right;">
 
    <fmt:formatDate value="${m.messTime}" pattern="HH:mm:ss MM/dd "/>
 
 </span> <br/>

 </c:forEach>
 
</c:if>
 
  <c:if test="${myMessage==null}">
  
  <div align="center" >
 
 <font color="red" size="10px">有关我的留言已被清空</font>
 
 </div>
   
 </c:if>

 </div>

 
</body>
</html>