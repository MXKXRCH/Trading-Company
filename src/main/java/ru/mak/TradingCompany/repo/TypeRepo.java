package ru.mak.tradingCompany.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.tradingCompany.entity.Type;

public interface TypeRepo extends JpaRepository<Type, Long> {
}
