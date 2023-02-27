<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container text-center">
	<h1 class ="mt-2">Inserisci il contatto</h1>
  <div class="row">
    <div class="col mt-2" >
      <form action="./insertContactForm.jsp" method="post">
      	<div class="mb-3">
  			<label  class="form-label">Cognome</label>
  			<input type="text" class="form-control" placeholder="rossi" name="surname">
		</div>
		
		<div class="mb-3">
  			<label  class="form-label">Nome</label>
  			<input type="text" class="form-control" placeholder="rossi" name="name">
		</div>
		
		<div class="mb-3">
  			<label  class="form-label">Telefono</label>
  			<input type="text" class="form-control" name="telephone" >
		</div>
      
      <div class="mb-3">
  			<label  class="form-label">Email</label>
  			<input type="text" class="form-control" name="email">
		</div>
		
      <div class="mb-3">
  			<label  class="form-label">Note</label>
  			<input type="text" class="form-control" name="note">
		</div>
      
		<input class ="ms-1 btn btn-primary" type="submit" value="Inserisci">
      </form>
    </div>
  </div>
 
</div>


<jsp:useBean id="message" class="java.lang.String" scope="session"></jsp:useBean>
<jsp:useBean id="nuovoContatto" class="it.beije.neumann.web.mongiello.Contatto" scope="session"></jsp:useBean>
<jsp:setProperty property="name" name="nuovoContatto" param="name"/>
<jsp:setProperty property="surname" name="nuovoContatto" param="surname"/>
<jsp:setProperty property="telephone" name="nuovoContatto" param="telephone"/>
<jsp:setProperty property="email" name="nuovoContatto"/>
<jsp:setProperty property="note" name="nuovoContatto"/>
<%
	
	if ( nuovoContatto.getName() != null || nuovoContatto.getSurname() != null || nuovoContatto.getTelephone() != null && nuovoContatto.getEmail() != null || nuovoContatto.getNote()!= null ){
%>		
	<div class="container text-center mt-3">
		Sei sicuro di voler aggiungere il seguente contatto ?
  		<div class="row">
   			 <div class="col mt-2" >
     			<table class="table">
  						<thead>
    						<tr>
							      <th scope="col">Cognome</th>
							      <th scope="col">Nome</th>
							      <th scope="col">Telefono</th>
							      <th scope="col">Email</th>
							      <th scope="col">Note</th>
   							</tr>
  						</thead>
						  <tbody>
						    <tr>
						      <td><%= nuovoContatto.getSurname() %></td>
						      <td><%= nuovoContatto.getName() %></td>
						      <td><%= nuovoContatto.getTelephone() %></td>
						      <td><%= nuovoContatto.getEmail() %></td>
						      <td><%= nuovoContatto.getNote() %></td>
						    </tr>
						  </tbody>
					</table>
					
      		 </div>
      		 <form action="./InsertContactServlet" method="post">
      		  	<input type="submit"  class="btn btn-primary" value="Conferma">
      		 </form>
        </div>
    </div>	
<%		
	}	

%>

<% out.print(message);

	request.getSession().removeAttribute("message");%>
<%--	
	String message = (String) session.getAttribute("message");
	if( message != null ) out.print(message);
	session.removeAttribute("message");
--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>