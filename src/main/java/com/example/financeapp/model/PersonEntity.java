package com.example.financeapp.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class PersonEntity {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "users_userid_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    private Long userid;
    @Column(name = "login")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "phonenum")
    private String phoneNumber;
    @OneToMany(mappedBy = "userid", cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<IncomeEntity> incomes;

    @OneToMany(mappedBy = "person", cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<WasteEntity> wastes;

}
