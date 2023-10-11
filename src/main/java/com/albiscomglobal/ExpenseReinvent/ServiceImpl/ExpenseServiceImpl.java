package com.albiscomglobal.ExpenseReinvent.ServiceImpl;

import com.albiscomglobal.ExpenseReinvent.Entity.Expense;
import com.albiscomglobal.ExpenseReinvent.Repository.ExpenseRepository;
import com.albiscomglobal.ExpenseReinvent.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<Expense> getAllExpense() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense getSingleExpense(Long id) {
        Optional<Expense> hyat = expenseRepository.findById(id);
        if(hyat.isPresent()){
            return hyat.get();
        }
        throw new RuntimeException("The expense cannot be found with this id : " + id);
    }

    @Override
    public void deleteSingleExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public Expense saveSingleExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense updateSingleeExpense(Expense expense, Long id) {
        Expense existingexpense = getSingleExpense(id);
        existingexpense.setName(expense.getName() !=null ? existingexpense.getName() : expense.getName());
        existingexpense.setAmount(expense.getAmount() !=null ? existingexpense.getAmount() : expense.getAmount());
        existingexpense.setCategory(expense.getCategory() !=null ? existingexpense.getCategory() : expense.getCategory());
        existingexpense.setDescription(expense.getDescription() !=null ? existingexpense.getDescription() : expense.getDescription());
        existingexpense.setDate(expense.getDate() !=null ? existingexpense.getDate() : expense.getDate());
        return expenseRepository.save(expense);
    }
}
