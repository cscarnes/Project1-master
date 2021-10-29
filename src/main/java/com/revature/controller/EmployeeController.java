package com.revature.controller;


import com.revature.model.Employee;
import com.revature.service.EmployeeService;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import com.google.gson.Gson;

import java.util.*;

public class EmployeeController {

    private static EmployeeService eService = EmployeeService.getEService();
    private static Gson gson = new Gson();

    public static Handler getEmployeeById = (ctx) -> {
        String eid = ctx.pathParam("eid");

        try {
            Employee employee = eService.getEmployeeById(Integer.parseInt(eid));
            String json = gson.toJson(employee);
            ctx.result(json);
            ctx.status(200);
        } catch (NumberFormatException e) {
            ctx.status(404);
            e.printStackTrace();
        }
    };

    public static Handler getEmployeeByUsername = (ctx) -> {
        String username = ctx.pathParam("username");

        try {
            Employee employee = eService.getEmployeeByUsername(username);
            String json = gson.toJson(employee);
            ctx.result(json);
            ctx.status(200);
        } catch (Exception e) {
            ctx.status(404);
            e.printStackTrace();
        }
    };

    public static Handler getAllEmployees = (ctx) -> {
//		Can have query to search 
        String firstName = ctx.queryParam("first_name");
        String lastName = ctx.queryParam("last_name");
        String username = ctx.queryParam("username");

        List<Employee> employees = new ArrayList<Employee>();

        if (firstName != null) {
            employees.add(eService.getEmployeeByName(firstName, lastName));
        } else if (username != null) {
            employees.add(eService.getEmployeeByUsername(username));
        } else {
            employees = eService.getAllEmployees();
        }

        String json = gson.toJson(employees);
        ctx.result(json);
        ctx.status(200);
    };


    
}
