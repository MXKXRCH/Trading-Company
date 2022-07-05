package ru.mak.tradingCompany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.mak.tradingCompany.entity.Type;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class TypeDto extends BaseDto {
    private String name;

    public TypeDto(Type type) {
        this.setId(type.getId());
        this.name = type.getName();
    }
}
