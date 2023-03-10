<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

<title>ERRORE!</title>
</head>
<body>
	<div class="container mt-5">
    <div class="row">
      <div class="col-md-6 offset-md-3">
        <div class="card">
          <div class="card-header">
            <h4>ERRORE!</h4>
          </div>
          <div class="card-body">
          <c:choose>
	       <c:when test="${not empty error}">${ error }</c:when>
          </c:choose>
            <form action="./" method="get">
              <button type="submit" class="btn btn-primary">Home</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>