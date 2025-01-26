package ru.innopolis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.dto.Order;
import ru.innopolis.repository.OrderRepository;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/")
public class OrderController {

    private final OrderRepository productRepository;

    @PostMapping()
    public void createOrders(){
        productRepository.create();
    }

    @GetMapping("/all")
    public List<Order> getOrders(){
        return productRepository.orders();
    }

    @GetMapping("/count")
    public Long getCount(){
        return productRepository.count();
    }

    @GetMapping("/sum")
    public Double getSumAvg(){
        return productRepository.sum();
    }

}
