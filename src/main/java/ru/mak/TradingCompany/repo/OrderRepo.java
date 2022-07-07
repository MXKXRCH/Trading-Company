package ru.mak.tradingCompany.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.tradingCompany.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {
    @Override
    Page<Order> findAll(Pageable pageable);
}
