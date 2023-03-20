package service;

import conecttionDB.CreatDatabase;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceIplm implements EmployeeService {
    private static final String UPDATE_EMPLOY="update employee set name = ?,email= ?, address=?,phonenumber?,salary?,department? where id = ?";
    private static final String DELETE_EMPLOYEE=" delete from employee where id = ?;";
    private final String FIND_BY_NAME = "select id,name,email,address,phonenumber,salary,department from employee where name " +
            "like concat('%' , ? , '%') ;";
    private static final String SELECT_ALL_EMPLOYEE = "select * from employee";
    private static final String CREATE_EMPLOYEE = "insert into employee(name,email,address,phonenumber,salary,department)value (?,?,?,?,?,?)";


    Connection connection = null;

    @Override
    public void createEmployee(Employee employee) throws SQLException {
        connection = CreatDatabase.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CREATE_EMPLOYEE);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        preparedStatement.setString(3, employee.getAddress());
        preparedStatement.setString(4, employee.getPhoneNumber());
        preparedStatement.setString(5, employee.getSalary());
        preparedStatement.setString(6, employee.getDepartment());
        preparedStatement.executeUpdate();
    }

    @Override
    public List<Employee> searchEmployee(String name) throws SQLException {
        List<Employee> list = new ArrayList<>();
        connection = CreatDatabase.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME);
        preparedStatement.setString(1, "name");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            list.add(new Employee(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("address"),
                    rs.getString("phonenumber"),
                    rs.getString("salary"),
                    rs.getString("department")));

        }
        return list;
    }

    @Override
    public List<Employee> selectAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        connection = CreatDatabase.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phonnumber = rs.getString("phonenumber");
                String salary = rs.getString("salary");
                String department = rs.getString("department");
                Employee employee = new Employee(id, name, email, address, phonnumber, salary, department);
                employeeList.add(employee);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted;
        connection=CreatDatabase.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(DELETE_EMPLOYEE);
        preparedStatement.setInt(1,id);
        rowDeleted=preparedStatement.executeUpdate()>0;
return rowDeleted;
    }
    @Override
    public boolean updateEmployee (Employee employee) throws SQLException {
        boolean rowUpdated;
        try (
                Connection connection = CreatDatabase.getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOY);) {
            statement.setInt(1,employee.getId());
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getEmail());
            statement.setString(4, employee.getAddress());
            statement.setString(5, employee.getPhoneNumber());
            statement.setString(6, employee.getSalary());
            statement.setString(7, employee.getDepartment());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;

    }
}
