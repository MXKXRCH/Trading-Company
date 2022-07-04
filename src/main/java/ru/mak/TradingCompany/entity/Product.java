package ru.mak.tradingCompany.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "product_tb")
public class Product extends Base {
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Float price;

    @ManyToOne
    @JoinColumn(name="type_id")
    private Type type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Set<OrderProduct> orderProducts;
}
