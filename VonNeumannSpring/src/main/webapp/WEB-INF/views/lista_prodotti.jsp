<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LISTA PRODOTTI</title>
</head>

<body>
LISTA PRODOTTI<br><br>

<c:choose>
	<c:when test="${empty products}">NESSUN PRODOTTO</c:when>
	<c:otherwise>
		<c:forEach var="product" items="${products}">
			${product.id}
            ${product.name}</br>
            ${product.listedPrice}</br>
            ${product.category}<br>
            ${product.description}<br>
			<br>
			---------------------------<br><br>
		</c:forEach>
	</c:otherwise>
</c:choose>

</body>
</html>