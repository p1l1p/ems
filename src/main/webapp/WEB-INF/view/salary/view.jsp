<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Salary</title>
</head>
<body>
<h1>Beautiful and nice table</h1>
<table>
    <tr>
        <td>
            Employee
        </td>
        <td>
            Salary
        </td>
    </tr>
        <tr>
            <td>${salary.employeeName}</td>
            <td>${salary.amount}</td>
        </tr>
</table>
</body>
</html>