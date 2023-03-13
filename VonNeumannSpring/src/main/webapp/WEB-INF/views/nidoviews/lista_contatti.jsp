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
LISTA CONTATTI<br><br>

<%--c:if test=""></c:if --%>
<c:choose>
	<c:when test="${empty lista}">NESSUN CONTATTO</c:when>
	<c:otherwise>
		<c:forEach var="contact" items="${lista}">
			${contact.id}<br>
			${contact.name}<br>
			${contact.surname}<br>
			${contact.telephone}<br><br>
		</c:forEach>
	</c:otherwise>
</c:choose>

</body>
</html>