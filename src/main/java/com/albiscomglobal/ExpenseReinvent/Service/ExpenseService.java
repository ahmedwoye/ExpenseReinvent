package com.albiscomglobal.ExpenseReinvent.Service;

import com.albiscomglobal.ExpenseReinvent.Entity.Expense;

import java.util.List;

public interface ExpenseService {

    List<Expense> getAllExpense();

    Expense getSingleExpense(Long id);

    void deleteSingleExpense(Long id);

    Expense saveSingleExpense(Expense expense);

    Expense updateSingleeExpense (Expense expense, Long id);
}
