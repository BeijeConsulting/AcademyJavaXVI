<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Scegli contatto</title>
</head>
<body>
	<form action="./menu.jsp" method="post">
		<input type="submit" value="Back to menu">
	</form>
	
	<p><strong>Inserisci l'id del contatto</strong></p>

	<form action="../controller/edit_contact" method="post">
  		<label for="idcontact">ID del contatto:</label><br>
 		<input type="text" name="idcontact"><br>
  		<input type="submit" value="Modifica">
	</form>

</body>
</html>