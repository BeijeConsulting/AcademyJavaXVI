<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica dettagli utente</title>
</head>
<body>
	<form action="./user_page" method="get">
		<input type="submit" value="Indietro">
	</form>
	
	<p><strong>Inserisci i dati da modificare</strong></p>

	<form action="./edit_user" method="post">
  		<label for="name">Nome</label><br>
 		<input type="text" name="name" value="${user.name}"><br>
  		<label for="surname">Cognome</label><br>
  		<input type="text" name="surname"><br>
  		<label for="telephone">Telefono</label><br>
  		<input type="text" name="telephone"><br>
 		<label for="email">Email</label><br>
  		<input type="text" name="email"><br>
  		 <label for="note">Note</label><br>
  		<input type="text" name="note"><br><br>
  		<input type="submit" value="Salva le modifiche">
	</form>
</body>
</html>