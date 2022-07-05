package ru.mak.tradingCompany.entity;

import lombok.Getter;
import lombok.Setter;
import ru.mak.tradingCompany.dto.ProductDto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product extends Base {
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name="type_id")
    private Type type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.LAZY)
    private Set<OrderProduct> orderProducts;

    public ProductDto toProductDto() {
        return new ProductDto(this);
    }
}
