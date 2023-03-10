<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="it.beije.neumann.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME</title>
</head>
<body>

	<header>
	
		<h1><a href="home">ECOMMERCE SHOES</a></h1>
	


		<div class="header-right">
			<c:choose>
				<c:when test="${sessionScope.user != null}">
					<div>
						<a href="profile" class="black-link"> ${user.name} ${user.lastname}</a>
						<form action = "./logout"  method = "post">
							<!--  <input type="hidden" name="logOut" value="LOGOUT"> -->
							<input class="signin" type="submit" name="logOut" value="LOG OUT">
							
						</form>
					</div>
				</c:when>
				<c:otherwise>
					<button class="signin">
						<a href="login">
							SIGN IN
						</a>
					</button>
				</c:otherwise>
			</c:choose>	
			<form id="searchForm" method="get">
				<div class="searchProductName">
					<div>
						<button class="signin">
						<a href="show_cart">
							Carrello
						</a>
					</button>
						
					</div>
				</div>
			</form>
		</div>
	</header>
	


	<section class="filter">
		
		<form class="filter-form" method="GET" action="products_filtred">
			<div class="searchProductName">
			<input type="text" id="productName" name="name">
		</div>
		
			<div class="brand">
			  <label class="label-brand" for="brandName">CERCA BRAND</label>
			  <select name="brand">
			    <option value="">Tutti</option>
			    <c:forEach var="b" items="${brands}">
			    	<option value="${b}">${b}</option>
			    </c:forEach>
			  </select>
			</div>
			
			<div class="color">
			  <label class="label-price" for="color">SELEZIONA COLORE</label>
			   <input type="text" name="color">
			</div>
			
			<div class="price">
			  <label class="label-price">PREZZO MINIMO</label>
			  <input type="text" id="priceMin" name="minSellingPrice">
							 	
			  <label class="label-price">PREZZO MASSIMO</label>
			  <input type="text" id="priceMax" name="maxSellingPrice">
							 	
			</div>

			<div class="gender">
			  <label class="label-gender">SELEZIONA TIPO</label>
			  <select name="type">
			    <option value="">Tutti</option>
			    <c:forEach var="t" items="${types}">
			    	<option value="${t}">${t}</option>
			    </c:forEach>
			  </select>
			</div>
			
			<div class="category">
			  <label class="label-category">SELEZIONA CATEGORIA</label>
			  <select name="category">
			    <option value="">Tutti</option>
			    <c:forEach var="c" items="${categories}">
			    	<option value="${c}">${c}</option>
			    </c:forEach>
			  </select>
			</div>
			<input id="button-filtra" type="submit" value="Filtra">
		</form>
	</section>
	
	<c:choose>
		<c:when test= "${ !empty message}">
			<label class = "wrong">${message}</label> <br><br>
		</c:when>
	</c:choose>
	
	<section class="products">
	 <c:forEach var="p" items="${products}">
		<div class="product-card">
		  <img src="https://picsum.photos/200/300?grayscale" alt="">
		  <h2 class="product-name">${p.name}</h2>
		  <p class="product-price">$ ${p.listedPrice}</p>
		  <p class="product-brand">${p.brand}</p>
		  <p class="product-color">${p.color}</p>
		  <p class="product-description">Descrizione del prodotto</p>
		  <form action="./show_detail" method="get">
		  	<input type="submit" value="visualizza dettagli">
		  	<input type="hidden" name="id" value="${p.id}">
		  </form>
		</div>
	</c:forEach>
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
		text-decoration: none;
		color: white;
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
	
	.black-link {
	
		color: white;
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
	
	
	.products {
		margin: 60px;
		display: flex;
		flex-wrap: wrap;
		gap: 47px;
	
	}
	
	.product-card {
		border: 1px solid #ccc;
		border-radius: 5px;
		padding: 10px;
		width: 220px;
	}
	
	.product-card img {
		width: 220px;
		height: 220px;
		border-radius: 5px;
	}
	
	.product-card h2.product-name {
		font-size: 20px;
		margin: 10px 0;
	}
	
	.product-card p {
		margin: 5px 0;
	}
	
	.product-card p.product-price {
		font-weight: bold;
	}
	
	.product-card p.product-description {
		font-size: 14px;
	}
	
</style>
</html>

