<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.beije.neumann.web.vellani.Contatto" %>
<%@ page import="java.util.List" %>
<%List<Contatto> contatti = (List<Contatto>) session.getAttribute("contatti");%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestore rubrica</title>
</head>
<body>
    <h1>Elenco contatti</h1>
      <table>
         <thead>
            <tr>
               <th>Nome</th>
               <th>Cognome</th>
               <th>Telefono</th>
               <th>Email</th>
               <th>Note</th>
            </tr>
         </thead>
         <tbody>
         	<% if (contatti != null) { 
               	 for (Contatto contatto : contatti) { %>
		            <tr>
		               <td><%= contatto.getName() %></td>
		               <td><%= contatto.getSurname() %></td>
		               <td><%= contatto.getTelephone() %></td>
		               <td><%= contatto.getEmail() %></td>
		               <td><%= contatto.getNote() %></td>
		            </tr>
		       <% }
              } else {
            	  %>
            	   	<h2>Nessun contatto trovato</h2>
            	  <%
              }%>
         </tbody>
      </table>
</body>
</html>