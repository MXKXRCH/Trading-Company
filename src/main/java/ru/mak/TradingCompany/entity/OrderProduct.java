package ru.mak.tradingCompany.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mak.tradingCompany.dto.OrderProductDto;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(access= AccessLevel.PROTECTED, force=true)
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

    public OrderProduct(OrderProductDto orderProductDto, Order order, Product product) {
        this.setId(orderProductDto.getId());
        this.amount = orderProductDto.getAmount();
        this.order = order;
        this.product = product;
    }

    public OrderProductDto toOrderProductDto() {
        return new OrderProductDto(this);
    }
}
