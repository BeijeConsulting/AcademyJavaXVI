<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INSERIMENTO NUOVO CONTATTO</title>
</head>
<body>

<c:choose>
	<c:when test="${not empty contatto}">
		Confermi di voler inserire il seguente contatto?<br><br>
		NOME: ${contatto.name}<br>
		COGNOME: ${contatto.surname}<br>
		TELEFONO: ${contatto.telephone}<br>
		EMAIL: ${contatto.email}<br><br>
		<form action="./insert_contatto" method="post">
		  <input type="hidden" name="name" value="${contatto.name}"><br>
		  <input type="hidden" name="surname" value="${contatto.surname}"><br>
		  <input type="hidden" name="telephone" value="${contatto.telephone}"><br>
		  <input type="hidden" name="email" value="${contatto.email}"><br><br>
		  <input type="submit" value="OK">
		  <input type="reset" value="ANNULLA">
		</form> 
	</c:when>
	<c:otherwise>
		<form action="./form_contatto" method="post">
		  <label for="name">nome:</label><br>
		  <input type="text" name="name"><br>
		  <label for="surname">cognome:</label><br>
		  <input type="text" name="surname"><br>
		  <label for="telephone">telefono:</label><br>
		  <input type="text" name="telephone"><br>
		  <label for="email">email:</label><br>
		  <input type="text" name="email"><br><br>
		  <input type="submit" value="Submit">
		  <input type="reset" value="ANNULLA">
		</form> 
	</c:otherwise>
</c:choose>

</body>
</html>