<%@page import="java.util.List"%>
<%@page import="it.beije.neumann.web.nido.rubrica.model.Contact"%>
<%@page import="it.beije.neumann.web.nido.rubrica.model.RubricaJPAWeb"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Riepilogo contatto</title>
</head>
<body>

	<form action="./menu.jsp" method="post">
		<input type="submit" value="Back to menu">
	</form>
	
	<% String operation = null;
	if(session.getAttribute("editEnabled")!=null){
		operation = "modificato";
		session.removeAttribute("editEnabled");
	} else if (session.getAttribute("deleteEnabled")!=null){
		operation = "eliminato";
		session.removeAttribute("deleteEnabled");
	} else if (session.getAttribute("addEnabled")!=null){
		operation = "aggiunto";
		session.removeAttribute("addEnabled");
	}
	%>

<p><strong>Riepilogo contatto <%=operation %>:</strong></p><br/>
<%=session.getAttribute("contact") %>
<%
session.removeAttribute("contact");
%>

</body>
</html>