package ru.mak.tradingCompany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.mak.tradingCompany.entity.OrderProduct;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class OrderProductDto extends BaseDto {
    private OrderDto orderDto;
    private ProductDto productDto;
    private Integer amount;

    public OrderProductDto(OrderProduct orderProduct) {
        this.setId(orderProduct.getId());
        this.orderDto = orderProduct.getOrder().toOrderDto();
        this.productDto = orderProduct.getProduct().toProductDto();
        this.amount = orderProduct.getAmount();
    }
}
