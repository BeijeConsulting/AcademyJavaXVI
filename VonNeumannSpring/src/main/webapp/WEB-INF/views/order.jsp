<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ORDER</title>
</head>
<body>

	<header>
		<h1><a href="home">ECOMMERCE SHOES</a></h1>
	</header>

	<div class="container">
		<h2>ORDINE</h2>
		<div class="order">
			<div class="order-item">
				<div class="item-details">
					<img src="https://picsum.photos/id/237/200/300" alt="" >
					<p class="item-name">Dunk</p>
					<p class="item-brand">Nike</p>
					<p class="item-size">Size: 43</p>
					<p class="item-color">Color: Black</p>
				</div>
				<div class="item-quantity">
					<p class="item-quantity-label">Quantità:</p>
					<p class="item-quantity-value">1</p>
				</div>
				<div class="item-price">
					<p class="item-price-label">Prezzo:</p>
					<p class="item-price-value">&euro; 99.99</p>
				</div>
			</div>
			
			<div class="order-total">
				<p class="total-label">Prezzo totale:</p>
				<p class="total-value"> &euro; 99.99</p>
			</div>
			<div class="order-payment">
				<p class="payment-label">Stato pagamento:</p>
				<p class="payment-value">Pagato</p>
			</div>
		</div>
	</div>
	
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

	.container{
		margin: 20px 50px;
	}
	
	.order {
	  padding: 20px;
	  background-color: #f4f4f4;
	  border: 1px solid #ccc;
	  border-radius: 5px;
	}
	
	.order h2 {
	  margin-top: 0;
	}
	
	.order-item {
	  display: flex;
	  justify-content: space-between;
	  margin-bottom: 10px;
	  border: 0.5px solid lightgray;
	  padding: 20px;
	  border-radius: 5px;
	}
	
	.item-details {
	  flex-grow: 1;
	}
	
	.item-details img {
	  width: 200px;
	  height: 200px;
	}
	
	.item-name {
	  font-weight: bold;
	  margin: 0;
	}
	
	.item-size, .item-color {
	  margin: 0;
	}
	
	.item-quantity-label, .item-price-label {
	  font-weight: bold;
	  margin: 0;
	  margin-right: 20px;
	}
	
	.item-quantity-value, .item-price-value {
	  margin: 0;
	}
	
	.order-total, .order-payment {
	  display: flex;
	  margin-top: 10px;
	}
	
	.total-label, .payment-label {
	  font-weight: bold;
	  margin: 0;
	  margin-top: 10px;
	}
	
	.total-value, .payment-value {
	  margin: 0;
	  margin-left: 10px;
	  margin-top: 10px;
	}

</style>

</html>