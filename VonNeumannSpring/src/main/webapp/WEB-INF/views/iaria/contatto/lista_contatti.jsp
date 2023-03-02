<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>lista contatti</title>
</head>

<body>
<h1 align="center">LISTA CONTATTI</h1>

<%--c:if test=""></c:if --%>
<c:choose>
	<c:when test="${empty lista}">NESSUN CONTATTO</c:when>
	<c:otherwise>
		<c:forEach var="contatto" items="${lista}">
			<h4 align="center">ID: ${contatto.id}, Nome: ${contatto.nome}, Cognome: ${contatto.cognome}, Telefono: ${contatto.telefono}, Email: ${contatto.email}, Note: ${contatto.note}</h4>
		</c:forEach>
	</c:otherwise>
</c:choose>

</body>
</html>