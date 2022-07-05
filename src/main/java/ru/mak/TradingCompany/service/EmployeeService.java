package ru.mak.tradingCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mak.tradingCompany.dto.EmployeeDto;
import ru.mak.tradingCompany.entity.Employee;
import ru.mak.tradingCompany.repo.EmployeeRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public EmployeeDto getById(Long id) {
        try {
            return employeeRepo.getReferenceById(id).toEmployeeDto();
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public void save(Employee employee) {
        employeeRepo.save(employee);
    }

    public void delete(Long id) {
        employeeRepo.deleteById(id);
    }

    public List<EmployeeDto> getAll() {
        return employeeRepo.findAll().stream().map(Employee::toEmployeeDto).collect(Collectors.toList());
    }
}
