<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

	<!-- Header da mettere ovunque, da aggiungere il controllo per signout invece di signin e register -->
	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand" href="db3">Beije - Shoes First</a>
		<div class="navbar-brand" id="navbarNav">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item">
					<a class="nav-link" href="db3/signin">Sign-In</a>
				</li>
				<br>
				<li class="nav-item">
					<a class="nav-link" href="db3/signout">Sign-Out</a>
				</li>
			</ul>
		</div>
	</nav>
	<!-- Header da mettere ovunque -->
    <div class="container">
        <h1>Product List</h1>
        <div class="row">
            <c:forEach var="productDetail" items="${productDetails}">
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${product.sellingPrice}</h5>
                            <p class="card-text">${product.quantity}</p>
                            <a href="#" class="btn btn-primary">View Details</a>
                        </div>
                    </div>
                </div> 
            </c:forEach> 
        </div> 
    </div> 

    <!-- JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    <!-- Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.3/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZEIpx7kt/6TkMhLk7U6I3M" crossorigin="anonymous"></script>

</body> 
</html> 