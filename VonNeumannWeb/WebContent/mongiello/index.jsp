<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="it.beije.neumann.web.mongiello.Contatto"%>
     <%@page import="it.beije.neumann.web.mongiello.RubricaJPA"%>
    <%@page import="java.util.List"%>
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
	<div class="container text-center">
	<h1 class ="mt-2">Benvenuto nel gestore rubrica</h1>
	
  <div class="row">
    <div class="col mt-2" >
      <form action="./StampaDbServlet" method="get">
		<input class ="ms-1 btn btn-primary" type="submit" value="Visualizza">
      </form>
    </div>
  </div>
  
  <div class="row">
    <div class="col mt-2" >
		<a href="insertContactForm.jsp" class="btn btn-primary">Inserisci contatto</a>
         </div>
   </div> 
   
   <div class="row">
    <div class="col mt-2" >
     <form action="./EditContactServlet" method="get">
		<input class ="ms-1 btn btn-primary" type="submit" value="Modifica contatto">
      </form>
    </div>
   </div> 
   
</div>


<!-- STAMPA DATABASE -->
<%
	List<Contatto>contatti = (List)session.getAttribute("contatti");
	if( contatti != null ){
%>		
		<div class="container text-center">
			<div class="row">
    			<div class="col mt-2" >
					<table class="table">
  						<thead>
    						<tr>
     					 		<th scope="col">Id</th>
							      <th scope="col">Cognome</th>
							      <th scope="col">Nome</th>
							      <th scope="col">Telefono</th>
							      <th scope="col">Email</th>
							      <th scope="col">Note</th>
   							</tr>
  						</thead>
						  <tbody>
						  <% for( Contatto c: contatti){ %>
						    <tr>
						     <td scope="row"><%= c.getId() %></td>
						      <td><%= c.getSurname() %></td>
						      <td><%= c.getName() %></td>
						      <td><%= c.getTelephone() %></td>
						      <td><%= c.getEmail() %></td>
						      <td><%= c.getNote() %></td>
						    </tr>
						    <%} %>	
						  </tbody>
					</table>
    			</div>
  			</div>
		</div>
<%
	}
	session.removeAttribute("contatti");
%>

 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>