<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:form action="inserttiffinwala.htm" modelAttribute="tiffindata" method="post" enctype="multipart/form-data">
<f:hidden path="uservo.user_id" value="${user_id}"/>
<%-- <input type="hidden" name="user_id" value="${user_id}"> --%>
<h5>Enter Tiffin name</h5>
<f:input path="tiffin_name"/>

<h5>select city</h5>
<f:select path="cityvo.city_id">
			<f:options items="${citylist}" itemValue="city_id" itemLabel="city_name"/>
	</f:select>
	


<h5>Enter Email ID</h5>
<f:input path="tiffin_email"/>


<h5>Enter Pincode</h5>
<f:input path="tiffin_pincode"/>
<h5>Enter Address</h5>
<f:input path="tiffin_address"/>
<h5>Enter Mobile number</h5>
<f:input path="tiffin_mobile"/>

<f:input path="tiffin_flag" value="0"/>

<br>
<f:button type="submit">Insert</f:button>
</f:form>
</body>
</html>