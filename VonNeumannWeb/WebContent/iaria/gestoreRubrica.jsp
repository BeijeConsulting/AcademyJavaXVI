<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GESTORE RUBRICA</title>
<h1 align=center>Gestore Rubrica:</h1>
</head>
<body>

<%
%>
<br/>

<%
%>

<form align="center" action="./leggiContatti" method="post">
  <input type="submit" value="Leggi contatti" name="readContact"><br><br>
</form> 

<form align="center" action="./formCercaContatti.jsp" method="post">
  <input type="submit" value="Cerca contatto" name="searchContact"><br><br>
</form> 

<form align="center" action="./formInserisciContatti.jsp" method="post">
	<input type="submit" value="Inserisci contatto" name="insertContact"><br><br>
</form> 

<form align="center" action="./leggiContatti" method="post">
	<input type="submit" name="modifyContact" value="Modifica contatto" ><br><br>
</form> 

<form align="center" action="./leggiContatti" method="post">
  <input type="submit" value="Cancella contatto" name="deleteContact"><br><br>
</form>

<form align="center" action="./cercaDuplicati" method="post">
  <input type="submit" value="Cerca duplicati" name="searchDuplicate"><br><br>
</form> 

<form align="center" action="./leggiContatti" method="post">
  <input type="submit" value="Unisci duplicati" name="mergeDuplicate"><br><br>
</form> 

<form align="center" action="./esportaCSV" method="post">
  <input type="submit" value="Esporta dati in CSV" name="exportCSV"><br><br>
</form> 

<form align="center" action="./importaCSV" method="post">
  <input type="submit" value="Importa dati da CSV" name="importCSV"><br><br>
</form> 

<form align="center" action="./esportaXML" method="post">
  <input type="submit" value="Esporta dati in XML" name="exportXML"><br><br>
</form> 

<form align="center" action="./" method="post">
  <input type="submit" value="Importa dati da XML" name="importXML"><br><br>
</form> 


</body>
</html>