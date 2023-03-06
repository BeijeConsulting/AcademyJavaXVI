
<%@ page language="java" contentType="text/html; charset=UTF-8"
    		    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title>Shopping Cart</title>
</head>
<body>

  
   
       <div class="container">
           <div class="d-flex  py-3">
               <h3> Total Price : 
                     <c:forEach var="p" items="${items}">
                     out.print()
		    
		    
  		             </c:forEach>
                    
               
               
                </h3>
                
            <c:forEach var="p" items="${orders}">
		        <div class="card" style="width: 18rem;">
  			<img src="..." class="card-img-top" alt="...">
 			<div class="card-body">
    		  <h5 class="card-title">${p.name}</h5>
   			  <p class="card-text">${p.description}</p>
              <a href="#" class="btn btn-primary">Dettaglio</a>
  			</div>
  		 </div>
  		</c:forEach>
               <a class="mx-3 btn-primary" href="#"> Checkout</a>
           </div>
       </div>

</body>
</html>