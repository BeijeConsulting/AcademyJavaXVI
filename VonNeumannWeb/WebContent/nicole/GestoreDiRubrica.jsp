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
%>
<form>
<button type="submit" formmethod="post" formaction="./rubrica?action=Cerca contatto"> Cerca contatto</button><br>
</form>
<form>
<button type="submit" formmethod="post" formaction="./rubrica?action=Cancella Contatto"> Cancella contatto</button> <br/>
</form>
<form> <button type="submit" formmethod="post" formaction="./rubrica"> Inserisci Contatto </button>
</form> 
<form>
<button type="submit" formmethod="post" formaction="./rubrica?action=Visualizza contatti duplicati"> Visualizza contatti duplicati</button>

</form>

</body>
</html>