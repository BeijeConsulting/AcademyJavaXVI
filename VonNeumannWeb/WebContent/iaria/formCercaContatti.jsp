<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GESTORE RUBRICA</title>
<h1 align=center>Inserisci i dati da cercare:</h1>
</head>
<body>

<%
%>

<form align="center" action="./cercaContatti" method="post">
 	<label for="fname">Nome:</label><br>
	<input type="text" name="nomecontatto" value=""><br><br>
	<label for="fname">Cognome:</label><br>
	<input type="text" name="cognomecontatto" value=""><br><br>
	<input type="submit" value="Cerca" name="search"><br>
</form> 

</body>
</html>