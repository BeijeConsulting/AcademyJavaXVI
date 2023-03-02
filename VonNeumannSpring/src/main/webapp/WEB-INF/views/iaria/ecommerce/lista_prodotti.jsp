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
	<c:when test="${empty lista}">NESSUN PRODOTTO</c:when>
	<c:otherwise>
		<c:forEach var="prodotto" items="${lista}">
			<h4 align="center"></h4>
		</c:forEach>
	</c:otherwise>
</c:choose>

</body>
</html>