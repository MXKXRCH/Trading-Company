package ru.mak.TradingCompany.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "order")
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@Getter
@Setter
@ToString
public class Order extends Base {
    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "completed_date")
    private Date completedDate;

    @Column(name = "total_price")
    private Float totalPrice;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private Set<OrderProduct> orderProducts;

    public void updateTotalPrice() {
        totalPrice = 0f;
        for (OrderProduct orderProduct : orderProducts) {
            totalPrice += orderProduct.getAmount() * orderProduct.getProduct().getPrice();
        }
    }
}
