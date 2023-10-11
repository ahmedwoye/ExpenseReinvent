package com.albiscomglobal.ExpenseReinvent.Repository;

import com.albiscomglobal.ExpenseReinvent.Entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
