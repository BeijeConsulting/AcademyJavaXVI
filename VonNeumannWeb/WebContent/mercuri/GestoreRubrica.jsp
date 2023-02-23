<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Gestore Rubrica</title>
	</head>
	
	<body>
		<form action="./rubrica">
		<button name = "view" value="view" type="submit" formmethod="post" formaction="./rubrica"> view </button>
		<button name = "search" value= "search" type="submit" formmethod="post" formaction="./rubrica"> search </button>
		<button name = "delete" value= "delete" type="submit" formmethod="post" formaction="./rubrica"> delete </button>
		<button name = "add" value= "add" type="submit" formmethod="post" formaction="./rubrica"> add </button>
		<button name = "viewDuplicates"value= "viewD"  type="submit" formmethod="post" formaction="./rubrica"> view duplicates </button>
		</form>
		
		<% out.println((String) session.getAttribute("view"));%>
		<% out.println((String) session.getId());%>
		<% if (request.getParameter("view") != null){
			%>
			view chiamato
			<% 
		}
		%>
	</body>
</html>