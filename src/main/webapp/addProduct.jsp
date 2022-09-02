<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
<form:form action="saveProduct" modelAttribute="product">
Name : <form:input path="name" />
type : <form:input path="type"/>

cost : <form:input path="cost"/>
<input type="submit">
</form:form>
</body>
</html>