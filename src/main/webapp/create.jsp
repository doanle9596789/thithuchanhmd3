<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employ Management Application</title>
</head>
<body>
<center>
    <h1>Employ Management</h1>
    <h2>
        <a href="EmployeeServlet?action=users">List All Employee</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Employee</h2>
            </caption>
            <tr>
                <th>Employee Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employ address:</th>
                <td>
                    <input type="text" name="address" id="address" size="15"/>
                </td>
            </tr> <tr>
                <th>Employ Phone:</th>
                <td>
                    <input type="text" name="phonenumber" id="phonenumber" size="15"/>
                </td>
            </tr> <tr>
                <th>Employ Salary:</th>
                <td>
                    <input type="text" name="salary" id="salary" size="15"/>
                </td>
            </tr> <tr>
                <th>Employ Department:</th>
                <td>
                    <input type="text" name="department" id="department" size="15"/>
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