<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci i dati del contatto da eliminare</title>
</head>
<body>
<%out.println("Inserisci i dati del contatto da eliminare:"); %><br>

<br>

<form action="./datiContatto" method="post">
  <label for="name">name:</label><br>
  <input type="text" name="name"><br>
  <label for="surname">surname:</label><br>
  <input type="text" name="surname"><br><br>
  
  <button type="submit" formmethod="post" formaction="./datiContatto?action=Cancella contatto"> Cancella contatto</button> <br/>
  
</form> 
</body>
</html>