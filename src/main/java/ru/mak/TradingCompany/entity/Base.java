package ru.mak.TradingCompany.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "order")
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@Getter
@Setter
@ToString
public class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
