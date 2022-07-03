package ru.mak.TradingCompany.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.TradingCompany.entity.Type;

public interface TypeRepo extends JpaRepository<Type, Long> {
}
