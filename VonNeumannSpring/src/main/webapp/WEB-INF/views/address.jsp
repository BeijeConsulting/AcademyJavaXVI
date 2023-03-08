<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADDRESSES</title>
</head>
<body>

	<header>
		<h1><a href="home">ECOMMERCE SHOES</a></h1>
	</header>

	<div class="container">
	
		<h2>INDIRIZZI</h2>
		<div class="address-list">
			<div class="address">
				<input type="radio" name="address" value="1">
				<h2>Nome Cognome</h2>
				<p><label>Paese:</label> Italia</p>
				<p><label>Indirizzo:</label> Via Taccagni 90</p>
				<p><label>Telefono:</label> 0123456789</p>
				<p><label>CAP:</label> 00100</p>
				<p><label>Istruzioni:</label> Nessuna istruzione</p>
			</div>
		</div>
		
		
		
		
		
		
		
		<form action="" method="post">
			
			<label for="label">Tipo indirizzo: </label>
			<input type="text" name="label"><br>
			
		
			<label for="name_surname">Nome e Cognome:</label>
			<input type="text" name="name_surname"><br>
			
			<label for="country">Paese:</label>
			<input type="text" name="country"><br>
			
			<label for="street_address">Indirizzo:</label>
			<input type="text" name="street_address"><br>
			
			<label for="telephone">Telefono:</label>
			<input type="text" name="telephone"><br>
			
			<label for="zipcode">CAP:</label>
			<input type="text" name="zipcode"><br>
			
			<label for="instructions">Istruzioni per la consegna:</label>
			<textarea name="instructions"></textarea><br>
			
			<input type="submit" value="Aggiungi">
		</form>
	</div>
</body>

<style>

	body {
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
	
	.container{
		margin: 20px 50px
	}
	
	.address-list {
		display: flex;
		flex-wrap: wrap;
		margin-bottom: 20px;
	}
	
	.address {
		margin-right: 20px;
		margin-bottom: 20px;
		padding: 20px;
		background-color: #f4f4f4;
		border: 1px solid #dddddd;
		border-radius: 4px;
	}
	
	.address h2 {
		font-size: 18px;
		margin-top: 0;
		margin-bottom: 10px;
	}
	
	.address p {
		margin: 0;
		margin-bottom: 10px;
	}
	
	.address label {
		font-weight: bold;
		margin-right: 5px;
	}
	
	.form-container {
		width: 100%;
		max-width: 600px;
		margin: 0 auto;
		padding: 20px;
		background-color: #f4f4f4;
		border: 1px solid #dddddd;
		border-radius: 4px;
		box-sizing: border-box;
	}
	
	.form-container h2 {
		font-size: 24px;
		font-weight: bold;
		margin-top: 0;
		margin-bottom: 20px;
	}
	
	.form-group {
		margin-bottom: 20px;
	}
	
	.form-group label {
		display: block;
		font-weight: bold;
		margin-bottom: 5px;
	}
	
	.form-group input[type="text"],
	.form-group input[type="tel"],
	.form-group textarea {
		width: 100%;
		padding: 10px;
		font-size: 16px;
		border-radius: 4px;
		border: 1px solid #dddddd;
		box-sizing: border-box;
	}
	
	.form-group textarea {
		min-height: 100px;
		resize: vertical;
	}
	
	.btn {
		display: inline-block;
		padding: 10px 20px;
		background-color: #4CAF50;
		color: #ffffff;
		font-size: 16px;
		font-weight: bold;
		text-decoration: none;
		border-radius: 4px;
		cursor: pointer;
	}
	
	.btn:hover {
		background-color: #3e8e41;
	}
	
	form {
	  display: flex;
	  flex-direction: column;
	  align-items: center;
	  margin-top: 20px;
	}
	
	label {
	  margin-top: 10px;
	  font-weight: bold;
	}
	
	input[type="radio"] {
		margin-bottom: 10px;
	}
	
	input[type="text"], textarea {
	  width: 300px;
	  padding: 10px;
	  margin-top: 5px;
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  box-sizing: border-box;
	}
	
	input[type="submit"] {
	  background-color: black;
	  color: white;
	  padding: 10px 20px;
	  border: 1px solid white;
	  border-radius: 4px;
	  cursor: pointer;
	  margin-top: 20px;
	}
	
	input[type="submit"]:hover {
	  background-color: white;
	  color: black;
	  border: 1px solid black;
	}

</style>


</html>