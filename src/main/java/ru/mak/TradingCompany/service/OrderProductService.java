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
        OrderProduct orderProduct = orderProductRepo.findById(id).orElse(null);
        return (orderProduct == null) ? null : orderProduct.toOrderProductDto();
    }

    public OrderProductDto save(OrderProductDto orderProduct, Long orderId, Long productId) {
        Order order = orderRepo.findById(orderId).orElse(null);
        Product product = productRepo.findById(productId).orElse(null);
        return (order == null || product == null) ? null :
        orderProductRepo.save(new OrderProduct(orderProduct, order, product)).toOrderProductDto();
    }

    public void delete(Long id) {
       orderProductRepo.delete(id);
    }

    public List<OrderProductDto> getAll() {
        return orderProductRepo.findAll().stream().map(OrderProduct::toOrderProductDto).collect(Collectors.toList());
    }
}
