package com.revature.main;

import com.revature.controller.EmployeeController;
import com.revature.controller.ReimbursementController;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.ReimbursementDAO;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.SQLException;
//import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Logger log = Logger.getLogger(Main.class.getName());
        PropertyConfigurator.configure("src/log4j.properties");

        //Log in console in and log file
        log.debug("Log4j appender configuration is successful !!");

       // Logger log = Logger.getLogger(Main.class.getName());
        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
            config.addStaticFiles("/public", Location.CLASSPATH);
        }).start(7000);
        log.info("App running");

        ReimbursementDAO.getRDAO().connect();
        EmployeeDAO.instance().connect();

        app.get("/user/:username", EmployeeController.getEmployeeByUsername);

        app.get("/user", EmployeeController.getAllEmployees);

        app.post("reimbursement", ReimbursementController.createReimbursement);

        app.get("/reimbursement", ReimbursementController.getAllReimbursements);

        app.put("/reimbursement/:status", ReimbursementController.updateReimbursement);



        


    }
}
