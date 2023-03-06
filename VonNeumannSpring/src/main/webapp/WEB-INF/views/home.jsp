<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME</title>
</head>
<body>

	<header>
	
		<h1>ECOMMERCE SHOES</h1>
	
		
		<div class="header-right">
				
			<button class="signin">
				<a href="#">
					SIGN IN
				</a>
			</button>
		
		
			<form id="searchForm" method="get">
				<div class="searchProductName">
					<label class="label-search-product" for="productName">CERCA PRODOTTO</label>
					
					<div>
						<input type="text" id="productName" name="productName">
						<button id="button-search-product" type="submit">Cerca</button>
					</div>
					
				</div>
			</form>
		
		</div>

	
	</header>

	<section class="filter">
		
		<form class="filter-form" method="GET" action="">
			<div class="brand">
			  <label class="label-brand" for="brandName">CERCA BRAND</label>
			  <input type="text" id="brandName" name="brandName">
			</div>
			
			<div class="color">
			  <label class="label-price" for="color">SELEZIONA COLORE</label>
			  <select name="color">
			    <option value="">Tutti</option>
			    <option value="nero">Nero</option>
			    <option value="bianco">Bianco</option>
			    <option value="blu">Blu</option>
			    <option value="verde">Verde</option>
			    <option value="rosso">Rosso</option>
			    <option value="giallo">Giallo</option>
			  </select>
			</div>
			
			<div class="price">
			  <label class="label-price">SELEZIONA FASCIA PREZZI</label>
			  <select name="price_range">
			    <option value="">Tutti</option>
			    <option value="0-49.99">0 - 49.99</option>
			    <option value="50-99.99">50 - 99.99</option>
			    <option value="100-149.99">100 - 149.99</option>
			    <option value="150-199.99">150 - 199.99</option>
			    <option value="200-249.99">200 - 249.99</option>
			    <option value="250+">250 &lt;</option>
			  </select>
			</div>
			
			<div class="gender">
			  <label class="label-gender">SELEZIONA GENERE</label>
			  <select name="gender">
			    <option value="">Tutti</option>
			    <option value="uomo">Uomo</option>
			    <option value="donna">Donna</option>
			    <option value="unisex">Unisex</option>
			  </select>
			</div>
			
			<div class="category">
			  <label class="label-category">SELEZIONA CATEGORIA</label>
			  <select name="category">
			    <option value="">Tutti</option>
			    <option value="sneakers">Sneakers</option>
			    <option value="fashion">Fashion</option>
			    <option value="calcio">Calcio</option>
			    <option value="basket">Basket</option>
			  </select>
			</div>
			
			<input id="button-filtra" type="submit" value="Filtra">
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
	
	header{
		display: flex;
		justify-content: space-between;
		height: 100px;
		align-items: center;
		padding: 20px;
		background-color: black;
	}
	
	.header-right{
		display: flex;
	}
	
	.signin{
		background-color: white;
		margin-right: 10px;
		border-radius: 5px;
	}
	
	.signin:hover {
		cursor:pointer;
		opacity: 0.8;
	}
	
	.signin a{
		color: black;
		text-decoration: none;
	}
	
	.searchProductName , .brand , .price , .gender , .category, .color{
		display: flex;
		flex-direction: column;
	}
	
	.label-search-product {
	
		color: white;
		
	}
	
	.label-brand , .label-price , .label-search-product , .label-category , .label-gender {
		margin-bottom: 5px;
	}
	
	.filter-form{
		display: flex;
		padding: 20px;
		justify-content: space-around;
	}
	
	#button-filtra{
		
		color: white;
		background-color: black;
		width: 50px;
		border-radius: 5px;
	
	}
	
	#button-filtra:hover {
		color: black;
		background-color: white;
		cursor: pointer;
	}
	
	#button-search-product{
		background-color: white;
	}
	
	#button-search-product:hover{
		opacity: 0.8;
		cursor: pointer;
	}
	
</style>
</html>

