package ru.mak.tradingCompany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.mak.tradingCompany.entity.Product;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ProductDto extends BaseDto {
    private String name;
    private BigDecimal price;
    private String typeName;

    public ProductDto(Product product) {
        this.setId(product.getId());
        this.name = product.getName();
        this.price = product.getPrice();
        this.setTypeName(product.getType().getName());
    }
}
