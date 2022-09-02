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
<form:form action = "putitem" modelAttribute="item">
<form:input path="name" readonly="readonly"/>
<form:input path="cost" readonly="readonly"/>
<form:input path="quantity"/>
<input type="submit">
</form:form>
</body>
</html>