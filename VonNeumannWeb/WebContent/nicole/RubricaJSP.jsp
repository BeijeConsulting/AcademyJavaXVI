<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>rubrica</title>
</head>
<body>

<%@ page import="java.util.*" 

%>
<%@page import= "it.beije.neumann.web.verzaschi.*" %>
<%

List<Contact> contatti=  (List<Contact>) session.getAttribute("contactss");

    
out.println(" NAME    SURNAME    TELEPHONE   EMAIL   NOTE  <br><br>");

for(Contact c : contatti){
	out.println(c.getName()+"  | "+c.getSurname()+"  | "+c.getTelephone()+"  | "+c.getEmail()+" |  "+c.getNote());
	out.println("<br>");
	}
	%>


</body>
</html>