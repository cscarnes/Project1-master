package com.revature.controller;

import com.google.gson.Gson;
import com.revature.model.Reimbursement;
import com.revature.service.ReimbursementService;
import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.List;

public class ReimbursementController {

    private static ReimbursementService rserv = ReimbursementService.getRserv();
    private static Gson gson = new Gson();

    public static Handler createReimbursement = (ctx) -> {
        String body = ctx.body();

        try {
            Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
            if (reimbursement != null) {
                Reimbursement returned = rserv.createReimbursement(reimbursement);
                ctx.result(gson.toJson(returned));
                ctx.status(200);
            } else
                ctx.status(404);

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
        String employee = ctx.queryParam("username");
        String approvalStatus = ctx.queryParam("status");

        List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
        if (employee != null) {
            reimbursements = rserv.getReimbursementByEmployee(employee);
        }
        else if (approvalStatus != null) {
            if (approvalStatus.compareToIgnoreCase("APPROVED") == 0)
                reimbursements = rserv.getReimbursementsApproved();

            if (approvalStatus.compareToIgnoreCase("PENDING") == 0)
                reimbursements = rserv.getReimbursementsDenied();
        }
         else
            reimbursements = rserv.getAllReimbursement();

        String json = gson.toJson(reimbursements);
        ctx.result(json);
        ctx.status(200);
    };
}
