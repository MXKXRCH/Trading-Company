package ru.mak.tradingCompany.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "employee_tb")
public class Employee extends Base {
    @Column(name = "phone")
    private String phone;

    @Column(name = "name")
    private String name;

    @Column(name = "job_title")
    private String jobTitle;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Set<Order> orders;
}
