<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="it.beije.neumann.web.iaria.rubrica.Contatti"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GESTORE RUBRICA</title>
<h1 align=center>LISTA CONTATTI:</h1>
</head>
<body>

<%
List<Contatti> contatti = (List) session.getAttribute("contatti");
int riga = 0;
%>
<br/>

<%
for(Contatti c : contatti){
	riga++;
%>
<h3 align=center>Contatto numero <%= riga %>: <%= c.getNome() %>, <%= c.getCognome() %>, <%= c.getTelefono() %>, <%= c.getEmail() %>, <%= c.getNote() %></h3>
<%
}
%>

</body>
</html>