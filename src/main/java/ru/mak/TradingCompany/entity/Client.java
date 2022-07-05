package ru.mak.tradingCompany.entity;

import lombok.Getter;
import lombok.Setter;
import ru.mak.tradingCompany.dto.ClientDto;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client extends Base {
    @Column(name = "phone")
    private String phone;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client", fetch = FetchType.LAZY)
    private Set<Order> orders;

    public ClientDto toClientDto() {
        return new ClientDto(this);
    }
}
