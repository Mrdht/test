<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border=1px  width=900px height=300px cellspacing=0>

<tr><th>姓名</th><th>年龄</th><th>生日</th><th>爱好</th><th>等级</th></tr>

<tr align="center"><td>${info.name}</td><td>${info.age}</td><td>${info.birthDay}</td><td>${hobby}</td><td>${info.level}</td></tr>

</table>

</body>
</html>