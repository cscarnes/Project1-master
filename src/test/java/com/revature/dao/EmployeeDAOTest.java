package com.revature.dao;

import com.revature.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDAOTest {

    private static EmployeeDAO edao = EmployeeDAO.instance();

    @Test
    void instance() {
    }

    @Test
    void connect() {
    }

    @Test
    void getAllEmployees() throws SQLException {
        List<Employee> result = edao.getAllEmployees();

        Assertions.assertNotEquals(0, result.size());
    }

    @Test
    void getEmployeeById() throws SQLException {
        List<Employee> employees = edao.getAllEmployees();
        Employee updateMe = employees.get(employees.size()-1);
        //   Employee result = edao.getEmployeeById(updateMe.getClass());
    }
}