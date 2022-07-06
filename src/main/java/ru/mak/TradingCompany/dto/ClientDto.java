package ru.mak.tradingCompany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.mak.tradingCompany.entity.Client;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ClientDto extends BaseDto {
    @Pattern(regexp = "\\+7[0-9]{10}", message = "Phone format: +7**********, where * is digit")
    private String phone;

    @Size(min=3, max=64, message = "Minimum symbols: 3\nMaximum symbols: 64")
    private String name;

    @Size(min=5, max=255, message = "Minimum symbols: 3\nMaximum symbols: 255")
    private String address;

    public ClientDto(Client client) {
        this.setId(client.getId());
        this.phone = client.getPhone();
        this.name = client.getName();
        this.address = client.getAddress();
    }
}
