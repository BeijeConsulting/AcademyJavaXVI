<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LISTA ORDINI</title>
</head>

<body>
LISTA ORDINI<br><br>

<c:choose>
	<c:when test="${empty orders}">NESSUN ORDINE</c:when>
	<c:otherwise>
		<c:forEach var="order" items="${orders}">
			order: ${order}<br>
			items: ${order.items}<br>
			<br>
			---------------------------<br><br>
		</c:forEach>
	</c:otherwise>
</c:choose>

</body>
</html>