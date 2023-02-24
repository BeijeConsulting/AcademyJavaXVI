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

QUESTI SONO I CONTATTI DUPLICATI:

<table>
  <tr>
    <th>Nome</th>
    <th>Cognome</th>
    <th>Telefono</th>
    <th>Email</th>
    <th>Note</th>
  </tr>
<%	
	List<Contatto> contatti = (List<Contatto>)session.getAttribute("contatti");
	for (Contatto c : contatti) { %>
	<tr>
		<th> <%= c.getNome() %> </th>
		<th> <%= c.getCognome() %> </th>
		<th> <%= c.getTelefono() %> </th>
		<th> <%= c.getEmail() %> </th>
		<th> <%= c.getNote() %> </th>
		<th> 
			<form action="./api/edit" method="get">
				<input type="hidden" name="id" value="<%=c.getId()%>">
				<input type="submit" value="Modifica">
			</form>
		</th>		
	</tr>
	<%} %>
</table>

<form action="./duplicati" method="post">
	<input type="submit" value="Unisci Contatti Duplicati">
</form>

<form action="./elenco" method="get">
  <input type="submit" value="Indietro">
</form>


</body>
</html>