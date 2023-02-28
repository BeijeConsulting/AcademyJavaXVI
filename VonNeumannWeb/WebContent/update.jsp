<%@page import="it.beije.neumann.web.esercizi.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Contact</title>
</head>
<body>
<% String id = (String)request.getParameter("id");
   Contatto c = Rubrica.searchContact(id);
   String name = c.getName();
   String surname = c.getSurname();
   String phone = c.getTelephone();
   String email = c.getEmail();
   session.setAttribute("id", id);
   %>
   <form action="./update" method="post">
  		<label for="name">Name:</label><br>
  		<input type="text" name="name" value="<%=name%>"><br>
	    <label for="surname">Surname:</label><br>
  		<input type="text" name="surname" value="<%=surname%>"><br>
  		<label for="email">Email:</label><br>
  		<input type="text" name="email" value="<%=email%>"><br>
  		<label for="phone">Phone:</label><br>
  		<input type="text" name="phone" value="<%=phone%>"><br>
  		<a href="./contacts.jsp">Indietro</a>
  		<input type="submit" value="Submit">
	</form> 
</body>
</html>