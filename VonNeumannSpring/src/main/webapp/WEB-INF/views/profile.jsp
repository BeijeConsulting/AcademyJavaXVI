<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PROFILE</title>
</head>
<body>

	<header>
		<h1><a href="home">ECOMMERCE SHOES</a></h1>
	</header>

	<div class="container">
		<h2>Il Mio Profilo</h2>
		<div class="field">
			<div class="label">Nome:</div>
			<div class="value">${user.name}</div>
		</div>
		<div class="field">
			<div class="label">Cognome:</div>
			<div class="value">${user.lastname}</div>
		</div>
		<div class="field">
			<div class="label">Email:</div>
			<div class="value">${user.email}</div>
		</div>
		<div class="field">
			<div class="label">Telefono:</div>
			<div class="value">${user.telephone}</div>
		</div>
			<div class="field">
			<div class="label">Data di Nascita:</div>
			<div class="value">${user.birthDate}</div>
		</div>
		<div class="btn-container">
			<a href="#" class="btn link">Storico Ordini</a>
			<a href="address" class="btn link">Indirizzi</a>
		</div>
	</div>
	
</body>

<style>
	
	body{
		margin: 0;
		font-family: Arial, Helvetica, sans-serif;
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

	.container {
		max-width: 1200px;
		margin: 0 auto;
		background-color: #fff;
		padding: 20px;
		border-radius: 5px;
		box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
	}
	h2 {
		text-align: center;
		margin-bottom: 30px;
	}
	.field {
		display: flex;
		margin-bottom: 20px;
	}
	.label {
		font-weight: bold;
		margin-right: 10px;
	}
	
	.btn {
		display: block;
		background-color: black;
		color: white;
		padding: 15px;
		border: 1px solid transparent;
		border-radius: 5px;
		text-align: center;
		text-decoration: none;
		font-size: 16px;
		cursor: pointer;
	}
	.btn:hover {
		background-color: white;
		color: black;
		border: 1px solid black;
	}
	.link {
		display: inline-block;
		margin-right: 10px;
	}
</style>

</html>