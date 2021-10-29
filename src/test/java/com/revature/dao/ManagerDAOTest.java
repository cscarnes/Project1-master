package com.revature.dao;

import com.revature.model.Manager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManagerDAOTest {

    private ManagerDAO mdao = ManagerDAO.instance();
    @Test
    @Order(1)
    void getUsername() {
        Manager manager = new Manager(1, "test", "test",
                "test@test.com", "username", "password", "manager");
        Assertions.assertEquals("username", manager.getUsername());
    }

    @Test
    @Order(2)
    void getPassword() {
        Manager manager = new Manager(1, "test", "test",
                "test@test.com", "username", "password", "manager");
        Assertions.assertEquals("password", manager.getPassword());
    }

    @Test
    @Order(3)
    void getFirstName() {
        Manager manager = new Manager(1, "test", "test",
                "test@test.com", "username", "password", "manager");
        Assertions.assertEquals("username", manager.getUsername());
    }

    @Test
    @Order(4)
    void getLastName() {
        Manager manager = new Manager(1, "test", "test",
                "test@test.com", "username", "password", "manager");
        Assertions.assertEquals("username", manager.getUsername());
    }

    @Test
    @Order(5)
    void getRole() {
        Manager manager = new Manager(1, "test", "test",
                "test@test.com", "username", "password", "manager");
        Assertions.assertEquals("manager", manager.getRole());
    }


    @Test
    @Order(6)
    void getAllManagers() throws SQLException {
        List<Manager> result = mdao.getAllManagers();
        Assertions.assertNotEquals(0, result.size());
    }
}