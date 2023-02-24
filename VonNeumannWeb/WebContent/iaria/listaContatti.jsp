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
//Se è stato cliccato il bottone di modifica allora visualizza opzione
//per modificare id e visualizza anche i contatti
if(session.getAttribute("modificaButton")!=null){
	%> 
	<h3 align=center>Inserisci id del contatto da modificare:</h3>
	<form align="center" action="./formInserisciContatti.jsp" method="post">
 		<label for="fid">ID:</label><br>
		<input type="text" name="idcontatto" value=""><br><br>
		<input type="submit" value="Modifica" name="modify"><br>
	</form>
	 <%
	 List<Contatti> contatti = (List) session.getAttribute("contatti");
		int riga = 0;
		if(!contatti.isEmpty()){
			for(Contatti c : contatti){
				riga++;
				%>
				<h3 align=center>Contatto id: <%= c.getId() %>, <%= c.getNome() %>, <%= c.getCognome() %>, <%= c.getTelefono() %>, <%= c.getEmail() %>, <%= c.getNote() %></h3>
				<%
			}
		} else {
			%><h3 align=center>Nessuna corrispondenza</h3><%
		}
//Altrimenti visualizza solo i contatti perché è stato cliccato "Leggi contatti"
} else {
	List<Contatti> contatti = (List) session.getAttribute("contatti");
	int riga = 0;
	if(!contatti.isEmpty()){
		for(Contatti c : contatti){
			riga++;
			%>
			<h3 align=center>Contatto id: <%= c.getId() %>, <%= c.getNome() %>, <%= c.getCognome() %>, <%= c.getTelefono() %>, <%= c.getEmail() %>, <%= c.getNote() %></h3>
			<%
		}
	} else {
		%><h3 align=center>Nessuna corrispondenza</h3><%
	}
}
%>

</body>
</html>