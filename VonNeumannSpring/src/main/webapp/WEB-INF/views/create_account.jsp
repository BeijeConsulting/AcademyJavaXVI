<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--@ taglib prefix="form" uri="http://www.springframework.org/tags/form"--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CREATE ACCOUNT</title>
</head>
<body>

	<header>
	
		<h1><a href="home">ECOMMERCE SHOES</a></h1>

	</header>


	<section>
	
		<c:choose>
			<c:when test="${!empty emailExists}"><h3 class="wrong">email gia' esistente</h3></c:when>
		</c:choose>

		<form action="./create_account" method="post">
			
			<label for="name">NOME: </label>
			<input type="text" id="name" name="name"><br>
		
		
			<label for="lastname">COGNOME:</label>
			<input type="text" id="lastname" name="lastname"><br>
			
			
			<label for="email">EMAIL:</label>
			<input type="email" id="email" name="email"><br>
	
			<label for="password">PASSWORD:</label>
			<input type="password" id="password" name="password"><br>
			
			<label for="telephone">NUMERO DI TELEFONO:</label>
			<input type="text" id="telephone" name="telephone"><br>
			
			<label for="date">DATA DI NASCITA:</label>
			<input type="date" id="birthDate" name="birthDate"><br> 
				

			<input type="hidden" id="createdAt" name="createdAt"><br> 
			
	
			<input class="registrati-submit" type="submit" value="REGISTRATI">
		</form> 
		
		<%-- 		<form:form  method="post" action = "./create_account" modelAttribute = "user" >

			<form:label path="name">Name</form:label>
			<form:input path="name"/> <br>
			
			<form:label path="lastname">Surname</form:label>
			<form:input path="lastname"/> <br>
			
			<form:label path="email">Email</form:label>
			<form:input path="email"/> <br>
			
			<form:label path="password">Password</form:label>
			<form:input path="password"/> <br>
			
			<form:label path="telephone">Phone</form:label>
			<form:input path="telephone"/> <br>
			
			<form:label path="birthDate">Birth date</form:label>
			<form:input path="birthDate"/> <br>
			
			<input class="registrati-submit" type="submit" value="REGISTRATI"/>

		</form:form> --%>
	</section>


</body>

<style>
	.wrong {

		color: red;
	
	}
	body{
		margin: 0;
	}
	
	h1 {
		color: white;
		margin: 0;
	
	}
	
	h1 a{
		color: white;
		text-decoration: none;
	}
	
	header{
		display: flex;
		justify-content: space-between;
		height: 100px;
		align-items: center;
		padding: 20px;
		background-color: black;
	}
	
	section{
		margin: 50px;
	}
	
	label{
		margin-bottom: 5px;
		font-size: 20px;
		font-weight: bold;
	}
	
	input{
		margin-bottom: 20px;
	}
	
	.registrati-submit{
		background-color: black;
		border: 1px solid white;
		border-radius: 5px;
		color: white;
		padding: 12px 24px;
		text-align: center;
		display: inline-block;
		font-size: 16px;
		font-weight: bold; 
		cursor: pointer; 
	}
	
	.registrati-submit:hover {
	  background-color: white;
	  color: black;
	  border: 1px solid black;
	}

</style>

</html>