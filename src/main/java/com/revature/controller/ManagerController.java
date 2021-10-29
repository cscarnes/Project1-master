package com.revature.controller;

import com.google.gson.Gson;
import com.revature.dao.ManagerDAO;
import com.revature.model.Manager;
import com.revature.service.ManagerService;
import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.List;

public class ManagerController {

    private static ManagerService mserv = ManagerService.getMserv();
    private static Gson gson = new Gson();

    public static Handler getAllManagers = (ctx) -> {
//		Can have query to search
        String firstName = ctx.queryParam("first_name");
        String lastName = ctx.queryParam("last_name");
        String username = ctx.queryParam("username");

        List<Manager> managers = new ArrayList<Manager>();

        if (firstName != null) {
            managers.add(mserv.getManagerByName(firstName, lastName));
        } else if (username != null) {
            managers.add(mserv.getManagerByUsername(username));
        } else {
            managers = mserv.getAllManagers();
        }

        String json = gson.toJson(managers);
        ctx.result(json);
        ctx.status(200);
    };




}
