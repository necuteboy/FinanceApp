package com.example.financeapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "incomes")
@Getter
@Setter
public class IncomeEntity {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "incomes_incomeid_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    private Long incomeid;

    @ManyToOne
    @JoinColumn(name = "userid")
    private PersonEntity userid;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private CategoryEntity categoryid;

    @ManyToOne
    @JoinColumn(name = "currencyid")
    private CurrencyEntity currencyid;

    @Column(name = "sum")
    private Double sum;

    @Column(name = "created_at")
    private LocalDateTime createdAt;


}
