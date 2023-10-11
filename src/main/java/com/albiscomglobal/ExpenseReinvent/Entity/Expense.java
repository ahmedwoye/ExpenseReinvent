package com.albiscomglobal.ExpenseReinvent.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="tbl_expenses")
public class Expense {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name="expense_name")
    private String name;
    private String description;

    @Column(name="expense_amount")
    private BigDecimal amount;
    private String category;
    private Date date;
}
