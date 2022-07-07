package ru.mak.tradingCompany.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.mak.tradingCompany.entity.OrderProduct;

import javax.transaction.Transactional;

public interface OrderProductRepo extends JpaRepository<OrderProduct, Long> {
    @Modifying
    @Transactional
    @Query("delete from OrderProduct o where o.id = ?1")
    void delete(Long entityId);

    @Override
    Page<OrderProduct> findAll(Pageable pageable);
}
