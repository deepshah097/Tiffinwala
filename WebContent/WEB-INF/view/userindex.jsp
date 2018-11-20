<%@page import="com.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<% UserVo uservo=(UserVo) session.getAttribute("user");%>
<body>
Hello <%=uservo.getUser_name()%>!!

 <a href="addTiffinwala.htm?id=<%=uservo.getUser_id()%>">I want to became a tiffinwala</a>
</body>
</html>