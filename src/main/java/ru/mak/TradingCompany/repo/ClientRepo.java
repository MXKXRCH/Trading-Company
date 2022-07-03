package ru.mak.TradingCompany.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.TradingCompany.entity.Client;

public interface ClientRepo extends JpaRepository<Client, Long> {
}
