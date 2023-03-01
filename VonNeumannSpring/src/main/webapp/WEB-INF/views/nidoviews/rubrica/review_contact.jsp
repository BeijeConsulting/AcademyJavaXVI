<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Riepilogo contatto</title>
</head>
<body>

	<form action="./menu" method="get">
		<input type="submit" value="Back to menu">
	</form>
	
	<!--% String operation = null;
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
	%-->

<p><strong>Riepilogo contatto:</strong></p><br/>
	ID: ${savedContact.id}<br>
	NOME: ${savedContact.name}<br>
	COGNOME: ${savedContact.surname}<br>
	TELEFONO: ${savedContact.telephone}<br>
	EMAIL: ${savedContact.email}<br>
	NOTE: ${savedContact.note}<br><br>
</body>
</html>