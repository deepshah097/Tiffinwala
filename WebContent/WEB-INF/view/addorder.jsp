<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order page</title>
</head>
<body>
<f:form action="insertorder.htm" modelAttribute="order" method="post" enctype="multipart/form-data">
<h5>Enter Qantity</h5>
<f:input path="order_qty"/>
<%-- 
<h5>Enter Address</h5>
<f:input path="order_address"/> --%>

<!-- <h5>Enter Date</h5>
<input type="date" name="order_date"/>
 -->
 
<h5>select city</h5>
<f:select path="cityvo.city_id">
			<f:options items="${citylist}" itemValue="city_id" itemLabel="city_name"/>
	</f:select> 
	
	<h5>select menu</h5>
<f:select path="menuvo.menu_id">
			<f:options items="${menulist}" itemValue="menu_id" itemLabel="menu_items"/>
	</f:select>
	
	<h5>select tiffinwala</h5>
	<f:select path="tiffinvo.tiffin_id">
			<f:options items="${tiffinlist}" itemValue="tiffin_id" itemLabel="tiffin_name"/>
	</f:select>
	
	<f:hidden path="order_flag" value="0"/>
<%-- <f:input path="tiffinvo.tiffin_name" value="${tiffinlist}"/>
	 --%>

<f:button type="submit">Insert</f:button>
</f:form>

</body>
</html>