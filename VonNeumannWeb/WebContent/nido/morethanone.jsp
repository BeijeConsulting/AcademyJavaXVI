<%@page import="java.util.List"%>
<%@page import="it.beije.neumann.web.nido.rubrica.Contact"%>
<%@page import="it.beije.neumann.web.nido.rubrica.RubricaJPAWeb"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica contatto</title>
</head>
<body>

	<form action="./operation2.jsp" method="post">
		<input type="submit" value="Back to search">
	</form>

	<%
	List<Contact> searchResults = (List<Contact>) session.getAttribute("searchResults");
	String idcontact = request.getParameter("idcontact");
	
	if(idcontact==null){
	if(searchResults.size()==1){
		//singolo contatto da modificare (sistemare)
		Contact toEdit = searchResults.get(0);
	} else {//più contatti, ricerca tramite id nella lista dei risultati%>
		
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
		<% for(Contact contact : searchResults){ %>
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
	
	<!-- % session.setAttribute("multi_id", searchResults); % -->
	<form action="./morethanone.jsp" method="post">
		<label for="idcontact">Inserisci l'ID del contatto da modificare:</label><br>
		<input type="text" name="idcontact"><br> 
		<input type="submit" value="Ok">
	</form>
	<%}
	} else {
		//ricevo l'id
	}
	%>
</body>
</html>