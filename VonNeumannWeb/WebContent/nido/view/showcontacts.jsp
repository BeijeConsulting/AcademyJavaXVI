<%@page import="java.util.List"%>
<%@page import="it.beije.neumann.web.nido.rubrica.model.Contact"%>
<%@page import="it.beije.neumann.web.nido.rubrica.model.RubricaJPAWeb"%>
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

	<p>
		<strong>Lista dei contatti</strong>
	</p>

	<%
	List<Contact> contacts = (List<Contact>) session.getAttribute("contacts");
	%>
	<%if(!contacts.isEmpty()){
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
	<br/>

	<%
	if(session.getAttribute("editEnabled")!=null) {
		if(contacts.size()==1){
			session.setAttribute("contact", contacts.get(0));
	%>
	<form action="../view/edit.jsp" method="post">
		<input type="submit" value="Modifica">
	</form>
	<% } else if(contacts.size()>0){
	%>
	<form action="../view/chooseid.jsp" method="post">
		<input type="submit" value="Scegli">
	</form>
	<%}%>

	<%
	} else if(session.getAttribute("deleteEnabled")!=null){
		if(contacts.size()==1){
			session.setAttribute("contact", contacts.get(0));
	%>
	<form action="../controller/deletecontact" method="post">
		<input type="submit" value="Cancella">
	</form>
	<% } else if(contacts.size()>0){
	%>
	<form action="../view/chooseid.jsp" method="post">
		<input type="submit" value="Scegli">
	</form>
	<%}
	}else {
		session.removeAttribute("contacts");
	}
	%>
	<% } else {%>
		<p><strong>Nessun contatto trovato!</strong></p>
	<%session.removeAttribute("contacts");
		}
	%>

</body>
</html>