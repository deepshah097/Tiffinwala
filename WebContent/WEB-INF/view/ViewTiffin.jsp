<%@page import="java.util.ArrayList"%>
<%@page import="com.vo.TiffinVo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%@include file="adminheader.jsp" %>

<body>
<br/>
<center>
<table border="1">
<tr>
<td>Tiffin Id
<td>Tiffin Name
<td>City Id
<td>City name
<td>Address
<td>pincode
<td>mobile number
<td>email
<td>flag

</tr>
<c:forEach items="${tiffinlist}" var="n">
<tr>
<td>${n.tiffin_id}</td>
<td>${n.tiffin_name}</td>
<td>${n.cityvo.city_id}</td>
<td>${n.cityvo.city_name}</td>
<td>${n.tiffin_address}</td>
<td>${n.tiffin_pincode}</td>
<td>${n.tiffin_mobile}</td>
<td>${n.tiffin_email}</td>
<td>${n.tiffin_flag}</td>


</tr>
</c:forEach>

</table>
</center>
</body></html>