package ru.mak.tradingCompany.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mak.tradingCompany.dto.OrderDto;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor(access= AccessLevel.PROTECTED, force=true)
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

    public Order(OrderDto orderDto, Employee employee, Client client) {
        this.setId(orderDto.getId());
        this.createdDate = orderDto.getCreatedDate();
        this.completedDate = orderDto.getCompletedDate();
        this.employee = employee;
        this.client = client;
    }

    public OrderDto toOrderDto() {
        return new OrderDto(this);
    }
}
