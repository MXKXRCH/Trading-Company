package ru.mak.tradingCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mak.tradingCompany.dto.OrderProductDto;
import ru.mak.tradingCompany.entity.Order;
import ru.mak.tradingCompany.entity.OrderProduct;
import ru.mak.tradingCompany.entity.Product;
import ru.mak.tradingCompany.repo.OrderProductRepo;
import ru.mak.tradingCompany.repo.OrderRepo;
import ru.mak.tradingCompany.repo.ProductRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderProductService {
	@Autowired
    OrderProductRepo orderProductRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    OrderRepo orderRepo;

    public OrderProductDto getById(Long id) {
        try {
            return orderProductRepo.getReferenceById(id).toOrderProductDto();
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public OrderProductDto save(OrderProductDto orderProduct, Long orderId, Long productId) {
        try {
            Order order = orderRepo.getReferenceById(orderId);
            Product product = productRepo.getReferenceById(productId);
            return orderProductRepo.save(new OrderProduct(orderProduct, order, product)).toOrderProductDto();
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public void delete(Long id) {
       orderProductRepo.delete(id);
    }

    public List<OrderProductDto> getAll() {
        return orderProductRepo.findAll().stream().map(OrderProduct::toOrderProductDto).collect(Collectors.toList());
    }
}
