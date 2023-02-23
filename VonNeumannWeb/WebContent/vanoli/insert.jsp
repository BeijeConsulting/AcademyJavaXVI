<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN PAGE</title>
</head>
<body>

<%
System.out.println("session in login.jsp: " + session.getId());

String message = (String) session.getAttribute("message");
if (message != null) {
	%>
<span style="color: red; font-weight: bold"><%= message %></span>
<br/>
	<%
	session.removeAttribute("message");
}
%>
<form action="search" method="post">
  <label for="username">username:</label><br>
  <input type="text" name="username"><br>
  <label for="password">password:</label><br>
  <input type="text" name="password"><br><br>
  <input type="submit" value="Submit">
</form> 

</body>
</html>