package com.example.financeapp.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "categories")
@Setter
@Getter
public class CategoryEntity {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "categories_categoryid_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    private int categoryid;
    @Column(name = "category")
    private String category;

    @OneToMany(mappedBy = "categoryid", cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<IncomeEntity> incomes;

    @OneToMany(mappedBy = "categoryid", cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<WasteEntity> wastes;
}
