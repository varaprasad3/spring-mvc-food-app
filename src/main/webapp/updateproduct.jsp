<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>v 
<body>
<form:form action="updateproduct" modelAttribute="product">
id : ${product.getId()} <form:hidden path="id"/>
name : <form:input path="name" />
type : <form:input path="type" />

cost : <form:input path="cost" />
<input type="submit">
</form:form>
</body>
</html>