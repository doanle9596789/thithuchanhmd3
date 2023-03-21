package controller;

import model.Employee;
import service.EmployeeService;
import service.EmployeeServiceIplm;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService=new EmployeeServiceIplm();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acction=request.getParameter("acction");
        if (acction==null){
            acction="";
        }
        switch (acction){
            case "create":
                showcreateEmployee(request,response);
                break;
            case "delete":
                deleteEmPloyee(request,response);
                break;
            case "edit":
                ShowUpdateEmployee(request,response);
                break;
            default:
                listEmployees(request,response);
        }
    }
    private void ShowUpdateEmployee(HttpServletRequest request, HttpServletResponse response){

        try {
            int id = Integer.parseInt(request.getParameter("id"));
           Employee employee= employeeService.FindEmployeeById(id);
            request.setAttribute("employee",employee);
            request.getRequestDispatcher("update.jsp").forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showcreateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }
    public void listEmployees(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        List<Employee> list=new ArrayList<>();
        list=employeeService.selectAllEmployee();
        request.setAttribute("list",list);
        RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response);
    }
    public void updateEmployee(HttpServletRequest request,HttpServletResponse response){

        try {
            int id= Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String phonenumber = request.getParameter("phonenumber");
            String salary = request.getParameter("salary");
            String department = request.getParameter("department");
            Employee employee=new Employee(id,name,email,address,phonenumber,salary,department);
            employeeService.updateEmployee(employee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }


    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acction=request.getParameter("acction");
        if (acction==null){
            acction="";
        }
        switch (acction){
            case "create":
                createEmploy(request,response);
                break;
            case "edit":
                updateEmployee(request,response);
                break;
            case "search":
                searchEmployee(request,response);
            default:listEmployees(request,response);
        }
    }

    private void createEmploy(HttpServletRequest request, HttpServletResponse response) {
        try { String name = request.getParameter("name");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String phonenumber = request.getParameter("phonenumber");
            String salary = request.getParameter("salary");
            String department = request.getParameter("department");
            Employee employee=new Employee(name,email,address,phonenumber,salary,department);
            employeeService.createEmployee(employee);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private void deleteEmPloyee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
           employeeService.deleteEmployee(id);
           response.sendRedirect("EmployeeServlet");

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void searchEmployee(HttpServletRequest request,HttpServletResponse response){
        try {
            List<Employee>list=new ArrayList<>();
            String name=request.getParameter("searchName");
          list=  employeeService.searchEmployee(name);
          request.setAttribute("listS",list);
          RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
          dispatcher.forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

