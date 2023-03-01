<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<b>Vedi lista contatti</b><br>

<c:choose>
	<c:when test="${empty lista}">NESSUN CONTATTO</c:when>
	<c:otherwise>
		<c:forEach var="contatto" items="${lista}">
			${contatto.name}<br>
			${contatto.surname}<br>
			${contatto.completeName}<br>
			${contatto.telephone}<br><br>
		</c:forEach>
	</c:otherwise>
</c:choose>
</body>
</html>