<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca contatto</title>
</head>
<body>

	<form action="./menu" method="get">
		<input type="submit" value="Back to menu">
	</form>

<form action="./search_contact" method="post">
  <label for="name">Nome del contatto:</label><br>
  <input type="text" name="name"><br>
  <label for="surname">Cognome del contatto:</label><br>
  <input type="text" name="surname"><br>
  <input type="submit" value="Cerca">
</form> 

</body>
</html>