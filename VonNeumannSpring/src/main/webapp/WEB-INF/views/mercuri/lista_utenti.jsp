<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Utenti</title>
</head>
<body>

LISTA ORDINI<br><br>

<c:choose>
	<c:when test="${empty users}">NESSUN utente</c:when>
	<c:otherwise>
		<c:forEach var="uer" items="${users}">
			id: ${user.id}<br>
			name: ${user.name}<br>
			surname: ${user.surname}<br>
			telephone: ${user.telephone}<br>
			<!--  items:<br>
			<c:forEach var="item" items="${order.items}">
				- ${item.productId}, ${item.quantity}, ${item.price}<br>
			</c:forEach>
			<br>-->
			---------------------------<br><br>
		</c:forEach>
	</c:otherwise>
</c:choose>

</body>
</html>