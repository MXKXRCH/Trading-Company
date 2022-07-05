package ru.mak.tradingCompany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.mak.tradingCompany.entity.Client;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ClientDto extends BaseDto {
    private String phone;
    private String name;
    private String address;

    public ClientDto(Client client) {
        this.setId(client.getId());
        this.phone = client.getPhone();
        this.name = client.getName();
        this.address = client.getAddress();
    }
}
