<%@page import="java.util.List"%>
<%@page import="it.beije.neumann.web.nido.rubrica.Contact"%>
<%@page import="it.beije.neumann.web.nido.rubrica.RubricaJPAWeb"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca contatto da modificare</title>
</head>
<body>

	<form action="./operation4.jsp" method="post">
		<input type="submit" value="Back to op4">
	</form>

<%
String idcontact = request.getParameter("idcontact");
String name = request.getParameter("name");
String surname = request.getParameter("surname");

if(idcontact!=null){ //Secondo giro, ricerca su nome e cognome fatta
	/*
	out.print(idcontact);
	List<Contact> editing = (List<Contact>) session.getAttribute("multi_id");
	
	int id = Integer.parseInt(idcontact);
	Contact newC = new Contact();
	
	for (Contact e : editing) {
		if (e.getId() == id) {
			newC = e; //Cambiare
		}
	}
	*/
	session.setAttribute("message", "*Stiamo lavorando per voi :D*");
	response.sendRedirect("./menu.jsp");
	
} else { //Primo giro, va fatta la ricerca su nome e cognome
	out.print("id nullo");
	List<Contact> results = RubricaJPAWeb.getJPAManager().searchContact(name, surname);

	if (results.size()>0){
		
		if (results.size()==1){%>
			<table>
			<tr>
				<th align="left">ID</th>
				<th align="left">COGNOME</th>
				<th align="left">NOME</th>
				<th align="left">TELEFONO</th>
				<th align="left">EMAIL</th>
				<th align="left">NOTE</th>
			</tr>
			<% for(Contact contact : results){ %>
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
		<% //effettiva modifica
		} else {%>
			<p> C'è più di un contatto corrispondente</p>
			<table>
			<tr>
				<th align="left">ID</th>
				<th align="left">COGNOME</th>
				<th align="left">NOME</th>
				<th align="left">TELEFONO</th>
				<th align="left">EMAIL</th>
				<th align="left">NOTE</th>
			</tr>
			<% for(Contact contact : results){ %>
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
		<%session.setAttribute("multi_id", results); %>
		<form action="./edit.jsp" method="post">
			<label for="idcontact">Inserisci l'ID del contatto da modificare:</label><br>
			<input type="text" name="idcontact"><br> 
			<input type="submit" value="Ok">
		</form>
		<%}
}else {%>
<p>Nessun risultato per <%=name %> <%=surname %></p>
<%}
} %>
</body>
</html>