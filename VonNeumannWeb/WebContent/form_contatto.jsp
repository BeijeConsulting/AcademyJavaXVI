<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INSERIMENTO NUOVO CONTATTO</title>
</head>
<body>

<form action="./check_contatto.jsp" method="post">
  <label for="nome">nome:</label><br>
  <input type="text" name="nome"><br>
  <label for="cognome">cognome:</label><br>
  <input type="text" name="cognome"><br>
  <label for="telefono">telefono:</label><br>
  <input type="text" name="telefono"><br>
  <label for="email">email:</label><br>
  <input type="text" name="email"><br><br>
  <input type="submit" value="Submit">
</form> 

</body>
</html>