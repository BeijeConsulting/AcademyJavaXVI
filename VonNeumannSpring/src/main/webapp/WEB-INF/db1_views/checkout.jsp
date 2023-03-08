<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title>Checkout</title>
</head>
<body>
	
	<!-- Navbar -->
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="./">Home</a>
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

<div class="container py-5">
	<div class="row">
		<div class="col">
			<form action="./checkout" method="post">
			  <c:choose>
	           <c:when test="${ not empty addresses }">
			   			 <label for="addresses">Size: </label>
			             <select name="addresses" id="addresses"  class="form-control">
							<option value="" selected disabled>Seleziona un indirizzo</option>
			    		  <c:forEach var="d" items="${ addresses }">
   					       <option value="${ d }"><c:out value="${d.label }"></c:out></option>
   					      </c:forEach>
				         </select>
	           </c:when>
	           <c:otherwise>
	           		<h3>Add new address</h3>
	           		
	           			<div class="mt-2">
							<label for="label" class="form-label">Label</label>
							<input name="label" id="text" type="text" class="form-control" placeholder="Label">
						</div>
						<div class="mt-2">
							<label for="name" class="form-label">Name and Surname</label>
							<input name="name" id="name" type="text" class="form-control" placeholder="Name and Surname">
						</div>
						<div class="mt-2">
							<label for="country" class="form-label">Country</label>
							<input name="country" id="country" type="text" class="form-control" placeholder="Country">
						</div>
						<div class="mt-2">
							<label for="street" class="form-label">Street address</label>
							<input name="street" id="street" type="text" class="form-control" placeholder="Street address">
						</div>
						<div class="mt-2">
							<label for="telephone" class="form-label">Telephone</label>
							<input name="telephone" id="telephone" type="text" class="form-control" placeholder="Telephone">
						</div>
						<div class="mt-2">
							<label for="zipcode" class="form-label">Zipcode</label>
							<input name="zipcode" id="zipcode" type="text" class="form-control" placeholder="Zipcode">
						</div>
						<div class="mt-2">
							<label for="instructions" class="form-label">Instructions</label>
							<input name="instructions" id="instructions" type="text" class="form-control" placeholder="Instructions">
						</div>
	           		
	           </c:otherwise>
             </c:choose> 
                  <div class="mt-2">
					<label for="card" class="form-label">Card</label>
					<input name="card" id="card" type="number" class="form-control" placeholder="Card">
				 </div>
             
                 <div>
					 <button type="submit" class="btn btn-primary mt-3">Checkout</button>			
		     	 </div>
		     	 
             </form>
		</div>
	</div>
</div>


</body>
</html>