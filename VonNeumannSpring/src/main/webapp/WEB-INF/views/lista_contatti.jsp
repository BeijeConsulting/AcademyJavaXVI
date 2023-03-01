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
<form action="lista_contatti" method="get">
Cognome:<br>
<input type="text" name="surname"><br>
Nome:<br>
<input type="text" name="name">
<input type="submit" value="Cerca">

</form>
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