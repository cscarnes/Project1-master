package com.revature.main;

import com.revature.controller.EmployeeController;
import com.revature.controller.ReimbursementController;
import com.revature.dao.EmployeeDAO;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
            config.addStaticFiles("/public", Location.CLASSPATH);
        }).start(7000);


        app.get("/user/:username", EmployeeController.getEmployeeByUsername);

        app.get("/user", EmployeeController.getAllEmployees);

        app.post("reimbursement", ReimbursementController.createReimbursement);

        app.get("/reimbursement", ReimbursementController.getAllReimbursements);

        //app.put("status/{id}", ReimbursementController.approve);

        //app.put("deny/{id}", ReimbursementController.);



        


    }
}
