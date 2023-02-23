<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<form action="./rubrica" method="post">
		<label for="operation">Inserisci l'operazione</label><br>
		<input type="text" name="operation"><br>
		<input type="submit" value="Submit">
	</form>
	<br/>
	<%
	String message = (String) session.getAttribute("message");
		if (message != null) {
	%>
	<span style="color: red; font-weight: bold"><%= message %></span>
	<br/>
	<%
	session.removeAttribute("message");
	}
	%>
</body>
</html>