<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>STORICO ORDINI</title>
</head>
<body>

	<header>
		<h1><a href="home">ECOMMERCE SHOES</a></h1>
	</header>

	<div class="container">
		<h2>STORICO ORDINI</h2>
		
		<div class="orders">
	
			<div class="order">
				<div class="order_header">
					<div class="order_id">ID Ordine: #001</div>
					<div class="order_date">Data transazione: 01/01/2023</div>
				</div>
				<div class="order_price">Prezzo totale: 50,00 &euro;</div>
				<div class="order_status">Stato pagamento: Pagato</div>
				<div class="order_link"><a href="order">Dettagli Ordine</a></div>
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
	
	.container {
		max-width: 1200px;
		margin: 0 auto;
	}

	.order {
		display: flex;
		flex-direction: column;
		margin-bottom: 1rem;
		padding: 1rem;
		border: 1px solid #ccc;
		border-radius: 0.5rem;
		background-color: #f4f4f4;
	}
	
	.order_header {
		display: flex;
		justify-content: space-between;
		align-items: center;
		margin-bottom: 0.5rem;
	}
	
	.order_id {
		font-weight: bold;
		margin-right: 0.5rem;
	}
	
	.order_price {
		font-weight: bold;
	}
	
	.order_link {
		text-align: right;
	}

</style>



</html>