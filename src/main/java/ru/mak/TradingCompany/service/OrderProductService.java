package ru.mak.tradingCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mak.tradingCompany.entity.OrderProduct;
import ru.mak.tradingCompany.repo.OrderProductRepo;
import ru.mak.tradingCompany.repo.OrderRepo;
import ru.mak.tradingCompany.repo.ProductRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class OrderProductService {
	@Autowired
    OrderProductRepo orderProductRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    OrderRepo orderRepo;

    public OrderProduct getById(Long id) {
        try {
            return orderProductRepo.getReferenceById(id);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public OrderProduct save(OrderProduct orderProduct, Long orderId, Long productId) {
        try {
            orderProduct.setOrder(orderRepo.getReferenceById(orderId));
            orderProduct.setProduct(productRepo.getReferenceById(productId));
        } catch (EntityNotFoundException e) {
            return null;
        }
        return orderProductRepo.save(orderProduct);
    }

    public void delete(Long id) {
        orderProductRepo.deleteById(id);
    }

    public List<OrderProduct> getAll() {
        return orderProductRepo.findAll();
    }
}
