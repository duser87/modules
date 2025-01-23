package ru.innopolis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.dto.Order;
import ru.innopolis.repository.OrderRepository;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class ProductController {

    private final OrderRepository productRepository;

    @GetMapping("/all")
    public List<Order> getOrders(){
        return productRepository.getOrders();
    }

    @GetMapping("/count")
    public Long getCount(){
        return productRepository.getCountOrders();
    }

    @GetMapping("/sum")
    public Long getSum(){
        return productRepository.getSumOrders();
    }

}
