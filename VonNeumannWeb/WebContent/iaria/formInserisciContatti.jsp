<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INSERISCI CONTATTO:</title>
<h1 align=center>Aggiungi i dati da inserire:</h1>
</head>
<body>

<%
//Prelevo id e lo trasformo in integer per poi passarlo come attributo in modo da
//fare una ricerca su inserisci contatto
Integer id = new Integer(request.getParameter("idcontatto"));
session.setAttribute("id", id);
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
	<input type="submit" value="Inserisci" name="insert"><br>
</form> 

</body>
</html>