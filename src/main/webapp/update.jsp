<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Management Application</title>
</head>
<body>
<center>
    <h1>Employee Management</h1>
    <h2>
        <a href="EmployeeServlet">Home Pages</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Employee
                </h2>
            </caption>
            <c:if test="${employee != null}">
                <input type="hidden" name="id" value="<c:out value='${employee.id}' />"/>
            </c:if>
            <tr>
                <th>Employ Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${employee.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${employee.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="country" size="15"
                           value="<c:out value='${employee.address}' />"
                    />
                </td>
            </tr><tr>
                <th>PhoneNumber:</th>
                <td>
                    <input type="text" name="country" size="15"
                           value="<c:out value='${employee.getPhoneNumber()}' />"
                    />
                </td>
            </tr><tr>
                <th>Salary:</th>
                <td>
                    <input type="text" name="country" size="15"
                           value="<c:out value='${employee.getSalary()}' />"
                    />
                </td>
            </tr><tr>
                <th>Department:</th>
                <td>
                    <input type="text" name="country" size="15"
                           value="<c:out value='${employee.getDepartment()}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>