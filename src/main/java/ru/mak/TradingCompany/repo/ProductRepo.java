package ru.mak.tradingCompany.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.tradingCompany.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
    @Override
    Page<Product> findAll(Pageable pageable);
}
