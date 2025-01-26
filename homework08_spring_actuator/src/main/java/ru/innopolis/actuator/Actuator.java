package ru.innopolis.actuator;

import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.innopolis.repository.OrderRepository;

@Component
public class Actuator {

    @Bean
    public MeterBinder countOrder(OrderRepository orderRepository){
        return meterRegistry -> meterRegistry.gauge("method_order_count_all", orderRepository.count());
    }

    @Bean
    public MeterBinder sumAvg(OrderRepository orderRepository){
        System.out.println(orderRepository.sum().getClass().getSimpleName());
        System.out.println(orderRepository.sum());
        return meterRegistry -> meterRegistry.gauge("method_order_sum_avg", orderRepository.sum());
    }

}
