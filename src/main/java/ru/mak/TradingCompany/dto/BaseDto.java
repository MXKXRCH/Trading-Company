package ru.mak.tradingCompany.dto;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class BaseDto {
    private Long id;
}
