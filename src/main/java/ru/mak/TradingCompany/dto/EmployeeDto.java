package ru.mak.tradingCompany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.mak.tradingCompany.entity.Employee;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class EmployeeDto extends BaseDto {
    private String phone;
    private String name;
    private String jobTitle;

    public EmployeeDto(Employee employee) {
        this.setId(employee.getId());
        this.phone = employee.getPhone();
        this.name = employee.getName();
        this.jobTitle = employee.getJobTitle();
    }
}
