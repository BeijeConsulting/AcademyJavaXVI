<%@page import="it.beije.neumann.web.vellani.Contatto"%>
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
<%--
String name = request.getParameter("name");
String surname = request.getParameter("surname");
//..
Contatto nuovoContatto2 = new Contatto();
nuovoContatto2.setName(name);
//..
session.setAttribute("nuovoContatto", nuovoContatto2);
--%>

<jsp:useBean id="nuovoContatto" class="it.beije.neumann.web.Contatto" scope="session"></jsp:useBean>
<jsp:setProperty property="name" name="nuovoContatto" param="nome"/>
<jsp:setProperty property="surname" name="nuovoContatto" param="cognome"/>
<jsp:setProperty property="telephone" name="nuovoContatto" param="telefono"/>
<jsp:setProperty property="email" name="nuovoContatto"/>

<%-- System.out.println(nuovoContatto); %>
<% System.out.println(nuovoContatto2); %>
<%= nuovoContatto == nuovoContatto2 --%>

COGNOME:<jsp:getProperty property="surname" name="nuovoContatto"/><br>
NOME:<jsp:getProperty property="name" name="nuovoContatto"/><br>
TELEFONO:<jsp:getProperty property="telephone" name="nuovoContatto"/><br>
EMAIL:<jsp:getProperty property="email" name="nuovoContatto"/><br>

</body>
</html>