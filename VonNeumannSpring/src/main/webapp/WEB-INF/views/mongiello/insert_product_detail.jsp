<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="./searchProductByName" method="get">
Inserisci il nome del prodotto su cui aggiungere dettagli<br>
Name: <input type="text" name="name"><br>
<input type="submit" value="Cerca">
</form>

	<c:forEach var="p" items="${products}">
		Name: ${p.name}><br>
		Description:${p.description}<br> 
		Is Listed:${p.isListed}<br> 
		Color:  ${p.color}<br> 
		Listed Price: ${p.listedPrice}<br> 
		Category: ${p.category}<br> 
		Type: ${p.type}<br> 
		Brand: ${p.brand}<br> 
	</c:forEach>



</body>
</html>

