package com.example.financeapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "wastes")
@Getter
@Setter
public class WasteEntity {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "wastes_wasteid_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    private Long wasteid;

    @ManyToOne
    @JoinColumn(name = "userid")
    private PersonEntity person;

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
