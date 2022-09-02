<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table cellpadding="20px" align="center" border="">
<tr align="center">
<th>id</th>
<th>name</th>
<th>type</th>

<th>cost</th>
<th>add</th>

</tr>

<c:forEach var="product" items="${products}">
<tr align="center">
<td>${product.getId()}</td>
<td>${product.getName()}</td>
<td>${product.getType()}</td>

<td>${product.getCost()} </td>
<td><a href="additem?id=${product.getId()}">add</a></td>
</tr>
</c:forEach>
</table>
<a href="submitorder"><button>submit</button></a>
</body>
</html>