package com.revature.service;

import com.revature.dao.ReimbursementDAO;
import com.revature.model.Reimbursement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementService {

    private static ReimbursementDAO rdao = ReimbursementDAO.getRDAO();
    private static EmployeeService employeeService = EmployeeService.getEService();
    private static ReimbursementService rserv;

    private ReimbursementService() {
    }

    public static ReimbursementService getRserv() {
        if (rserv == null)
            rserv = new ReimbursementService();
        return rserv;
    }

    public Reimbursement createReimbursement(Reimbursement reimbursement) throws SQLException {
        return rdao.createReimbursement(reimbursement);
    }

    public Reimbursement getReimbursement(String username) throws SQLException {
        return rdao.getReimbursement(username);
    }

    public List<Reimbursement> getReimbursementByEmployee(String firstName) throws SQLException {
        List<Reimbursement> filterMe = rserv.getAllReimbursement();
        List<Reimbursement> result = new ArrayList<Reimbursement>();
        for (Reimbursement r : filterMe) {
            if (r.getFirstName() == firstName)
                result.add(r);
        }

        return result;
    }

    public List<Reimbursement> getAllReimbursement() throws SQLException {
        return rdao.getAllReimbursement();
    }

    public List<Reimbursement> getReimbursementsApproved() throws SQLException {
        List<Reimbursement> filterMe = rserv.getAllReimbursement();
        List<Reimbursement> result = new ArrayList<Reimbursement>();
        for (Reimbursement r : filterMe) {
            if (r.getStatus() > 0)
                result.add(r);
        }

        return result;
    }

    public List<Reimbursement> getReimbursementsDenied() throws SQLException {
        List<Reimbursement> filterMe = rserv.getAllReimbursement();
        List<Reimbursement> result = new ArrayList<Reimbursement>();
        for (Reimbursement r : filterMe) {
            if (r.getStatus() < 1)
                result.add(r);
        }

        return result;
    }

    public Reimbursement updateReimbursement(Reimbursement reimbursement) throws SQLException {
        return rdao.updateReimbursement(reimbursement);
    }


}
