<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="saveuser.htm" method="post">
<table>
<tr>
<td>Enter User name</td>
<td><input type="text" name="user_name"></td>
</tr>
<tr>
<td>Enter Email ID</td>
<td><input type="text" name="user_email"></td>
</tr>
<tr>
<td>Enter Password</td>
<td><input type="password" name="user_password"></td>
</tr>
<tr>
<td>Enter Address</td>
<td><input type="text" name="user_address"></td>
</tr>
<tr>
<td>Enter Mobile number</td>
<td><input type="text" name="user_mobile"></td>
</tr>
<input  type="hidden" name="user_flag" value="1">

<tr>
<td><button type="submit">Insert</button>
</tr>
</table>
</form>
</body>
</html>