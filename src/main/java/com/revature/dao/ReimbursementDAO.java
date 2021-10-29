package com.revature.dao;

import com.revature.model.Reimbursement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDAO {

    private Connection connection = null;
    private PreparedStatement preparedStment = null;
    private Statement statement = null;
    private ResultSet result = null;

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(
                "jdbc:postgresql://database-1.cuodwo1rggyl.us-east-2.rds.amazonaws.com/", "postgres", "Senrac02!");
    }

    private static ReimbursementDAO rDAO = null;

    private ReimbursementDAO(){}

    public static ReimbursementDAO getRDAO() {
        if (rDAO == null)
            rDAO = new ReimbursementDAO();

        return rDAO;
    }

    public Reimbursement createReimbursement(Reimbursement reimbursement) throws SQLException {
        String sql = "INSERT INTO reimbursement_project.reimbursement VALUES (?,?,?,?,?)";
        preparedStment = connection.prepareStatement(sql);
        preparedStment.setString(1, reimbursement.getFirstName());
        preparedStment.setString(2, reimbursement.getLastName());
        preparedStment.setDouble(3, reimbursement.getAmount());
        preparedStment.setString(4, reimbursement.getEmployee_note());
        preparedStment.setInt(5, reimbursement.getStatus());
        preparedStment.setString(6, reimbursement.getSubmit_date());
        preparedStment.setString(7, reimbursement.getManager_note());
        preparedStment.setString(4, reimbursement.getSubmit_date());
        preparedStment.execute();

        return reimbursement;
    }

    public List<Reimbursement> getAllReimbursement() throws SQLException {
        String sql = "SELECT * FROM reimbursement_project.reimbursement";
        preparedStment = connection.prepareStatement(sql);

        result = preparedStment.executeQuery();
        List<Reimbursement> reimbursements = new ArrayList<>();
        Reimbursement reimbursement;
        while(result.next()) {
            reimbursement = new Reimbursement();
            reimbursement.setFirstName(result.getString("first_name"));
            reimbursement.setLastName(result.getString("last_name"));
            reimbursement.setAmount(result.getFloat("reimbursement_amount"));
            reimbursement.setEmployee_note(result.getString("reason"));
            reimbursement.setStatus(result.getInt("status"));
            reimbursement.setSubmit_date(result.getString("date"));
            reimbursement.setManager_note(result.getString("manager_note"));

        }

        return reimbursements;
    }

    public Reimbursement getReimbursement(String username) throws SQLException {
            String sql = "SELECT * FROM project1_db.REIMBURSEMENT WHERE username = ?";
            preparedStment = connection.prepareStatement(sql);
            result = preparedStment.executeQuery();
            result.next();

            Reimbursement reimbursement = new Reimbursement();
            reimbursement.setAmount(result.getFloat("amount"));
            reimbursement.setSubmit_date(result.getString("submit_date"));
            reimbursement.setStatus(result.getInt("status"));
            reimbursement.setStatus_date(result.getString("status_date"));
            reimbursement.setEmployee_note(result.getString("employee_note"));
            reimbursement.setManager_note(result.getString("manager_note"));

            return reimbursement;
    }


    public void deleteReimbursement(Reimbursement reimbursement) throws SQLException {
        String sql = "DELETE FROM reimbursement_project.reimbursement WHERE username = ?";
        preparedStment = connection.prepareStatement(sql);
        result = preparedStment.executeQuery();
    }

    public Reimbursement updateReimbursement(Reimbursement reimbursement) throws SQLException {
            String sql = "UPDATE REIMBURSEMENT SET amount=?,status=?,status_date=?," +
                    "employee_note=?,manager_note=? WHERE username = ?";
            preparedStment = connection.prepareStatement(sql);

            preparedStment.setDouble(1, reimbursement.getAmount());
            preparedStment.setString(2, reimbursement.getSubmit_date().toString());
            preparedStment.setInt(2, reimbursement.getStatus());
            preparedStment.setString(3, reimbursement.getStatus_date().toString());
            preparedStment.setString(4, reimbursement.getEmployee_note());
            preparedStment.setString(5, reimbursement.getManager_note());
            if (preparedStment.executeUpdate() > 0) {
                return reimbursement;
            }

        return null;
    }

}
