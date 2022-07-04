package ru.mak.tradingCompany.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.tradingCompany.entity.Client;

public interface ClientRepo extends JpaRepository<Client, Long> {
}
