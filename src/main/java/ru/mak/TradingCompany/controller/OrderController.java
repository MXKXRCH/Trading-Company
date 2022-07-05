package ru.mak.tradingCompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mak.tradingCompany.entity.Order;
import ru.mak.tradingCompany.service.OrderService;

import java.util.List;

@RestController
@RequestMapping(path = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") Long id) {
        if (id == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Order order = orderService.getById(id);
        if (order == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody Order order,
                                           @RequestParam Long clientId,
                                           @RequestParam Long employeeId) {
        if (order == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        orderService.save(order, clientId, employeeId);
        return new ResponseEntity<>(order, new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Order> updateOrder(@RequestBody Order order,
                                             @RequestParam Long clientId,
                                             @RequestParam Long employeeId) {
        if (order == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        orderService.save(order, clientId, employeeId);
        return new ResponseEntity<>(order, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> deleteOrder(@PathVariable("id") Long id) {
        if (id == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Order order = orderService.getById(id);
        if (order == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        orderService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAll();
        if (orders.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
