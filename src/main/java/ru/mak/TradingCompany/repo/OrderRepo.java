package ru.mak.tradingCompany.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.tradingCompany.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
