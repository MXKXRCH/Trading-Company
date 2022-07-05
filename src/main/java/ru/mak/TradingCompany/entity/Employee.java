package ru.mak.tradingCompany.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mak.tradingCompany.dto.EmployeeDto;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor(access= AccessLevel.PROTECTED, force=true)
@Entity
@Table(name = "employee")
public class Employee extends Base {
    @Column(name = "phone")
    private String phone;

    @Column(name = "name")
    private String name;

    @Column(name = "job_title")
    private String jobTitle;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private Set<Order> orders;

    public Employee(EmployeeDto employeeDto) {
        this.setId(employeeDto.getId());
        this.phone = employeeDto.getPhone();
        this.name = employeeDto.getName();
        this.jobTitle = employeeDto.getJobTitle();
    }

    public EmployeeDto toEmployeeDto() {
        return new EmployeeDto(this);
    }
}
