<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="it.beije.neumann.web.vanoli.rubricaWeb.RubricaJPAWeb"%>
<%@page import="it.beije.neumann.web.vanoli.rubricaWeb.Contatto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EDIT CONTATTO</title>
</head>
<body>

<%
String s = request.getParameter("id");
Integer id = Integer.parseInt(s);
Contatto c = RubricaJPAWeb.findContattoById(id);	
session.setAttribute("id", id);
%>

<form action="./api/edit" method="post">
  <label for="nome">Nome:</label><br>
  <input type="text" name="nome" value="<%=c.getNome()%>"><br>
  <label for="cognome">Cognome:</label><br>
  <input type="text" name="cognome" value="<%=c.getCognome()%>"><br><br>
  <label for="telefono">Telefono:</label><br>
  <input type="text" name="telefono" value="<%=c.getTelefono()%>"><br><br>
  <label for="email">Email:</label><br>
  <input type="text" name="email" value="<%=c.getEmail()%>"><br><br>
  <label for="note">Note:</label><br>
  <input type="text" name="note" value="<%=c.getNote()%>"><br><br>
  <input type="submit" value="Modifica Contatto">
</form>

<form action="./api/delete" method="post">
  <input type="submit" value="Cancella Contatto">
</form>

<form action="./elenco.jsp" method="get">
  <input type="submit" value="Indietro">
</form>

</body>
</html>