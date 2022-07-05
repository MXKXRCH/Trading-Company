package ru.mak.tradingCompany.entity;

import lombok.Getter;
import lombok.Setter;
import ru.mak.tradingCompany.dto.OrderDto;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ordering")
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
    private Set<OrderProduct> orderProducts;

    public OrderDto toOrderDto() {
        return new OrderDto(this);

    }
}
