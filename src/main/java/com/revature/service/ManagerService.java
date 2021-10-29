package com.revature.service;

import com.revature.dao.ManagerDAO;
import com.revature.model.Manager;

import java.sql.SQLException;
import java.util.List;

public class ManagerService {

    private ManagerDAO mdao = ManagerDAO.instance();

    private static ManagerService mserv;

    private ManagerService() {
    }

    public static ManagerService getMserv() {
        if (mserv == null)
            mserv = new ManagerService();

        return mserv;
    }

    public Manager getManagerByName(String firstName, String lastName) throws SQLException {

        List<Manager> managers = mdao.getAllManagers();
        for (Manager m : managers) {

            if (m.getFirstName().compareToIgnoreCase(firstName) == 0
            && m.getLastName().compareToIgnoreCase(lastName) == 0) {
                return m;
            }
        }
        return null;
    }

    public Manager getManagerByUsername(String username) throws SQLException {
        List<Manager> managers = mdao.getAllManagers();
        for (Manager m : managers) {
            if (m.getUsername().compareToIgnoreCase(username) == 0) {
                return  m;
            }
        }
        return null;
    }

    public List<Manager> getAllManagers() throws SQLException {
        return mdao.getAllManagers();
    }

}
