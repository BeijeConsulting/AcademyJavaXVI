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
//per modificare contatto in base all'id e visualizza anche i contatti
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
//Se è stato cliccato il bottone di elimina, allora visualizza opzione
//per eliminare contatto in base all'id e visualizza anche i contatti
} else if(session.getAttribute("deleteContact")!=null) {
	%> 
	<h3 align=center>Inserisci id del contatto da eliminare:</h3>
	<form align="center" action="./eliminaContatto" method="post">
 		<label for="fid">ID:</label><br>
		<input type="text" name="idcontatto" value=""><br><br>
		<input type="submit" value="Elimina" name="modify"><br>
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
//Se è stato cliccato il bottone di ricerca duplicato
} else if(session.getAttribute("searchDuplicate")!=null){
	%>
	<h1 align=center>Duplicati:<h1>
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
//Se è stato cliccato il tasto per unire i duplicati
} else if(session.getAttribute("mergeDuplicate")!=null) {
	%> 
	<h3 align=center>Inserisci id del contatto da unire con i duplicati:</h3>
	<form align="center" action="./unisciDuplicati" method="post">
 		<label for="fid">ID:</label><br>
		<input type="text" name="idcontatto" value=""><br><br>
		<input type="submit" value="Elimina" name="modify"><br>
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
} else {
	List<Contatti> contatti = (List) session.getAttribute("contatti");
	%>
	<h1 align=center>Contatti:<h1>
	<%
	int riga = 0;
	if(!contatti.isEmpty()){
		for(Contatti c : contatti){
			riga++;
			%>
			</h1></h1><h3 align=center>Contatto id: <%= c.getId() %>, <%= c.getNome() %>, <%= c.getCognome() %>, <%= c.getTelefono() %>, <%= c.getEmail() %>, <%= c.getNote() %></h3>
			<%
		}
	} else {
		%><h3 align=center>Nessuna corrispondenza</h3><%
	}
}
%>

</body>
</html>