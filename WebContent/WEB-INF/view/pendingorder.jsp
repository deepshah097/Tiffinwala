<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

<br/>
<center>
<table border="1">
<tr>
<td>order Id
<td>order_address
<td>order amt
<td>order date
<td>order flag
<td>order qty
<td>order city id
<td>order menu id
<td>order tiffin id
<td>order user id

<td colspan="2">Action

</tr>
<c:forEach items="${orderlist}" var="n">
<tr>
<td>${n.order_id}</td>
<td>${n.order_address}</td>
<td>${n.order_amount}</td>
<td>${n.order_date}</td>
<td>${n.order_flag}</td>
<td>${n.order_qty}</td>
<td>${n.cityvo.city_id}</td>
<td>${n.menuvo.menu_items}</td>
<td>${n.tiffinvo.tiffin_id}</td>
<td>${n.uservo.user_id}</td>



</tr>
</c:forEach>
</table>
</center>
</body>
</html>