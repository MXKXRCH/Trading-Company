package ru.mak.tradingCompany.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.tradingCompany.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    @Override
    Page<Employee> findAll(Pageable pageable);
}
