package ru.mak.TradingCompany.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "order_product")
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@Getter
@Setter
@ToString
public class OrderProduct extends Base {
    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Column(name = "amount")
    private Float amount;
}
