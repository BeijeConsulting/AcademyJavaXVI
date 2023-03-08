<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title>Storico Ordini</title>
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
	       <c:when test="${ not empty user }"><a class="nav-link" href="./logout">Logout</a>
	          <li class="nav-item">
                <a class="nav-link" href="./orders">Your Orders</a>
              </li>
	       </c:when>
	       
	       <c:otherwise>
	         <a class="nav-link" href="./login">Login</a>
	       </c:otherwise>
          </c:choose> 
        </li>
      </ul>
    </div>
  </div>
</nav>

<div class="container">
           <div class="d-flex  py-3">
               <h3>Your Orders</h3>
           </div>
 </div>
 <table class="table table-loght">
 
      <thead>
           <tr> 
               
               <th scope="col">Order Id</th>
               <th scope="col">Order Status</th>
               <th scope="col">Date</th>
               <th scope="col">Quantity</th>
               <th scope="col">Total Price</th>
               
               
            </tr>
       </thead>
       <tbody>
        
               <tr>
                      
             <c:forEach var="p" items="${orders}">
                 <tr>
                      <td>${p.order.id}</td>
                      <td>${p.order.status}</td>
                      <td>${p.order.createdAt}</td>
                      <td>${p.quantity}</td> 
                      <td>${p.order.totalPrice}</td><br>
                    
                    
                    </tr>
            </c:forEach>
             
              
        </tbody>
               
 </table>   
 

</body>
</html>