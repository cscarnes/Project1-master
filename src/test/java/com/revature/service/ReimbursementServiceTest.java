package com.revature.service;

import com.revature.model.Reimbursement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReimbursementServiceTest {

    private static ReimbursementService rserv = ReimbursementService.getRserv();

    @Test
    void createReimbursement() throws SQLException {
        Reimbursement r;
        r = new Reimbursement(10,
                "2021-10-29",
                0,
                "2021-10-29",
                "Test",
                "Manager Note",
                "Phil",
                "Hartman"
        );

        Reimbursement result = rserv.createReimbursement(r);

        Assertions.assertNotEquals(0, result.getAmount());
    }

    @Test
    void getAllReimbursement() throws SQLException {
        List<Reimbursement> reimbursements = rserv.getAllReimbursement();

        Assertions.assertNotEquals(0, reimbursements.size());
    }

    @Test
    void getReimbursementsApproved() throws SQLException {
        List<Reimbursement> result = rserv.getReimbursementsApproved();

        Assertions.assertNotEquals(0, result.size());
    }

    @Test
    void getReimbursementsDenied() throws SQLException {
        List<Reimbursement> result = rserv.getReimbursementsDenied();

        Assertions.assertNotEquals(0, result.size());
    }

    @Test
    void updateReimbursement() throws SQLException {
        List<Reimbursement> reimbursements = rserv.getAllReimbursement();
        Reimbursement updateMe = reimbursements.get(reimbursements.size()-1);
        updateMe.setEmployee_note("Test");
        Reimbursement result = rserv.updateReimbursement(updateMe);

        Assertions.assertEquals("Test",result.getEmployee_note());
    }
}