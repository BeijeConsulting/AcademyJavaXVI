<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestore rubrica</title>
</head>
<body>
<p><strong>Operazioni disponibili</strong></p>
<ol>
  <li>Mostra l'elenco dei contatti</li>
  <li>Cerca un contatto</li>
  <li>Aggiungi un nuovo contatto</li>
  <li>Modifica un contatto esistente</li>
  <li>Cancella un contatto</li>
  <li>Trova contatti duplicati</li>
  <li>Unisci contatti duplicati</li>
</ol>
	<form action="./menu" method="post">
		<label for="operation">Inserisci l'operazione</label><br>
		<input type="text" name="operation"><br>
		<input type="submit" value=Avvia>
	</form>
	<br/>
	
	<c:choose>
		<c:when test="${not empty message}">
			<span style="color: red; font-weight: bold">${message}</span>
		</c:when>
	</c:choose>
	
</body>
</html>