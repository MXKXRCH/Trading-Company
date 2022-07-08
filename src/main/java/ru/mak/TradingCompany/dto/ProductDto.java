package ru.mak.tradingCompany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.mak.tradingCompany.entity.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ProductDto extends BaseDto {
    @NotNull
    @Size(min=3, max=64, message = "Minimum symbols: 3\nMaximum symbols: 64")
    private String name;

    @NotNull
    @Min(value = 1, message = "Price must be greater or equals 1")
    private BigDecimal price;

    private String typeName;

    public ProductDto(Product product) {
        this.setId(product.getId());
        this.name = product.getName();
        this.price = product.getPrice();
        this.setTypeName(product.getType().getName());
    }
}
