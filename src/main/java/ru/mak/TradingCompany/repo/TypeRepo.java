package ru.mak.tradingCompany.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.tradingCompany.entity.Type;

public interface TypeRepo extends JpaRepository<Type, Long> {
    @Override
    Page<Type> findAll(Pageable pageable);
}
