<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestore di Rubrica</title>
</head>
<body>

<%out.println("Benvenuto in Rubrica! Seleziona l'operazione desiderata:" );
%><br>
<form>
<button type="submit" formmethod="post" formaction="./rubrica?action=Visualizza lista contatti"> Visualizza lista contatti</button><br><br>
<button type="submit" formmethod="post" formaction="./rubrica?action=Cancella contatto"> Cancella contatto</button> <br/><br>

<button type="submit" formmethod="post" formaction="./rubrica?action=Inserisci nuovo contatto"> Inserisci nuovo contatto </button> <br><br>

<button type="submit" formmethod="post" formaction="./rubrica?action=Visualizza contatti duplicati"> Visualizza contatti duplicati</button>

</form>

</body>
</html>