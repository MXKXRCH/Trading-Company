package ru.mak.tradingCompany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.mak.tradingCompany.entity.OrderProduct;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class OrderProductDto extends BaseDto {
    private OrderDto orderDto;
    private ProductDto productDto;

    @NotNull
    @Min(value = 1, message = "Amount must be greater or equals than 1")
    private Integer amount;

    public OrderProductDto(OrderProduct orderProduct) {
        this.setId(orderProduct.getId());
        this.orderDto = orderProduct.getOrder().toOrderDto();
        this.productDto = orderProduct.getProduct().toProductDto();
        this.amount = orderProduct.getAmount();
    }
}
