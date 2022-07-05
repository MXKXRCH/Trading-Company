package ru.mak.tradingCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mak.tradingCompany.entity.Employee;
import ru.mak.tradingCompany.repo.EmployeeRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public Employee getById(Long id) {
        try {
            return employeeRepo.getReferenceById(id);
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

    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }
}
