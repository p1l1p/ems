<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h3 class="text-center">Adding a new employee</h3>
<form action="add" method="post">
    <div class="form-group">
        <label for="id">ID</label>
        <input type="number" class="form-control" name="id" id="id" aria-describedby="ID" placeholder="Enter id">
    </div>
    <div class="form-group">
        <label for="firstname">First Name</label>
        <input type="text" class="form-control" name="firstname" id="firstname" placeholder="John">
    </div>
    <div class="form-group">
        <label for="lastname">Last Name</label>
        <input type="text" class="form-control" name="lastname" id="lastname" placeholder="Doe">
    </div>
    <button type="submit" class="btn btn-primary">Create</button>
</form>
</body>
</html>