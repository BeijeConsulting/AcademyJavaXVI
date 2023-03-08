<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title>Dettaglio</title>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="/">Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="./cart">Cart</a>
        </li>
        <li class="nav-item">
            <c:choose>
	       <c:when test="${ not empty user }"><a class="nav-link" href="./logout">Logout</a></c:when>
	       <c:otherwise>
	         <a class="nav-link" href="./login">Login</a>
	       </c:otherwise>
          </c:choose> 
        </li>
      </ul>
    </div>
  </div>
</nav>

<!-- Card Container  -->
<div class="py-5 container">
	<div class="row">
		
		<c:choose>
		<c:when test="${ not empty product }">
		
		<div class="col">
			<img src="${image.imagePath }" alt="img" width="500" height="600">
		</div>
		<div class="col">
			<h1><c:out value="${product.brand }"></c:out></h1>
			<h2><c:out value="${product.name }"></c:out></h2>
			<h4>Color: <c:out value="${product.color }"></c:out></h4>
			
			<div>
			<form action="./addItem" method="post">
			    <label for="productDetails">Size: </label>
				<select name="productDetails" id="productDetails"  class="form-control">
				
					<c:forEach var="d" items="${ details }">
   					 <option value="${d.id }"><c:out value="${d.size.EU }"></c:out></option>
   					</c:forEach>
				</select>
				<div class="mt-2">
				<label for="quantity">Inserisci la quantità: </label>
				<input name="quantity" type="number" class="form-control" min="1" max="${d.quantity }">
				</div>
				<div>
					 <button type="submit" class="btn btn-primary mt-3">Add to cart</button>			
		     	</div>
			</form>
			</div>
		</div>
		
		 </c:when>
		 <c:otherwise>
	         Nessun Prodotto
	       </c:otherwise>
         </c:choose> 
         
		
		
		
		
		
	</div>
</div>

</body>
</html>