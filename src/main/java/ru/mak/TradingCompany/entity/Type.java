package ru.mak.TradingCompany.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_type")
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@Getter
@Setter
@ToString
public class Type extends Base {
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "type")
    private List<Product> products;
}
