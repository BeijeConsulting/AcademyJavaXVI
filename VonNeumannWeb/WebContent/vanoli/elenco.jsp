<%@page import="java.util.ArrayList"%>
<%@page import="it.beije.neumann.web.vanoli.rubricaWeb.RubricaJPAWeb"%>
<%@page import="it.beije.neumann.web.vanoli.rubricaWeb.Contatto"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ELENCO CONTATTI</title>
</head>
<body>

ordina per:
<form action="./elenco.jsp" method="get">
	<input type="radio" id="nome" name="ord" value="nome">
	<label for="nome">Nome</label><br>
	<input type="radio" id="cognome" name="ord" value="cognome">
	<label for="nome">Cognome</label><br>
  	<input type="submit" value="Submit">
</form>
<table>
  <tr>
    <th>Nome</th>
    <th>Cognome</th>
    <th>Telefono</th>
    <th>Email</th>
    <th>Note</th>
  </tr>
<%
	String ord = request.getParameter("ord");
	if (ord == null) {
		ord = "id";
	}
	System.out.println(ord);
	List<Contatto> contatti = RubricaJPAWeb.elencoRubrica(ord);
	for (Contatto c : contatti) { %>
	<tr>
		<th> <%= c.getNome() %> </th>
		<th> <%= c.getCognome() %> </th>
		<th> <%= c.getTelefono() %> </th>
		<th> <%= c.getEmail() %> </th>
		<th> <%= c.getNote() %> </th>
	</tr>
	<%} %>
</table>


</body>
</html>