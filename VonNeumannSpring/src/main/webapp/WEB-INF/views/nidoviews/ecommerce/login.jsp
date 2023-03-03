<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ECOMMERCE LOGIN</title>
</head>
<body>
	<form action="./user_details" method="get">
	  <label for="email">Email:</label><br>
	  <input type="text" name="email"><br><br>
	  <label for="password">Password:</label><br>
	  <input type="text" name="password"><br><br>
	  <input type="submit" value="ENTRA">
	  <input type="reset" value="ANNULLA">
	</form> 
</body>
</html>