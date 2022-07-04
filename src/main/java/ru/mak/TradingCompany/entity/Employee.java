package ru.mak.TradingCompany.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@Getter
@Setter
@ToString
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
