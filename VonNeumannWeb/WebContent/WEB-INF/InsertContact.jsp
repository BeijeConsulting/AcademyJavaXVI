<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%out.println("Cancella contatto"); %>

<form action="./rubrica" method="get">
  <label for="name">name:</label><br>
  <input type="text" name="username"><br>
  <label for="surname">surname:</label><br>
  <input type="text" name="password"><br><br>
  <input type="submit" value="Submit">
</form> 
</body>
</html>