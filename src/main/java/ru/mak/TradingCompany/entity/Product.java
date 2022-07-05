package ru.mak.tradingCompany.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<OrderProduct> orderProducts;
}
