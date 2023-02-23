<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestore rubrica</title>
</head>
<body>
	<h1>Gestore rubrica</h1>
	<ul>
		<li><a href="RubricaServlet?action=vediListaContatti">Vedi lista contatti</a></li>
		<li><a href="RubricaServlet?action=cercaContatto">Cerca contatto</a></li>
		<li><a href="RubricaServlet?action=inserisciContatto">Inserisci nuovo contatto</a></li>
		<li><a href="RubricaServlet?action=modificaContatto">Modifica contatto</a></li>
		<li><a href="RubricaServlet?action=cancellaContatto">Cancella contatto</a></li>
		<li><a href="RubricaServlet?action=trovaContattiDuplicati">Trova contatti duplicati</a></li>
		<li><a href="RubricaServlet?action=unisciContattiDuplicati">Unisci contatti duplicati</a></li>
		<li><a href="RubricaServlet?action=esci">Esci</a></li>
	</ul>
</body>
</html>