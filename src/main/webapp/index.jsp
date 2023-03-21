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
    <form action="EmployeeServlet?acction=search" style="margin-bottom: 5px" method="post">
        <input type="text" placeholder="Employee name" name="searchName">
        <input type="submit" value="search">
    </form>
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
    <c:if test="EmployeeServlet?acction==search">
    <c:forEach items="${listS}" var="e">

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
            <td><a href="EmployeeServlet">back</a></td>
        </tr>
    </c:forEach>
    </c:if>

</table></div>

</body>
</html>