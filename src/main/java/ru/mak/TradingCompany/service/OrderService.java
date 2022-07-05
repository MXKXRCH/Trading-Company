package ru.mak.tradingCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mak.tradingCompany.dto.OrderDto;
import ru.mak.tradingCompany.entity.Order;
import ru.mak.tradingCompany.repo.ClientRepo;
import ru.mak.tradingCompany.repo.EmployeeRepo;
import ru.mak.tradingCompany.repo.OrderRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
	@Autowired
    OrderRepo orderRepo;
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    EmployeeRepo employeeRepo;

    public OrderDto getById(Long id) {
        try {
            return orderRepo.getReferenceById(id).toOrderDto();
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public Order save(Order order, Long clientId, Long employeeId) {
        try {
            order.setClient(clientRepo.getReferenceById(clientId));
            order.setEmployee(employeeRepo.getReferenceById(employeeId));
        } catch (EntityNotFoundException e) {
            return null;
        }
        return orderRepo.save(order);
    }

    public void delete(Long id) {
        orderRepo.deleteById(id);
    }

    public List<OrderDto> getAll() {
        return orderRepo.findAll().stream().map(Order::toOrderDto).collect(Collectors.toList());
    }
}
