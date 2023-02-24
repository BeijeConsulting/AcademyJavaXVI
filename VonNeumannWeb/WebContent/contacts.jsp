<%@page import="it.beije.neumann.web.esercizi.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contatti</title>
</head>
<body>
<div style="height: 30px; background-color: green; display: flex; justify-content: start; align-item: center">
<span style="color: white; font-size: 20px">Benvenuto nella tua rubrica</span>
</div>
	<%
List<Contatto> contacts = Rubrica.getContacts();
int i = 0;
String message = (String) session.getAttribute("message");
for(Contatto c : contacts) {
	i++;
	%>
<span style="color: red; font-weight: bold"><%= i %>) <%= c.getName() %>, <%=  c.getSurname() %> </span>
<br/>
	
	<%}%>
	
	<a href="./add.jsp">add</a>
</body>
</html>