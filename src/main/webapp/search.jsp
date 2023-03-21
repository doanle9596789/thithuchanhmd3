<%--
  Created by IntelliJ IDEA.
  User: 84983
  Date: 3/21/2023
  Time: 11:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2">
  <c:forEach items="${listSearch}" var="e">

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

</table>

</body>
</html>
