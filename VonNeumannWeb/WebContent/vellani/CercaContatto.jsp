<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="it.beije.neumann.web.vellani.Contatto" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="RubricaServlet" method="get">
	    <label for="inputRicerca">Ricerca contatto per nome:</label>
	    <input type="text" id="inputRicerca" name="nomeContatto">
	    <button type="submit" name="action" value="cercaContatto">Cerca</button>
	</form>
	
	<table>
	    <thead>
	        <tr>
	            <th>ID</th>
	            <th>Nome</th>
	            <th>Cognome</th>
	            <th>Email</th>
	        </tr>
	    </thead>
	    <tbody>
	        <% List<Contatto> contatti = (List<Contatto>) session.getAttribute("contatti");
	           if (contatti != null) {
	               for (Contatto contatto : contatti) {
	                   %>
	                   <tr>
	                       <td><%= contatto.getId() %></td>
	                       <td><%= contatto.getName() %></td>
	                       <td><%= contatto.getSurname() %></td>
	                       <td><%= contatto.getEmail() %></td>
	                   </tr>
	                   <% 
	               }
	           } else {
	               %>
	               <tr>
	                   <td>Nessun contatto trovato</td>
	               </tr>
	               <% 
	           } %>
	    </tbody>
	</table>
</body>
</html>