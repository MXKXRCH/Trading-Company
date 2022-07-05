package ru.mak.tradingCompany.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mak.tradingCompany.dto.TypeDto;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor(access= AccessLevel.PROTECTED, force=true)
@Entity
@Table(name = "product_type")
public class Type extends Base {
    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type", fetch = FetchType.LAZY)
    private Set<Product> products;

    public Type(TypeDto typeDto) {
        this.setId(typeDto.getId());
        this.name = typeDto.getName();
    }

    public TypeDto toTypeDto() {
        return new TypeDto(this);
    }
}
