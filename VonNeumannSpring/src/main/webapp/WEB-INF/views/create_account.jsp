<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	
		<form action="" method="post">
			
			<label for="username">NOME: </label>
			<input type="text" id="name" name="name"><br>
		
		
			<label for="username">COGNOME:</label>
			<input type="text" id="surname" name="surname"><br>
			
			
			<label for="email">EMAIL:</label>
			<input type="email" id="email" name="email"><br>
	
			<label for="password">PASSWORD:</label>
			<input type="password" id="password" name="password"><br>
			
			<label for="telephone">NUMERO DI TELEFONO:</label>
			<input type="text" id="telephone" name="telephone"><br>
			
			<label for="birth_date">DATA DI NASCITA:</label>
			<input type="date" id="birth_date" name="birth_date"><br>
			
			
	
			<input class="registrati-submit" type="submit" value="REGISTRATI">
		</form>
	</section>


</body>

<style>

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