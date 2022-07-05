package ru.mak.tradingCompany.entity;

import lombok.Getter;
import lombok.Setter;
import ru.mak.tradingCompany.dto.OrderProductDto;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "order_product")
public class OrderProduct extends Base {
    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Column(name = "amount")
    private Integer amount;

    public OrderProductDto toOrderProductDto() {
        return new OrderProductDto(this);
    }
}
