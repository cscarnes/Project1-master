# Reimbursement Project

The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

## Technologies Used

- Java 
- JavaScript 
- HTML 
- CSS 
- JDBC 
- PostgreSQL 
- Javalin 
- Maven 
- JUnit4 
- Log4J 
- Intellij IDEA

## Features

Employees can login to make reimbursement requests or view status of previous requests.
Managers can approve or deny requests as well as view a list of all current and previous reimbursement requests.

## Usage

To use the application, run App.java file contained in the com.revature.app package.\
Navigate to the index.html page to use the login page.\
Logging in as a user or manager requires that a manager or user entry is already created in your database.
You can create the database locally or host it on a remote server, but you must use Postgres as your database.\
Reimbursement requests are created on the employee page. Each requests needs an amount and a reason for the request.\
Requests can be viewed from the manager page where they can be approved or denied.\
Denied requests must also have a reason.
