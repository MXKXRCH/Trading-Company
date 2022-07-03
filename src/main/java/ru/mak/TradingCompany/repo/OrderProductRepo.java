package ru.mak.TradingCompany.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.TradingCompany.entity.OrderProduct;

public interface OrderProductRepo extends JpaRepository<OrderProduct, Long> {
}
