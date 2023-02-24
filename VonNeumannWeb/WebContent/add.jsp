<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Contact</title>
</head>
<body>
	<form action="./contatti" method="post">
  		<label for="name">Name:</label><br>
  		<input type="text" name="name" placeholder="nome"><br>
	    <label for="surname">Surname:</label><br>
  		<input type="text" name="surname" placeholder="surname"><br>
  		<label for="email">Email:</label><br>
  		<input type="text" name="email" placeholder="email"><br>
  		<label for="phone">Phone:</label><br>
  		<input type="text" name="phone" placeholder="phone"><br>
  		<a href="./contacts.jsp">Indietro</a>
  		<input type="submit" value="Submit">
	</form> 
</body>
</html>