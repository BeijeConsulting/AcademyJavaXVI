<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
</head>
<body>

<h3 align=center>SignUp</h3>
	
	<form align=center action="./signup" method="post">
		<label for="name">Nome:</label><br>
		<input type="text" name="name" ><br>
		<label for="surname">Cognome:</label><br>
		<input type="text" name="surname" ><br>
		<label for="email">Email:</label><br>
		<input type="email" name="email" ><br><br>
		<label for="password">Password:</label><br>
		<input type="text" name="password"><br><br>
		<label for="birthdate">Data di nascita:</label><br>
		<input type="date" name="birthdate"><br><br>
		<label for="telephone">Telefono:</label><br>
		<input type="text" name="telephone"><br>
		<input type="submit" value="REGISTRATI">
		<input type="reset" value="ANNULLA">
	</form> 
	
	<c:choose>
		<c:when test="${not empty signup_error}">
			<h4 align=center style="color:red;">${signup_error}</h4>
		</c:when>
	</c:choose>

</body>
</html>