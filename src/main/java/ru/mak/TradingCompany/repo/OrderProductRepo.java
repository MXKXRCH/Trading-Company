package ru.mak.tradingCompany.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.tradingCompany.entity.OrderProduct;

public interface OrderProductRepo extends JpaRepository<OrderProduct, Long> {
}
