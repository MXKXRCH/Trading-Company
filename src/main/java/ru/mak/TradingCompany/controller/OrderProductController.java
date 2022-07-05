package ru.mak.tradingCompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mak.tradingCompany.dto.OrderProductDto;
import ru.mak.tradingCompany.service.OrderProductService;

import java.util.List;

@RestController
@RequestMapping(path = "/orderProducts", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderProductController {
    @Autowired
    OrderProductService orderProductService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderProductDto> getOrderProduct(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        OrderProductDto orderProduct = orderProductService.getById(id);
        if (orderProduct == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderProduct, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderProductDto> saveOrderProduct(@RequestBody OrderProductDto orderProduct,
                                                            @RequestParam Long orderId,
                                                            @RequestParam Long productId) {
        if (orderProduct == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        orderProduct = orderProductService.save(orderProduct, orderId, productId);
        if (orderProduct == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderProduct, new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<OrderProductDto> updateOrderProduct(@RequestBody OrderProductDto orderProduct,
                                                              @RequestParam Long orderId,
                                                              @RequestParam Long productId) {
        if (orderProduct == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        orderProduct = orderProductService.save(orderProduct, orderId, productId);
        if (orderProduct == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderProduct, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderProductDto> deleteOrderProduct(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        OrderProductDto orderProduct = orderProductService.getById(id);
        if (orderProduct == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        orderProductService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderProductDto>> getAllOrderProducts() {
        List<OrderProductDto> orderProducts = orderProductService.getAll();
        if (orderProducts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderProducts, HttpStatus.OK);
    }
}
