<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="saveUser" modelAttribute="user">

name: <form:input path="name"/> <br>
email: <form:input path="email"/> <br>
password: <form:input path="password"/><br>
<input type = "submit">
</form:form>
</body>
</html>