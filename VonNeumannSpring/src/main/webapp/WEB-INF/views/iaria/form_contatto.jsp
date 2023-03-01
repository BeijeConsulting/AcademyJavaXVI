<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title align="center">INSERIMENTO NUOVO CONTATTO</title>
</head>
<body>
<!-- S
<c:choose>
	<c:when test="${not empty contatto}">
		Confermi di voler inserire il seguente contatto?<br><br>
		NOME: ${contatto.name}<br>
		COGNOME: ${contatto.surname}<br>
		TELEFONO: ${contatto.telephone}<br>
		EMAIL: ${contatto.email}<br>>
		NOTE: ${contatto.note}<br><br>
		<form action="./insert_contatto" method="post">
		  <input type="hidden" name="nome" value="${contatto.nome}"><br>
		  <input type="hidden" name="cognome" value="${contatto.cognome}"><br>
		  <input type="hidden" name="telefono" value="${contatto.telefono}"><br>
		  <input type="hidden" name="email" value="${contatto.email}"><br>
		  <input type="hidden" name="note" value="${contatto.note}"><br><br>
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
-->
</body>
</html>