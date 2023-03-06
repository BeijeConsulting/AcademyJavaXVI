<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

<title>register</title>
</head>
<body>
 <div class="container mt-5">
    <div class="row">
      <div class="col-md-6 offset-md-3">
        <div class="card">
          <div class="card-header">
            <h4>Register</h4>
          </div>
          <div class="card-body">
            <form action="./register" method="post">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" name="name" id="name" placeholder="Name">
              </div>
              <div class="form-group">
                <label for="surname">Surname</label>
                <input type="text" class="form-control" name="surname" id="surname" placeholder="Surname">
              </div>
              <div class="form-group">
                <label for="telephone">Telephone</label>
                <input type="text" class="form-control" name="telephone" id="telephone" placeholder="Telephone">
              </div>
             <div class="form-group">
                <label for="birthdate">Birthdate</label>
                <input type="text" class="form-control" name="birthdate" id="birthdate" placeholder="Birthdate">
              </div>
              <div class="form-group">
                <label for="email">Email address</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Enter email">
              </div>
              <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" name="password" id="password" placeholder="Password">
              </div>
              <a href="./register">Login page</a>
              <button type="submit" class="btn btn-primary">Registrati</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>