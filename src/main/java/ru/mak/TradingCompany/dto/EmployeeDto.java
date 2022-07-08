package ru.mak.tradingCompany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.mak.tradingCompany.entity.Employee;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class EmployeeDto extends BaseDto {
    @NotNull
    @Pattern(regexp = "\\+7[0-9]{10}", message = "Phone format: +7**********, where * is digit")
    private String phone;

    @NotNull
    @Size(min=3, max=64, message = "Minimum symbols: 3\nMaximum symbols: 64")
    private String name;

    @NotNull
    @Size(min=3, max=255)
    private String jobTitle;

    public EmployeeDto(Employee employee) {
        this.setId(employee.getId());
        this.phone = employee.getPhone();
        this.name = employee.getName();
        this.jobTitle = employee.getJobTitle();
    }
}
