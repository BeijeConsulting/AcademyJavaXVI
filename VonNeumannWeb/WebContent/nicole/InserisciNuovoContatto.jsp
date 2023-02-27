<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci un nuovo contatto in rubrica </title>
</head>
<body>
<% out.println("Inserisci un nuovo contatto in rubrica: "); %><br><br>



<form action="./inserisciContatto" method="post">
  <label for="name">name:</label><br>
  <input type="text" name="name"><br>
  <label for="surname">surname:</label><br>
  <input type="text" name="surname"><br>
  <label for="telephone">telephone:</label><br>
  <input type="text" name="telephone"><br>
  <label for="email">email:</label><br>
  <input type="text" name="email"><br>
  <label for="note">note:</label><br>
  <input type="text" name="note"><br><br>
  
  <button type="submit" formmethod="post" formaction="./inserisciContatto"> Inserisci contatto</button> <br/>
  
</body>
</html>