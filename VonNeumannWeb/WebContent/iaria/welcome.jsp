<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME PAGE</title>
</head>
<body>

<%
System.out.println("session in welcome.jsp: " + session.getId());

String user = (String) session.getAttribute("username");

if (user != null) { 
%>
<p>
<strong>CIAO <%= user %></strong>
</p>
<p>
cosa vuoi fare adesso?
</p>
<%} else out.print("SESSIONE SCADUTA"); %>

</body>
</html>