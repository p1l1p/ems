<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Employee</title>
</head>
<body>
<h1>Beautiful and nice table</h1>
<table>
    <tr>
        <td>
            Id
        </td>
        <td>
            Firstname
        </td>
        <td>
            Lastname
        </td>
    </tr>
    <c:forEach items="${empList}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>