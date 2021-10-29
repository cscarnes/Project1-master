package com.revature.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.revature.model.Employee;
import com.revature.model.Manager;

public class ManagerDAO {

    private static ManagerDAO manager = null;

    private ManagerDAO(){
    }

    public static ManagerDAO instance(){
        if(manager == null) {
            manager = new ManagerDAO();
        }
        return manager;
    }

    private Connection connection = null;
    private PreparedStatement preparedStment = null;
    private Statement statement = null;
    private ResultSet result = null;

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(
            "jdbc:postgresql://database-1.cuodwo1rggyl.us-east-2.rds.amazonaws.com/", "postgres", "Senrac02!");
    }

    public String getUsername(String username) throws SQLException {
        String retrievedUsername = "";
        String selectQuery = "SELECT username FROM reimbursement_project.user WHERE username = '" + username + "'";
        statement = connection.createStatement();
        result = statement.executeQuery(selectQuery);
        while(result.next()) {
            retrievedUsername = result.getString("username");
        }
        return retrievedUsername;
    }

    public String getPassword(String password) throws SQLException {
        String retrievedPassword = "";
        String selectQuery = "SELECT password FROM reimbursement_project.user WHERE password = '" + password + "'";
        statement = connection.createStatement();
        result = statement.executeQuery(selectQuery);
        while (result.next()) {
            retrievedPassword = result.getString("password");
        }
        return retrievedPassword;
    }

    public String getFirstName(String firstName) throws SQLException {
        String retrievedFirstName = "";
        String selectQuery = "SELECT first_name FROM reimbursement_project.user WHERE first_name = '" + firstName + "'";
        statement = connection.createStatement();
        result = statement.executeQuery(selectQuery);
        while(result.next()) {
            retrievedFirstName = result.getString("first_name");
        }
        return retrievedFirstName;
    }

    public String getLastName(String lastName) throws SQLException
    {
        String retrievedLastName = "";
        String selectQuery = "SELECT last_name FROM reimbursement_project.user WHERE last_name = '" + lastName + "'";
        statement = connection.createStatement();
        result = statement.executeQuery(selectQuery);
        while(result.next()) {
            retrievedLastName = result.getString("last_name");
        }

        return retrievedLastName;
    }

    public String getRole(String role) throws SQLException {
        String retrievedRole = "";
        String selectQuery = "SELECT role FROM reimbursement_project.user WHERE role = '" + role + "'";
        statement = connection.createStatement();
        result = statement.executeQuery(selectQuery);
        while(result.next()) {
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

    public List<Manager> getAllManagers() throws SQLException {

        String sql = "SELECT * FROM reimbursement_project.user WHERE role = 'manager'";
        statement = connection.createStatement();
        result = statement.executeQuery(sql);
        List<Manager> retrievedManagers = new ArrayList<Manager>();
        Manager manager;

        while(result.next()) {
            manager = new Manager();
            manager.setFirstName(result.getString("first_name"));
            manager.setLastName(result.getString("last_name"));
            manager.setUsername(result.getString("username"));
            manager.setPassword((result.getString("password")));
            manager.setRole(result.getString("role"));

            retrievedManagers.add(manager);
        }

        return retrievedManagers;
    }


}
