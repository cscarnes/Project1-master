package com.revature.service;

import com.revature.model.Manager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManagerServiceTest {

    private static ManagerService mserv = ManagerService.getMserv();

    @Test
    void getManagerByName() throws SQLException {
        Manager result = mserv.getManagerByName("One", "Two");

        Assertions.assertEquals("One", result.getFirstName());
    }

    @Test
    void getManagerByUsername() throws SQLException {
        Manager result = mserv.getManagerByUsername("Bob");
        Assertions.assertEquals("Bob", result.getUsername());
    }

    @Test
    void getAllManagers() throws SQLException {
        List<Manager> managers = mserv.getAllManagers();

        Assertions.assertNotEquals(0, managers.size());
    }
}