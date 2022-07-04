package ru.mak.tradingCompany.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.tradingCompany.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
