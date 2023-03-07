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
 		<input type="text" name="name" value="${logged_user.name}"><br>
  		<label for="surname">Cognome</label><br>
  		<input type="text" name="surname" value="${logged_user.surname}"><br>
  		<label for="email">Email</label><br>
  		<input type="email" name="email" value="${logged_user.email}"><br>
  		<label for="password">Password</label><br>
  		<input type="text" name="password" value="${logged_user.password}"><br>
		<label for="telephone">Telefono</label><br>
  		<input type="text" name="telephone" value="${logged_user.telephone}"><br>
  		<label for="birthdate">Data di nascita</label><br>
  		<input type="date" name="birthdate" value="${logged_user.birthDate}"><br><br>
  		<input type="submit" value="Salva le modifiche">
	</form>
</body>
</html>