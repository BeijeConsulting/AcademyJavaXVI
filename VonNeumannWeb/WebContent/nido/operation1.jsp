<%@page import="java.util.List"%>
<%@page import="it.beije.neumann.web.nido.rubrica.Contact"%>
<%@page import="it.beije.neumann.web.nido.rubrica.RubricaJPAWeb"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elenco contatti</title>
</head>
<body>

	<form action="./menu.jsp" method="post">
		<input type="submit" value="Back to menu">
	</form>
	
	<p><strong>Verranno visualizzati i contatti in ordine crescente per cognome</strong></p>
	<br/>
	
	<%
	List<Contact> contacts = RubricaJPAWeb.getJPAManager().showRubrica("ASC", "surname");
	%>
	
	<table>
		<tr>
			<th align="left">ID</th>
			<th align="left">COGNOME</th>
			<th align="left">NOME</th>
			<th align="left">TELEFONO</th>
			<th align="left">EMAIL</th>
			<th align="left">NOTE</th>
		</tr>
		<% for(Contact contact : contacts){ %>
		<tr>
   			<td align="left"><%= contact.getId() %></td>
    		<td align="left"><%= contact.getSurname() %></td>
    		<td align="left"><%= contact.getName() %></td>
    		<td align="left"><%= contact.getTelephone() %></td>
    		<td align="left"><%= contact.getEmail() %></td>
    		<td align="left"><%= contact.getNote() %></td>
 		</tr>
 		<%} %>
	</table>

</body>
</html>