<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% out.println("Contatto aggiunto correttamente"); %>
<form><button type="submit" formmethod="post" formaction="./rubrica?action=Visualizza lista contatti"> Visualizza lista contatti aggiornata</button><br><br>
</form>
<a href="http://localhost:7120/VonNeumannWeb/nicole/GestoreDiRubrica.jsp"> Torna al menù iniziale </a><br><br>

</body>
</html>