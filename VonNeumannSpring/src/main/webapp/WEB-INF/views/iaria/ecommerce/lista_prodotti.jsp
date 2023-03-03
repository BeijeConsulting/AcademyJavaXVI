<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista prodotti</title>
</head>

<body>
<h1 align="center">LISTA PRODOTTI</h1>

<%--c:if test=""></c:if --%>
<c:choose>
	<c:when test="${empty products}">NESSUN PRODOTTO</c:when>
	<c:otherwise>
		<c:forEach var="product" items="${products}">
			<h4 align="center">ID: ${product.id}, Created: ${product.createdAt}, Disabled: ${product.disabledAt}, Name: ${product.name}, Description: ${product.description}, Listed: ${product.isListed}, Listed price: ${product.listedPrice}, Color: ${product.color}, Category: ${product.category}, Type: ${product.type}, Brand: ${product.brand}</h4>
		</c:forEach>
	</c:otherwise>
</c:choose>

</body>
</html>