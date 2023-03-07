<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>
</head>
<body>
Welcome in <b>Von Neumann Spring Project</b>


<form action="./products_filtred" mthod="get">
Nome prodotto: <input type="text" name="name" ><br>
Colore: <input type="text" name="color"><br>
Category:  <select name="category">
			    <option value="">Tutti</option>
			    <option value="sneakers">Sneakers</option>
			    <option value="fashion">Fashion</option>
			    <option value="calcio">Calcio</option>
			    <option value="basket">Basket</option>
			 </select><br>
type: <select name="type">
			    <option value="">Tutti</option>
			    <option value="man">man</option>	 
	</select><br>
brand: <select name="brand">
			    <option value="">Tutti</option>
			    <option value="nike">nike</option>	 
	</select><br>	
	
	Prezzo minimo: <input type="text" name="minSellingPrice"><br>
	Prezzo massimo: <input type="text" name="maxSellingPrice"><br>
	<input type="submit" value="vai">
		    
</form>
</body>
</html>