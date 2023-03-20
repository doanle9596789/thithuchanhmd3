package service;

import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {
    public void createEmployee(Employee employee) throws SQLException;

    public List<Employee> searchEmployee(String name) throws SQLException;

    public List<Employee> selectAllEmployee();

    public boolean deleteEmployee(int id) throws SQLException;

    public boolean updateEmployee(Employee employee) throws SQLException;
}
