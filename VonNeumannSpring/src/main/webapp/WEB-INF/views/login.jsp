<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
</head>
<body>

	<header>
	
		<h1><a href="home">ECOMMERCE SHOES</a></h1>

	</header>
	
	<section class="login-section">
		<form method="post" action="login.jsp">
			<label for="email">EMAIL</label>
			<input type="email" id="email" name="email" required><br><br>
			<label for="password">PASSWORD</label>
			<input type="password" id="password" name="password" required><br><br>
			<input class="sign-in-submit" type="submit" value="SIGN IN">
		</form>
		
		<div class="vertical-line"></div>
		
		<div>
			<h2>Non sei ancora registrato?</h2>
			<p>Clicca qui sotto per registrarti</p>
			
			<button class="button-crea-account">
				<a href="create_account">CREA ACCOUNT</a>
			</button>
		</div>
		
		
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
	
	.login-section {
		margin: 50px;
		display: flex;
		justify-content: space-around;
	}
	
	label{
		
		font-weight: bold;
		font-size: 20px;
		margin-right: 5px;
		
	}
	
	.vertical-line {
	
		width: 2px;
		height: 200px;
		background-color: black;
		
	}
	
	.sign-in-submit {
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
	
	.button-crea-account {
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
	
	.sign-in-submit:hover {
	  background-color: white;
	  color: black;
	  border: 1px solid black;
	}
	
	
	
	.button-crea-account:hover {
	  background-color: white;
	  border: 1px solid black;
	}
	
	.button-crea-account:hover a{
		color: black;
	}
	
	.button-crea-account a{
		text-decoration: none;
		color: white;
	}
	
</style>
</html>