package ru.mak.TradingCompany.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.TradingCompany.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
