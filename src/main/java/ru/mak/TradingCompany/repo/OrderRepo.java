package ru.mak.TradingCompany.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.TradingCompany.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
