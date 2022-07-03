package ru.mak.TradingCompany.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.TradingCompany.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
