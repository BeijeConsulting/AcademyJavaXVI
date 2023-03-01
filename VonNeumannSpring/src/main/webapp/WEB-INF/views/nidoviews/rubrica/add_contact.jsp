<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungi contatto</title>
</head>
<body>

	<form action="./menu" method="get">
		<input type="submit" value="Back to menu">
	</form>
	
	<c:choose>
	<c:when test="${not empty contactToAdd}">
		Confermi di voler inserire il seguente contatto?<br><br>
		NOME: ${contactToAdd.name}<br>
		COGNOME: ${contactToAdd.surname}<br>
		TELEFONO: ${contactToAdd.telephone}<br>
		EMAIL: ${contactToAdd.email}<br>
		NOTE: ${contactToAdd.note}<br><br>
		<form action="./save_contact" method="post">
		  <input type="hidden" name="name" value="${contactToAdd.name}">
		  <input type="hidden" name="surname" value="${contactToAdd.surname}">
		  <input type="hidden" name="telephone" value="${contactToAdd.telephone}">
		  <input type="hidden" name="email" value="${contactToAdd.email}">
		  <input type="hidden" name="note" value="${contactToAdd.note}">
		  <input type="submit" value="Aggiungi">
		</form> 
	</c:when>
	<c:otherwise>
	
	<p><strong>Inserisci i dati del contatto</strong></p>

	<form action="./add_contact" method="post">
  		<label for="name">Nome</label><br>
 		<input type="text" name="name"><br>
  		<label for="surname">Cognome</label><br>
  		<input type="text" name="surname"><br>
  		<label for="telephone">Telefono</label><br>
  		<input type="text" name="telephone"><br>
 		<label for="email">Email</label><br>
  		<input type="text" name="email"><br>
  		 <label for="note">Note</label><br>
  		<input type="text" name="note"><br><br>
  		<input type="submit" value="Conferma">
  		<input type="reset" value="Annulla">
	</form>
	</c:otherwise>
	</c:choose>

</body>
</html>