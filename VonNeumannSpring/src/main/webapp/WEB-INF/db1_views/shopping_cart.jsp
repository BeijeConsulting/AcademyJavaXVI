
<%@ page language="java" contentType="text/html; charset=UTF-8"
    		    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
               <h3>Shopping Cart</h3>
           </div>
 </div>

 <table class="table table-loght">
 
      <thead>
           <tr> 
               
               <th scope="col">Name</th>
               <th scope="col">Description</th>
               <th scope="col">Type</th>
               <th scope="col">Color</th>
               <th scope="col">Size</th>
               <th scope="col">Quantity</th>
               <th scope="col">Price</th>
               <th scope="col">        </th>
            </tr>
       </thead>
       <tbody>
        
               <tr>
                      
             <c:forEach var="p" items="${items}">
                 <tr>
                      <td>${p.productDetails.product.name}</td>
                      <td>${p.productDetails.product.description}</td>
                      <td>${p.productDetails.product.type}</td>
                      <td>${p.productDetails.product.color}</td> 
                      <td>${p.productDetails.size.EU}</td><br>
                     <td>${p.quantity}</td>
                     <td>${p.productDetails.product.listedPrice*p.quantity}</td>
                     <td> <a href="./delete?id=${p.id}">Delete</a></td>
                    </tr>
                   </c:forEach>
             
              
        </tbody>
               
 </table>   

   <div class="container">
           <div class="d-flex  py-3">
               <h3> Total Price :
                <c:out value="${totale}€">
                </c:out>
               
               </h3>
                 
               <a class="mx-3 btn-primary" href="#"> Checkout</a>
           </div>
       </div>

</body>
</html>