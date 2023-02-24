<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungi contatto</title>
</head>
<body>

	<form action="./menu.jsp" method="post">
		<input type="submit" value="Back to menu">
	</form>
	
	<p><strong>Inserisci i dati del contatto</strong></p>

	<form action="../controller/addcontact" method="post">
  		<label for="name">Nome</label><br>
 		<input type="text" name="name"><br>
  		<label for="surname">Cognome</label><br>
  		<input type="text" name="surname"><br>
  		<label for="telephone">Telefono</label><br>
  		<input type="text" name="telephone"><br>
 		<label for="email">Email</label><br>
  		<input type="text" name="email"><br>
  		 <label for="note">Note</label><br>
  		<input type="text" name="note"><br><br>
  		<input type="submit" value="Aggiungi">
	</form>

</body>
</html>