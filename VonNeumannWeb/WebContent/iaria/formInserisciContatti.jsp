<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INSERISCI CONTATTO:</title>
<h1 align=center>Inserisci i dati da inserire:</h1>
</head>
<body>

<%
%>

<form align="center" action="./inserisciContatti" method="post">
 	<label for="fnome">Nome:</label><br>
	<input type="text" name="nomecontatto" value=""><br><br>
	<label for="fcognome">Cognome:</label><br>
	<input type="text" name="cognomecontatto" value=""><br><br>
		<label for="ftelefono">Telefono:</label><br>
	<input type="text" name="telefonocontatto" value=""><br><br>
		<label for="femail">Email:</label><br>
	<input type="text" name="emailcontatto" value=""><br><br>
		<label for="fnote">Note:</label><br>
	<input type="text" name="notecontatto" value=""><br><br>
	<input type="submit" value="Cerca" name="search"><br>
</form> 

</body>
</html>