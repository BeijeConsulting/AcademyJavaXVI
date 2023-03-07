
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
 <hr size=5>
 
 <table class="table table-loght">
      <thead>
           <tr> 
               <th scope="col">Image</th>
               <th scope="col">Name</th>
               <th scope="col">Description</th>
               <th scope="col">Color</th>
               <th scope="col">Type</th>
               <th scope="col">Quantity</th>
               <th scope="col">Price</th>
            </tr>
       </thead>
       <tbody>
            <c:forEach var="p" items="${details}">
                     <td>      </td>
                      <td>${p.product_id.name}</td><br>
                      <td>${p.product_id.description}</td><br>
                      <td>${p.product_id.color}</td><br>
                      <td>${p.product_id.type}</td><br>
                      <td>${p.quantity}</td><br>
                      <td>${p.selling_price}</td><br>
                     
             </c:forEach>
       
       
       
       
       
       </tbody>
               
 
 
 
 
 </table>
 <hr size=5> 
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