<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CART</title>
</head>
<body>

	<header>
		<h1><a href="home">ECOMMERCE SHOES</a></h1>
	</header>
	
<!--  	<div class="container">
		<h2>CARRELLO</h2>
		<div class="products">
			<div class="product">
				<img src="https://picsum.photos/200/300?grayscale">
				<div>
					<div class="product-name">${productDetail.product.name}</div>
					<div class="product-brand">${productDetail.product.brand}</div>
					<div class="product-size">Taglia:${productDetail.size}</div>
					<div>
						<span class="product-price">&euro;${productDetail.product.listedPrice} </span>
						<span class="product-discount">&euro;  ${productDetail.sellingPrice}</span>
					</div>
				</div>
				<button class="product-remove">Rimuovi</button>
			</div>
		</div>
		<div class="total">Totale: &euro; 40</div>
		<button class="checkout">CHECKOUT</button>
	</div> -->
	
	
	
	
	<div class="container">
		<h2>CARRELLO</h2>
		<div class="products">
	 <c:forEach var="cartItem" items="${shoppingCartItemsList}">
			<div class="product">
				<img src="https://picsum.photos/200/300?grayscale">
				<div>
					<div class="product-name">${cartItem.productDetails.product.name}</div>
					<div class="product-brand">${cartItem.productDetails.product.brand}</div>
					<div class="product-size">Taglia:${cartItem.productDetails.size}</div>
					<div>
						<span class="product-price">&euro; ${cartItem.productDetails.product.listedPrice} </span>
						<span class="product-discount">&euro;  ${cartItem.productDetails.sellingPrice}</span>
					</div>
				</div>
				<button class="product-remove">Rimuovi</button>
			</div>
			</c:forEach>
		</div>
		
		<div class="total">Totale: &euro; ${totale}</div>
		<button class="checkout">CHECKOUT</button>
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
		margin: 20px 100px;
	}
	.product {
		display: flex;
		align-items: center;
		padding: 10px;
		border: 1px solid #ccc;
		margin-bottom: 10px;
	}
	
	.product img {
		width: 100px;
		margin-right: 20px;
	}
	.product-name {
		font-size: 18px;
		font-weight: bold;
		margin-bottom: 5px;
	}
	.product-brand {
		font-size: 14px;
		margin-bottom: 5px;
	}
	
	.product-size {
		font-size: 18px;
		font-weight: bold;
		margin-bottom: 5px;
	}
	.product-price {
		font-size: 16px;
		color: lightgray;
		text-decoration: line-through;
		margin-left: 10px;
	}
	
	.product-discount {
		font-size: 22px;
		font-weight: bold;
		color: red;
		margin-bottom: 10px;
		margin-left: 5px;
	}
	.product-remove {
		background-color: red;
		color: white;
		padding: 5px 10px;
		border: none;
		border-radius: 5px;
		cursor: pointer;
		margin-left: auto;
	}
	.total {
		font-size: 24px;
		font-weight: bold;
		margin-top: 20px;
	}
	.checkout {
		background-color: black;
		color: white;
		padding: 10px 20px;
		border: none;
		border-radius: 5px;
		cursor: pointer;
		margin-top: 20px;
	}
</style>

</html>