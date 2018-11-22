package com.xing.gccars.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "CARS")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    private String description;

    private BigDecimal price;

    @ManyToMany(mappedBy = "cars")
    private List<User> users;

    @OneToMany(mappedBy = "car")
    private List<BorrowedDate> borrowedDates;
}
