<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Product List</title>
</head>
<body>
  <h1>Product List</h1>
  <table>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Description</th>
      <th>Color</th>
      <th>Category</th>
      <th>Type</th>
      <th>Brand</th>
    </tr>
    <c:forEach var="product" items="${products}">
      <tr>
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td>${product.description}</td>
        <td>${product.color}</td>
        <td>${product.category}</td>
        <td>${product.type}</td>
        <td>${product.brand}</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>