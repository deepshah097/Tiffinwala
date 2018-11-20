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
<h6>hello Edit</h6>
<f:form action="updateMenu.htm"  modelAttribute="v1"  method="POST">
				
				<f:hidden path="menu_id"/>
				Menu Items<f:textarea col="5" row="5" path="menu_items" disabled=""/><br/><br/><br/>
				Menu Price<f:input path="menu_price" disabled=""/><br><br><br>
				Menu Description<f:textarea col="5" row="5" path="menu_desc" disabled=""/><br><br><br>
				Current Menu<f:input path="current"/><br><br><br>
				Menu type<f:select path="typevo.type_id" disabled="">
					<f:options items="${typelist}" itemValue="type_id" itemLabel="type_name"/>
				</f:select><br><br><br/>
				<f:hidden path="tiffinvo.tiffin_id"/><br><br><br>
				
				<f:button>Update</f:button>
					
</f:form>
</body>
</html>