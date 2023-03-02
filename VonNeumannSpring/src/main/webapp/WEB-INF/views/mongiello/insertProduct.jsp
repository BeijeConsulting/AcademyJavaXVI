<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserisci prodotti</title>
</head>
<body>

<form action="./mongiello/insertProduct" method="post">
Name: <input type="text" name="name"><br>
Description: <input type="text" name="description"><br> 
Is Listed: <input type="text" name="isLListed"><br> 
Color:  <input type="text" name="color"><br> 
Category:  <input type="text" name="category"><br> 
Type:  <input type="text" name="type"><br> 
Brand:  <input type="text" name="brand"><br> 
<input type="submit" value="invia">
</form>

</body>
</html>