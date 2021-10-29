package com.revature.dao;

import com.revature.model.Reimbursement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReimbursementDAOTest {

    private static ReimbursementDAO rdao = ReimbursementDAO.getRDAO();


    @Test
    void connect() {
    }

    @Test
    void getRDAO() {
    }

    @Test
    void createReimbursement() {
    }

    @Test
    void getAllReimbursement() {
    }

    @Test
    void getReimbursement() {
    }

    @Test
    void getReimbursementByEmployee() {
    }

    @Test
    void deleteReimbursement() throws SQLException {
        List<Reimbursement> reimbursements = rdao.getAllReimbursement();
        Reimbursement deleteMe = rdao.getReimbursement(reimbursements.get(reimbursements.size()-1).getFirstName());

        boolean result = rdao.deleteReimbursement(deleteMe);

        Assertions.assertEquals(true, result);
    }
}