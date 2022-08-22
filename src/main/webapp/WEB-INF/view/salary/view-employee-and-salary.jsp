<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Employee's Salary</title>
</head>
<body>
<h1>Beautiful and nice table</h1>
<table>
    <tr>
        <td>
            Salary id
        </td>
        <td>
            Employee Full Name
        </td>
        <td>
            Salary Amount
        </td>
    </tr>
    <tr>
        <td>${salary.employeeId}</td>
        <td>${employee.lastName}, ${employee.firstName}</td>
        <td>${salary.amount}</td>
    </tr>
</table>
</body>
</html>