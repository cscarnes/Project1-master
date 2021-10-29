package com.revature.dao;

import com.revature.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private Connection connection = null;
    private PreparedStatement preparedStment = null;
    private Statement statement = null;
    private ResultSet result = null;

    private static EmployeeDAO employee = new EmployeeDAO();

    public static EmployeeDAO instance(){
        if(employee == null)
        {
            employee = new EmployeeDAO();
        }
        return employee;
    }

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(
                "jdbc:postgresql://database-1.cuodwo1rggyl.us-east-2.rds.amazonaws.com/", "postgres", "Senrac02!");
    }

    public String getUsername(String username) throws SQLException {
        String retrievedUsername = "";
        String selectQuery = "SELECT username FROM employee WHERE username = '" + username + "'";
        statement = connection.createStatement();
        result = statement.executeQuery(selectQuery);
        while (result.next()) {
            retrievedUsername = result.getString("username");
        }
        return retrievedUsername;
    }

    public String getPassword(String password) throws SQLException {
        String retrievedPassword = "";
        String selectQuery = "SELECT password FROM employee WHERE password = '" + password + "'";
        statement = connection.createStatement();
        result = statement.executeQuery(selectQuery);
        while (result.next()) {
            retrievedPassword = result.getString("password");
        }
        return retrievedPassword;
    }

    public String getFirstName(String firstName) throws SQLException
    {
        String retrievedFirstName = "";
        String selectQuery = "SELECT first_name FROM employee WHERE first_name = '" + firstName + "'";
        statement = connection.createStatement();
        result = statement.executeQuery(selectQuery);
        while (result.next()) {
            retrievedFirstName = result.getString("first_name");
        }
        return retrievedFirstName;
    }

    public String getLastName(String lastName) throws SQLException
    {
        String retrievedLastName = "";
        String selectQuery = "SELECT last_name FROM employee WHERE last_name = '" + lastName + "'";
        statement = connection.createStatement();
        result = statement.executeQuery(selectQuery);
        while (result.next()) {
            retrievedLastName = result.getString("last_name");
        }
        return retrievedLastName;
    }

    public String getRole(String role) throws SQLException {
        String retrievedRole = "";
        String selectQuery = "SELECT role FROM reimbursement_project.user Where role = '" + role + "'";
        statement = connection.createStatement();
        result = statement.executeQuery(selectQuery);
        while (result.next()) {
            retrievedRole = result.getString("role");
        }

        return retrievedRole;
    }

    public List<Employee> getAllEmployees() throws SQLException {

        String sql = "SELECT * FROM reimbursement_project.user WHERE role = 'employee'";
        statement = connection.createStatement();
        result = statement.executeQuery(sql);
        List<Employee> retrievedEmployees = new ArrayList<Employee>();
        Employee employee;

        while(result.next()) {
            employee = new Employee();
            employee.setFirstName(result.getString("first_name"));
            employee.setLastName(result.getString("last_name"));
            employee.setUsername(result.getString("username"));
            employee.setPassword((result.getString("password")));
            employee.setRole(result.getString("role"));

            retrievedEmployees.add(employee);
        }

        return retrievedEmployees;
    }

    public Employee getEmployeeById(int eid) throws SQLException {
            String sql = "SELECT * FROM reimbursement_project.user WHERE id  = " + eid + " AND role = 'employee'";
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            Employee employee = new Employee();
            while(result.next()) {

                employee.setUsername(result.getString("username"));
                employee.setPassword(result.getString("password"));
                employee.setFirstName(result.getString("first_name"));
                employee.setLastName(result.getString("last_name"));
                employee.setRole(result.getString("role"));
            }
            return employee;
    }
}
