<%@page import="java.util.List"%>
<%@page import="it.beije.neumann.web.mercuri.Contatto"%>
<%@page import="it.beije.neumann.web.mercuri.RubricaJPA"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Gestore Rubrica</title>
	</head>
	
	<body>
		<form action="./rubrica" method = "post">
			<button name = "view" value="view" type="submit" formmethod="post" formaction="./rubrica"> view </button>		 
			<button name = "search" value= "search" type="submit" formmethod="post" formaction="./rubrica"> search </button>
			<button name = "delete" value= "delete" type="submit" formmethod="post" formaction="./rubrica"> delete </button>
			<button name = "add" value= "add" type="submit" formmethod="post" formaction="./rubrica"> add </button>
			<button name = "viewDuplicates"value= "viewD"  type="submit" formmethod="post" formaction="./rubrica"> view duplicates </button>
		</form>
		<br>

		<% if (session.getAttribute("view") != null && session.getAttribute("order") == null){
			out.println(session.getAttribute("view"));
			out.println(session.getAttribute("order"));
			%>
			<form action='./rubrica' method='post'>
				<label for='order'>Per quale campo vuoi ordinare?</label><br>
				<input type='text' name='order'><br>
				<input type='submit' value='Submit'>
			</form>
			<% 
		}	
		
		if (session.getAttribute("order") != null){	
			
			List<Contatto> contatti = (List<Contatto>) session.getAttribute("contatti");
			
			if (contatti != null)
				for(Contatto c: contatti)
					out.println(c +"<br>");
			
			session.removeAttribute("order");
			session.removeAttribute("view");
		}
		
		if (session.getAttribute("search") != null && session.getAttribute("field") == null){
			out.println(session.getAttribute("view"));
			out.println(session.getAttribute("order"));
			%>
			<form action='./rubrica' method='post'>
				<label for='field'>Per quale campo vuoi filtrare?</label><br>
				<input type='text' name='field'><br>
				<label for='value'>Valore: </label><br>
				<input type='text' name='value'><br>
				<input type='submit' value='Submit'>
			</form>
			<% 
		}	
		
		if (session.getAttribute("field") != null && session.getAttribute("value") != null){	
			
			List<Contatto> contatti = (List<Contatto>) session.getAttribute("contatti");
			
			if (contatti != null)
				for(Contatto c: contatti)
					out.println(c +"<br>");
			
			session.removeAttribute("field");
			session.removeAttribute("value");
		}
		
		%>
	</body>
</html>