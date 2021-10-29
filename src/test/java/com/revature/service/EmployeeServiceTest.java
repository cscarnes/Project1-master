package com.revature.service;

import com.revature.dao.EmployeeDAO;
import com.revature.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    private static EmployeeService eserv = EmployeeService.getEService();


    @Test
    void getEmployeeByUsername() throws SQLException {
        Employee result = eserv.getEmployeeByUsername("phartman");

        Assertions.assertEquals("phartman", result.getUsername());
    }


    @Test
    void getEmployeeByName() throws SQLException {
        Employee result = eserv.getEmployeeByName("Phil", "Hartman");

        Assertions.assertEquals("Phil", result.getFirstName());
    }

    @Test
    void getAllEmployees() throws SQLException {
        List<Employee> employees = eserv.getAllEmployees();

        Assertions.assertNotEquals(0, employees.size());
    }
}