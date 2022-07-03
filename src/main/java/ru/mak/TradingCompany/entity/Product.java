package ru.mak.TradingCompany.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@Getter
@Setter
@ToString
public class Product extends Base {
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Float price;

    @ManyToOne
    @JoinColumn(name="type_id")
    private Type type;

    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orderProducts;
}
