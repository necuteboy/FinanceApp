package com.example.financeapp.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "currency")
@Getter
@Setter
public class CurrencyEntity {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "currency_currencyid_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    private Long currencyid;

    @Column(name = "currency")
    private String currency;
    @OneToMany(mappedBy = "currencyid", cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<IncomeEntity> incomes;

    @OneToMany(mappedBy = "currencyid", cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<WasteEntity> wastes;
}
