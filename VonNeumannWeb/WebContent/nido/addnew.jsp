<%@page import="java.util.List"%>
<%@page import="it.beije.neumann.web.nido.rubrica.Contact"%>
<%@page import="it.beije.neumann.web.nido.rubrica.RubricaJPAWeb"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Riepilogo contatto aggiunto</title>
</head>
<body>

	<form action="./menu.jsp" method="post">
		<input type="submit" value="Back to menu">
	</form>

<jsp:useBean id="newContact" class="it.beije.neumann.web.nido.rubrica.Contact" scope="session"></jsp:useBean>
<jsp:setProperty property="name" name="newContact"/>
<jsp:setProperty property="surname" name="newContact"/>
<jsp:setProperty property="telephone" name="newContact"/>
<jsp:setProperty property="email" name="newContact"/>
<jsp:setProperty property="note" name="newContact"/>

<%
RubricaJPAWeb.getJPAManager().addContact(newContact);
%>

<p><strong>Contatto aggiunto:</strong></p><br/>
<%=newContact %>

</body>
</html>