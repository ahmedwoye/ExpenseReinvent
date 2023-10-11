package com.albiscomglobal.ExpenseReinvent.Controller;

import com.albiscomglobal.ExpenseReinvent.Entity.Expense;
import com.albiscomglobal.ExpenseReinvent.Repository.ExpenseRepository;
import com.albiscomglobal.ExpenseReinvent.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EntityController {

    @Autowired
   private ExpenseService expenseService;

    @GetMapping("/expense")
    public ResponseEntity<List<Expense>> getAllExpenses(){
       return new ResponseEntity<List<Expense>>(expenseService.getAllExpense(), HttpStatus.OK);
     }


     @GetMapping("/expense/{id}")
     public ResponseEntity<Expense> getSingleExpense(@PathVariable Long id){
          return new ResponseEntity<Expense>(expenseService.getSingleExpense(id), HttpStatus.OK);

     }

     @PostMapping("/expense")
     public ResponseEntity<Expense> saveSingleExpense(@RequestBody Expense expense){
        return new ResponseEntity<Expense>(expenseService.saveSingleExpense(expense), HttpStatus.CREATED);
     }

     @DeleteMapping("/expense/{id}")
     public void deleteSingleExpense(@RequestParam Long id){
         expenseService.deleteSingleExpense(id);
     }

     @PutMapping("/expense")
     public Expense updateSingleExpense(@RequestBody Expense expense, @PathVariable Long id){
        expense.setId(id);
        return expenseService.saveSingleExpense(expense);
     }

}
