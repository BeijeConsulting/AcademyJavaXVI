<%@page import="it.beije.neumann.web.vellani.Contatto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TEST</title>
</head>
<body>

<%--
Contatto nuovoContatto = (Contatto) session.getAttribute("nuovoContatto");
if (nuovoContatto == null) {
	nuovoContatto = new Contatto();
	session.setAttribute("nuovoContatto", nuovoContatto);
}
--%>
<jsp:useBean id="nuovoContatto" class="it.beije.neumann.web.Contatto" scope="session"></jsp:useBean>

COGNOME:<jsp:getProperty property="surname" name="nuovoContatto"/><br>
NOME:<jsp:getProperty property="name" name="nuovoContatto"/><br>
TELEFONO:<jsp:getProperty property="telephone" name="nuovoContatto"/><br>
EMAIL:<jsp:getProperty property="email" name="nuovoContatto"/><br>

</body>
</html>