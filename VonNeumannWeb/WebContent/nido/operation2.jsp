<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca contatto</title>
</head>
<body>

	<form action="./menu.jsp" method="post">
		<input type="submit" value="Back to menu">
	</form>

<form action="./searchby.jsp" method="post">
  <label for="name">Nome del contatto da cercare:</label><br>
  <input type="text" name="name"><br>
  <label for="surname">Cognome del contatto da cercare:</label><br>
  <input type="text" name="surname"><br>
  <input type="submit" value="Cerca">
</form> 

</body>
</html>