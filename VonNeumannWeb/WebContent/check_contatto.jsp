<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CHECK CONTATTO</title>
</head>
<body>
<p>Confermi di voler inserire un nuovo contatto con i seguenti dati?</p>


COGNOME:<jsp:getProperty property="surname" name="nuovoContatto"/><br>
NOME:<jsp:getProperty property="name" name="nuovoContatto"/><br>
TELEFONO:<jsp:getProperty property="telephone" name="nuovoContatto"/><br>
EMAIL:<jsp:getProperty property="email" name="nuovoContatto"/><br>

</body>
</html>