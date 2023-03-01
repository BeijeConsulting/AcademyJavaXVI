<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Impostazioni visualizzazione</title>
</head>
<body>

	<form action="./menu" method="get">
		<input type="submit" value="Back to menu">
	</form>

<p>Come vuoi visualizzare i dati?</p>
<form action="./show_contacts" method="get">
  <label for="onWhat">Ordina su (nome/cognome):</label><br>
  <input type="text" name="onWhat"><br>
  <label for="orderBy">Tipologia (asc/desc):</label><br>
  <input type="text" name="orderBy"><br>
  <input type="reset" value="Ripristina">
  <input type="submit" value="Visualizza">
</form>

</body>
</html>