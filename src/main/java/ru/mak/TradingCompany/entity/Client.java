package ru.mak.tradingCompany.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mak.tradingCompany.dto.ClientDto;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor(access= AccessLevel.PROTECTED, force=true)
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

    public Client(ClientDto clientDto) {
        this.setId(clientDto.getId());
        this.phone = clientDto.getPhone();
        this.name = clientDto.getName();
        this.address = clientDto.getAddress();
    }

    public ClientDto toClientDto() {
        return new ClientDto(this);
    }
}
