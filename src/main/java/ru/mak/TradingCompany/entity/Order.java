package ru.mak.tradingCompany.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<OrderProduct> orderProducts;

    public float updateTotalPrice() {
        float totalPrice = 0f;
        for (OrderProduct orderProduct : orderProducts) {
            totalPrice += orderProduct.getAmount() * orderProduct.getProduct().getPrice();
        }
        return totalPrice;
    }
}
