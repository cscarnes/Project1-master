package com.revature.controller;

import com.google.gson.Gson;
import com.revature.model.Reimbursement;
import com.revature.service.ReimbursementService;
import com.revature.util.LoggerUtil;
import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ReimbursementController {

    private static ReimbursementService rserv = ReimbursementService.getRserv();
    private static Gson gson = new Gson();
    public static Logger log = Logger.getLogger(ReimbursementController.class.getName());

    public static Handler createReimbursement = (ctx) -> {
        String body = ctx.body();

        try {
            Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
            if (reimbursement != null) {
                Reimbursement returned = rserv.createReimbursement(reimbursement);
                ctx.result(gson.toJson(returned));
                ctx.status(200);
                log.info("record created");
            } else {
                ctx.status(404);
                log.info("Not found");
            }

        } catch (Exception e) {
            ctx.status(404);
            e.printStackTrace();
        }

    };

    public static Handler getReimbursementByUsername = (ctx) -> {
        String username = ctx.pathParam("username");

        try {
            Reimbursement reimbursement = rserv.getReimbursement(username);
            String json = gson.toJson(reimbursement);
            ctx.result(json);
            ctx.status(200);
        } catch (NumberFormatException e) {
            ctx.status(404);
            e.printStackTrace();
        }
    };

    public static Handler getAllReimbursements = (ctx) -> {
//		Can have query to search
        String employee = ctx.queryParam("first_name");
        String approvalStatus = ctx.queryParam("status");

        List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
        if (employee != null) {
            reimbursements = rserv.getReimbursementByEmployee(employee);
            log.info("record found");
        }/*
        else if (approvalStatus != null) {
            if (approvalStatus.compareToIgnoreCase("APPROVED") == 0)
                reimbursements = rserv.getReimbursementsApproved();

            if (approvalStatus.compareToIgnoreCase("PENDING") == 0)
                reimbursements = rserv.getReimbursementsDenied();
        }
        */
         else {
            reimbursements = rserv.getAllReimbursement();

        }

        String json = gson.toJson(reimbursements);
        ctx.result(json);
        ctx.status(200);
    };

    public static Handler updateReimbursement = (ctx) -> {
        String body = ctx.body();
        Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
        Reimbursement result = rserv.updateReimbursement(reimbursement);

        ctx.result(gson.toJson(result));
        ctx.status(202);

    };
}
