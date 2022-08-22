<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Employee</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container-fluid p-5 bg-primary text-white text-center">
    <h1>Employee Table</h1>
</div>
<table class="table table-sm table-bordered">
    <thead>
    <tr>
        <th class="text-center"  scope="col">
            Id
        </th>
        <th class="text-center"  scope="col">
            Full Name
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${empList}" var="employee">
        <tr>
            <th scope="row">
            ${employee.id}</th>
            <th scope="row">
            <a href="/salary/employee/${employee.id}">${employee.lastName}, ${employee.firstName}</a>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>