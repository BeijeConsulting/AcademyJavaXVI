<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DETTAGLI PRODOTTO</title>
</head>
<body>

	<header>
	
		<h1><a href="home">ECOMMERCE SHOES</a></h1>

	</header>
	
	<section class="container">
		<div class="product-details">
			<div class="product-image">
				<img src="https://picsum.photos/200/300?grayscale" alt="">
			</div>
			<div class="product-info">
				<h2 class="product-name">Nome Prodotto</h2>
				<div class="product-brand">Brand</div>
				<div class="product-category">Categoria</div>
				<div class="product-type">Tipo</div>
				<div class="product-price">&euro; 99,99 <span>&euro; 119,99</span></div>
				<div class="product-sizes">
					<label for="size">Size:</label>
					<select id="size" name="size">
					<option value="35">35</option>
					<option value="36">36</option>
					<option value="37">37</option>
					<option value="38">38</option>
					<option value="39">39</option>
					<option value="40">40</option>
					<option value="41">41</option>
					<option value="42">42</option>
					<option value="43">43</option>
					<option value="44">44</option>
					<option value="45">45</option>
					<option value="46">46</option>
					<option value="47">47</option>
					<option value="48">48</option>
					</select>
				</div>
				<div class="product-description">Descrizione</div>
			</div>
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
	
	.container {
		width: 80%;
		margin: 0 auto;
		background-color: #fff;
		padding: 20px;
		box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
	}
	
	.product-image {
		float: left;
		margin-right: 20px;
	}
	.product-image img {
		max-width: 100%;
		height: auto;
	}
	.product-details {
		overflow: hidden;
		margin-bottom: 20px;
	}
	.product-name {
		font-size: 24px;
		font-weight: bold;
		margin-top: 0;
		margin-bottom: 10px;
	}
	.product-brand {
		font-size: 18px;
		font-weight: bold;
		color: #888;
		margin-bottom: 10px;
	}
	.product-category {
		font-size: 16px;
		color: #888;
		margin-bottom: 10px;
	}
	.product-type {
		font-size: 16px;
		color: #888;
		margin-bottom: 10px;
	}
	.product-price {
		font-size: 24px;
		font-weight: bold;
		color: #f00;
		margin-bottom: 10px;
	}
	.product-price span {
		font-size: 16px;
		color: #888;
		text-decoration: line-through;
		margin-left: 10px;
	}
	.product-description {
		font-size: 16px;
		line-height: 1.5;
		margin-bottom: 20px;
	}
	.product-sizes {
		margin-bottom: 20px;
	}

	

</style>

</html>