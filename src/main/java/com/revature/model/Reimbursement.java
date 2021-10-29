package com.revature.model;

public class Reimbursement {
    private float amount;
    private String submit_date;
    private int status;
    private String status_date;
    private String employee_note;
    private String manager_note;
    private String firstName;
    private String lastName;

    public Reimbursement() {}

    public Reimbursement(float amount, String submit_date, int status, String status_date, String employee_note,
                         String manager_note, String firstName, String lastName) {
        this.amount = amount;
        this.submit_date = submit_date;
        this.status = status;
        this.status_date = status_date;
        this.employee_note = employee_note;
        this.manager_note = manager_note;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getSubmit_date() {
        return submit_date;
    }

    public void setSubmit_date(String submit_date) {
        this.submit_date = submit_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatus_date() {
        return status_date;
    }

    public void setStatus_date(String status_date) {
        this.status_date = status_date;
    }

    public String getEmployee_note() {
        return employee_note;
    }

    public void setEmployee_note(String employee_note) {
        this.employee_note = employee_note;
    }

    public String getManager_note() {
        return manager_note;
    }

    public void setManager_note(String manager_note) {
        this.manager_note = manager_note;
    }
}
