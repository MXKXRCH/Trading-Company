package ru.mak.tradingCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mak.tradingCompany.dto.OrderDto;
import ru.mak.tradingCompany.entity.Client;
import ru.mak.tradingCompany.entity.Employee;
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

    public OrderDto save(OrderDto order, Long clientId, Long employeeId) {
        try {
            Client client = clientRepo.getReferenceById(clientId);
            Employee employee = employeeRepo.getReferenceById(employeeId);
            return orderRepo.save(new Order(order, employee, client)).toOrderDto();
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public void delete(Long id) {
        orderRepo.deleteById(id);
    }

    public List<OrderDto> getAll() {
        return orderRepo.findAll().stream().map(Order::toOrderDto).collect(Collectors.toList());
    }
}
