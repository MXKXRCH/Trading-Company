package ru.mak.tradingCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.mak.tradingCompany.dto.OrderDto;
import ru.mak.tradingCompany.entity.Client;
import ru.mak.tradingCompany.entity.Employee;
import ru.mak.tradingCompany.entity.Order;
import ru.mak.tradingCompany.repo.ClientRepo;
import ru.mak.tradingCompany.repo.EmployeeRepo;
import ru.mak.tradingCompany.repo.OrderRepo;

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
        Order order = orderRepo.findById(id).orElse(null);
        return (order == null) ? null : order.toOrderDto();
    }

    public OrderDto save(OrderDto order, Long clientId, Long employeeId) {
        Client client = clientRepo.findById(clientId).orElse(null);
        Employee employee = employeeRepo.findById(employeeId).orElse(null);
        return (client == null || employee == null) ? null
        : orderRepo.save(new Order(order, employee, client)).toOrderDto();
    }

    public void delete(Long id) {
        orderRepo.deleteById(id);
    }

    public List<OrderDto> getAll(Pageable pageable) {
        return orderRepo.findAll(pageable).stream().map(Order::toOrderDto).collect(Collectors.toList());
    }
}
