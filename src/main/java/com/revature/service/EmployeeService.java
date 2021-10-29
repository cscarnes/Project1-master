package com.revature.service;

import com.revature.dao.EmployeeDAO;
import com.revature.model.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    private static EmployeeService eService = null;

    private EmployeeDAO eDAO;

    private EmployeeService() {
    }

    public static EmployeeService getEService() {
        if(eService == null)
            eService = new EmployeeService();

        return eService;
    }

    public Employee getEmployeeByUsername(String username) throws SQLException {
        List<Employee> employees = eDAO.getAllEmployees();
        for (Employee e : employees) {
            if (e.getUsername().compareToIgnoreCase(username) == 0)
                return e;
        }
        return  null;
    }

    public Employee getEmployeeById(int eid) throws SQLException {
        return eDAO.getEmployeeById(eid);
    }

    public Employee getEmployeeByName(String firstName, String lastName) throws SQLException {
        List<Employee> employees = eDAO.getAllEmployees();
        for(Employee e : employees) {
            if (e.getFirstName().compareToIgnoreCase(firstName) == 0
                    && e.getLastName().compareToIgnoreCase(lastName) == 0)
                return e;
        }
        return null;
    }

    public List<Employee> getAllEmployees() throws SQLException { return eDAO.getAllEmployees();}
}
