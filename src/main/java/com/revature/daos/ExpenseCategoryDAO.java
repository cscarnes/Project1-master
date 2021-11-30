package com.revature.daos;

import java.util.List;

import com.revature.entities.ExpenseCategory;

public interface ExpenseCategoryDAO {
//    CRUD ops

	ExpenseCategory createExpenseCategory(ExpenseCategory expenseCategory);

//    READ
	ExpenseCategory getExpenseCategoryById(int cid);

	List<ExpenseCategory> getAllExpenseCategories();

//    UPDATE
	ExpenseCategory updateExpenseCategory(ExpenseCategory expenseCategory);

//    DELETE
	boolean deleteExpenseCategory(ExpenseCategory expenseCategory);

}
