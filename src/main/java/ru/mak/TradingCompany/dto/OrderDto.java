package ru.mak.tradingCompany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.mak.tradingCompany.entity.Order;
import ru.mak.tradingCompany.entity.OrderProduct;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class OrderDto extends BaseDto {
    @NotBlank
    @Past(message = "Created date must be less or equals than today's date")
    private Date createdDate;

    @NotBlank
    @Past(message = "Created date must be less or equals than today's date")
    private Date completedDate;

    private BigDecimal totalPrice;
    private String clientName;
    private String employeeName;

    public OrderDto(Order order) {
        this.setId(order.getId());
        this.createdDate = order.getCreatedDate();
        this.completedDate = order.getCompletedDate();
        this.clientName = order.getClient().getName();
        this.employeeName = order.getEmployee().getName();
        this.totalPrice = new BigDecimal(0);

        for (OrderProduct orderProduct : order.getOrderProducts()) {
            this.totalPrice = this.totalPrice.add(orderProduct.getProduct().getPrice()
                                  .multiply(new BigDecimal(orderProduct.getAmount())));
        }
    }
}
