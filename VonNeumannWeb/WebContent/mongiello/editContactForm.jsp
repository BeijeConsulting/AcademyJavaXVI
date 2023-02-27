<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="it.beije.neumann.web.mongiello.Contatto"%>
<%@page import="it.beije.neumann.web.mongiello.RubricaJPA"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
  
  
  

 <%
 	List<Contatto> contatti = new ArrayList<>();
	contatti = (ArrayList) session.getAttribute("contatti");
 %>
 
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container text-center">
	<h1 class ="mt-2">Scegli il contatto da modificare</h1>
  <div class="row">
    <div class="col mt-2" >
    <form action="./choicheContactToEditServlet" method="get">
		<select class="form-select" aria-label="Default select example" name="contactToEdit">
  			<option selected>Seleziona</option>
  			<% for( Contatto c :  contatti ){%>
  				<option value="<%= c.getId() %>"> <%= c.getName()%> - <%=c.getSurname() %> </option>
  			<%} %>	
		</select>
		
	<input class ="ms-1 btn btn-primary mt-3"  type="submit" value="Modifica"/>	
	</form>
    </div>
  </div>
</div>





<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>