<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" 

%>
<%@page import= "it.beije.neumann.web.verzaschi.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualizza Contatto/i elimanto/i</title>



</head>
<body>
<%out.println("Contatti appena eliminati dalla tua rubrica: "); %>

<% List<Contact> contatti=  (List<Contact>) session.getAttribute("contatti");

out.println("<br>");
out.println(" NAME    SURNAME    TELEPHONE   EMAIL   NOTE  <br><br>");

for(Contact c : contatti){
	out.println(c.getName()+"  | "+c.getSurname()+"  | "+c.getTelephone()+"  | "+c.getEmail()+" |  "+c.getNote());
	out.println("<br>");
	}
	%>
<br>	

<a href="http://localhost:7120/VonNeumannWeb/nicole/GestoreDiRubrica.jsp"> Torna al menù iniziale </a>

</body>


</html>