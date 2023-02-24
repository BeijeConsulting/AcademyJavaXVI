<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INSERIMENTO NUOVO CONTATTO</title>
</head>
<body>

<form action="./api/insert" method="post">
  <label for="nome">Nome:</label><br>
  <input type="text" name="nome"><br>
  <label for="cognome">Cognome:</label><br>
  <input type="text" name="cognome"><br><br>
  <label for="telefono">Telefono:</label><br>
  <input type="text" name="telefono"><br><br>
  <label for="email">Email:</label><br>
  <input type="text" name="email"><br><br>
  <label for="note">Note:</label><br>
  <input type="text" name="note"><br><br>
  <input type="submit" value="Inserisci">
</form> 

<form action="./elenco.jsp" method="get">
  <input type="submit" value="Indietro">
</form>

</body>
</html>