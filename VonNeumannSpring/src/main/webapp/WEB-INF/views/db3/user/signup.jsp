<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
</head>
<body>

	<form action="./signup" method="post">
	  <label for="name">Nome:</label><br>
	  <input type="text" name="name"><br>
	  <label for="surname">Cognome:</label><br>
	  <input type="text" name="surname"><br>
	  <label for="email">Email:</label><br>
	  <input type="email" name="email"><br><br>
	  <label for="password">Password:</label><br>
	  <input type="text" name="password"><br><br>
	  <label for="birthdate">Data di nascita:</label><br>
	  <input type="date" name="birthdate"><br><br>
	  <label for="telephone">Telefono:</label><br>
	  <input type="tel" name="telephone"><br>
	  <input type="submit" value="Submit">
	  <input type="reset" value="ANNULLA">
	</form> 
<!--  
<c:choose>
	<c:when test="${not empty contatto}">
		Confermi di voler inserire il seguente contatto?<br><br>
		NOME: ${contatto.name}<br>
		COGNOME: ${contatto.surname}<br>
		TELEFONO: ${contatto.telephone}<br>
		EMAIL: ${contatto.email}<br><br>
		<form action="./insert_contatto" method="post">
		  <input type="hidden" name="name" value="${contatto.name}"><br>
		  <input type="hidden" name="surname" value="${contatto.surname}"><br>
		  <input type="hidden" name="telephone" value="${contatto.telephone}"><br>
		  <input type="hidden" name="email" value="${contatto.email}"><br><br>
		  <input type="submit" value="OK">
		  <input type="reset" value="ANNULLA">
		</form> 
	</c:when>
	<c:otherwise>
		<form action="./form_contatto" method="post">
		  <label for="name">Nome:</label><br>
		  <input type="text" name="name"><br>
		  <label for="surname">Cognome:</label><br>
		  <input type="text" name="surname"><br>
		  <label for="email">Email:</label><br>
		  <input type="text" name="email"><br><br>
		  <label for="password">Password:</label><br>
		  <input type="text" name="password"><br><br>
		  <label for="birthdate">Data di nascita:</label><br>
		  <input type="text" name="birthdate"><br><br>
		  <label for="telephone">telefono:</label><br>
		  <input type="text" name="telephone"><br>
		  <input type="submit" value="Submit">
		  <input type="reset" value="ANNULLA">
		</form> 
	</c:otherwise>
</c:choose>
-->
</body>
</html>