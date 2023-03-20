<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Manager</title>
</head>
<body>

<div align="center">
    <h1><%= " List Employee" %>
</h1>
    <h2><a href="EmployeeServlet?acction=create"> Add Employee</a></h2>
    <br/>
<table border="1" cellpadding="5">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>PhoneNumber</td>
        <td>Salary</td>
        <td>Department</td>
        <td colspan="2">Acction</td>
    </tr>
    <c:forEach items="${list}" var="e">
        <tr>
            <td>${e.getId()}</td>
            <td>${e.getName()}</td>
            <td>${e.getEmail()}</td>
            <td>${e.getAddress()}</td>
            <td>${e.getPhoneNumber()}</td>
            <td>${e.getSalary()}</td>
            <td>${e.getDepartment()}</td>
            <td> <a href="EmployeeServlet?acction=edit&id=${e.getId()}" >Edit</a></td>
            <td> <a href="EmployeeServlet?acction=delete&id=${e.getId()}">Delete</a></td>
        </tr>
    </c:forEach>

</table></div>

</body>
</html>