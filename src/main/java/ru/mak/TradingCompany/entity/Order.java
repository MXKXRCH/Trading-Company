package ru.mak.tradingCompany.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "order_tb")
public class Order extends Base {
    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "completed_date")
    private Date completedDate;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private Set<OrderProduct> orderProducts;

    public float updateTotalPrice() {
        float totalPrice = 0f;
        for (OrderProduct orderProduct : orderProducts) {
            totalPrice += orderProduct.getAmount() * orderProduct.getProduct().getPrice();
        }
        return totalPrice;
    }
}
