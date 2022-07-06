package ru.mak.tradingCompany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.mak.tradingCompany.entity.Type;

import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class TypeDto extends BaseDto {
    @Size(min=3, max=64, message = "Minimum symbols: 3\nMaximum symbols: 64")
    private String name;

    public TypeDto(Type type) {
        this.setId(type.getId());
        this.name = type.getName();
    }
}
