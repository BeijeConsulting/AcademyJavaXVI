
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
<% %>
  
   
       <div class="container">
           <div class="d-flex  py-3">
               <h3> Total Price :
                <c:out value="${totale}">
                </c:out>
               
               </h3>
               
             <c:forEach var="p" items="${items}">
                     ${p.price}<br>
                     ${p.id}<br>
                     ${p.product_details_id}<br>
                     
             </c:forEach>
                    
               <a class="mx-3 btn-primary" href="#"> Checkout</a>
           </div>
       </div>

</body>
</html>