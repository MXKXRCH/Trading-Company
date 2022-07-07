package ru.mak.tradingCompany.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.mak.tradingCompany.entity.Client;

public interface ClientRepo extends JpaRepository<Client, Long> {
    @Override
    Page<Client> findAll(Pageable pageable);
}
